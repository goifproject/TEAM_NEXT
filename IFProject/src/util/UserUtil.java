package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import handler.MagzHandler;
import vo.MessageVO;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserUtil {
    private static UserUtil util = new UserUtil();

    private UserUtil() {}

    public static UserUtil getUtil() {
        return util;
    }

    public String getUserNickname(HttpSession session){
        if(session.getAttribute("user_id") != null) {
            Connection conn = JdbcUtil.getConnection();

            PreparedStatement pstmt = null;
            ResultSet rs = null;

            if(conn == null){
                return null;
            }
            try{
                String sql = "select nickname from if_user where user_id = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, session.getAttribute("user_id").toString());

                rs = pstmt.executeQuery();

                rs.last();

                int count = rs.getRow();
                rs.beforeFirst();

                if(count == 1){
                    rs.first();

                    return rs.getString("nickname");
                }
                else{
                    return null;
                }
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        else {
            return null;
        }
    }
    public int isEditor(HttpSession session){
        if(session.getAttribute("user_id") != null) {
            Connection conn = JdbcUtil.getConnection();

            PreparedStatement pstmt = null;
            ResultSet rs = null;

            if(conn == null){
                return -1;
            }
            try{
                String sql = "select is_editor from if_user where user_id = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, session.getAttribute("user_id").toString());

                rs = pstmt.executeQuery();

                rs.last();

                int count = rs.getRow();
                rs.beforeFirst();

                if(count == 1){
                    rs.first();

                    return rs.getInt("is_editor");
                }
                else{
                    return -1;
                }
            }
            catch (Exception e){
                e.printStackTrace();
                return -1;
            }
        }
        else {
            return -1;
        }
    }
}
