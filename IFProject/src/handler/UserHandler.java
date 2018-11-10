package handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import util.JdbcUtil;
import vo.MessageVO;
import vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserHandler {
	private static UserHandler handler = new UserHandler();
	
	private UserHandler() {}
	
	public static UserHandler getHandler() {
		return handler;
	}
	
	public String doLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
        Gson gson  = new GsonBuilder().disableHtmlEscaping().create();
        MessageVO result = new MessageVO();
        
        if(session.getAttribute("user_id") == null) {
        	String id = req.getParameter("userid");
            String password = req.getParameter("userpw");
        	
        	Connection conn = JdbcUtil.getConnection();

            PreparedStatement pstmt = null;
            ResultSet rs = null;

            if(conn == null){
            	result.setState(false);
                result.setMsg("DB Server Error");
                return gson.toJson(result);
            }

            try{
                String sql = "select * from if_user where id = ? and password = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.setString(2, password);

                rs = pstmt.executeQuery();

                rs.last();

                int count = rs.getRow();
                rs.beforeFirst();

                if(count == 1){
                    rs.first();
                    session.setAttribute("user_id", rs.getInt("user_id"));
                	
                	result.setState(true);
                	result.setMsg("로그인 성공");
                }
                else{
                    result.setState(false);
                    result.setMsg("Invaild value");
                }
                pstmt.close();
                rs.close();
                conn.close();
            }
            catch (Exception e){
            	e.printStackTrace();
            	result.setState(false);
            	result.setMsg("DB Server Error");
            }
        }
        else {
        	result.setState(false);
        	result.setMsg("Already logined");
        }
        return gson.toJson(result);
	}
	
	public String doLogout(HttpSession session) {
		Gson gson  = new GsonBuilder().disableHtmlEscaping().create();
        MessageVO result = new MessageVO();

        if(session.getAttribute("user_id") == null){
            result.setState(false);
            result.setMsg("로그인 하지 않으셨습니다");
            return gson.toJson(result);
        }
		
		try {
			session.invalidate();
			result.setState(true);
			result.setMsg("로그아웃 성공");
		}
		catch(Exception e) {
			e.printStackTrace();
			result.setState(false);
			result.setMsg("로그아웃 실패");
		}
		
		return gson.toJson(result);
		
	}
	
	public String getUserData(HttpSession session) {
        Connection conn = JdbcUtil.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        MessageVO result = new MessageVO();
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        
        if(conn == null){
            result.setState(false);
            result.setMsg("DB Server Error");
            return gson.toJson(result);
        }
        
        try{
            Integer userId = (Integer) session.getAttribute("user_id");

            if(userId != null){
                String sql = "select * from if_user where user_id = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userId);

                rs = pstmt.executeQuery();

                rs.last();

                int count = rs.getRow();
                rs.beforeFirst();

                if(count == 1){
                    rs.first();

                    UserVO vo = new UserVO();

                    vo.setNickname(rs.getString("nickname"));
                    vo.setIsEditor(rs.getInt("is_editor"));

                    return gson.toJson(vo);
                }
                else{
                    result.setState(false);
                    result.setMsg("잘못된 값입니다");
                }
            }
            else{
            	result.setState(false);
                result.setMsg("로그인 하지 않으셨습니다");
            }

            pstmt.close();
            conn.close();
            rs.close();
        }
        catch (Exception e){
        	e.printStackTrace();
        	result.setState(false);
        	result.setMsg("DB Server Error");
        }
        return gson.toJson(result);
	}

    public String doRegister(HttpServletRequest req) {
        Connection conn = JdbcUtil.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        MessageVO result = new MessageVO();
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        if(conn == null){
            result.setState(false);
            result.setMsg("DB Server Error");
            return gson.toJson(result);
        }

	    HttpSession session = req.getSession();

	    if(session.getAttribute("user_id") == null){
	        if(!req.getParameter("userid").equals("") && !req.getParameter("userpw").equals("") && !req.getParameter("nickname").equals("")){
                try{

                    String userId = req.getParameter("userid");
                    String userpw = req.getParameter("userpw");
                    String nickname = req.getParameter("nickname");

                    String sql = "select * from if_user where id = ?";

                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, userId);

                    rs = pstmt.executeQuery();

                    rs.last();

                    int count = rs.getRow();
                    rs.beforeFirst();

                    if(count == 0){
                        String insert = "insert into if_user(id, password, nickname) values (?, ?, ?)";

                        pstmt = conn.prepareStatement(insert);
                        pstmt.setString(1, userId);
                        pstmt.setString(2, userpw);
                        pstmt.setString(3, nickname);

                        pstmt.executeUpdate();

                        result.setState(true);
                        result.setMsg("회원가입 성공");

                        doLogin(req);
                    }
                    else{
                        result.setState(false);
                        result.setMsg("이미 존재하는 아이디입니다");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    result.setState(false);
                    result.setMsg("회원가입 실패");
                }
            }
            else {
                result.setState(false);
                result.setMsg("잘못된 요청입니다");
            }
        }
        else{
            result.setState(false);
            result.setMsg("이미 로그인 되었습니다");
        }

        try{
            pstmt.close();
            conn.close();
            rs.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return gson.toJson(result);
    }
}
