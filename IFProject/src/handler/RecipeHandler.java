package handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import util.JdbcUtil;
import vo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RecipeHandler {
    private static RecipeHandler handler = new RecipeHandler();

    private RecipeHandler() {}

    public static RecipeHandler getHandler() {
        return handler;
    }


    public String getRecipeList(HttpServletRequest req) {
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
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("user_id");

            if(userId != null){
                String sql = "select recipe_id, thumbnail, title, likes, subtitle from if_recipe";

                String levels = req.getParameter("levels");

                if( levels != null) {
                    sql +=" where levels >= "+levels;
                }

                pstmt = conn.prepareStatement(sql);
                System.out.println(sql);
                rs = pstmt.executeQuery();

                ArrayList<RecipeListVO> datas = new ArrayList<>();

                while(rs.next()){
                    RecipeListVO vo = new RecipeListVO();

                    String user = "select nickname, is_editor from if_user where user_id="+userId;
                    pstmt = conn.prepareStatement(user);
                    ResultSet userRs = pstmt.executeQuery();
                    userRs.first();

                    vo.setRecipeId(rs.getInt("recipe_id"));
                    vo.setThumbnail(rs.getString("thumbnail"));
                    vo.setTitle(rs.getString("title"));
                    vo.setWriter(userRs.getString("nickname"));
                    vo.setIsEditor(userRs.getInt("is_editor"));
                    vo.setLikes(rs.getInt("likes"));
                    vo.setSubtitle(rs.getString("subtitle"));

                    int recipeId = rs.getInt("recipe_id");
                    String comment = "select count(*) as total from if_recipe_comm where recipe_id="+Integer.toString(recipeId);
                    pstmt = conn.prepareStatement(comment);

                    ResultSet commentRs = pstmt.executeQuery();
                    commentRs.first();
                    vo.setComments(commentRs.getInt("total"));
                    commentRs.close();
                    datas.add(vo);
                }

                pstmt.close();
                conn.close();
                rs.close();
                return gson.toJson(datas);
            }
            else{
                result.setState(false);
                result.setMsg("로그인 하지 않으셨습니다");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            result.setState(false);
            result.setMsg("DB Server Error");
        }
        return gson.toJson(result);
    }

    public String insertRecipe(HttpServletRequest req) {
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
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("user_id");

            if(userId != null){
                String thumbnail = req.getParameter("thumbnail");
                String title = req.getParameter("title");
                String content = req.getParameter("content");
                String subtitle = req.getParameter("subtitle");
                int level = Integer.parseInt(req.getParameter("levels"));

                if(title != null && content != null && subtitle != null && req.getParameter("levels") != null){
                    String sql = "insert into if_recipe(thumbnail, title, user_id, content, subtitle, levels) values (?,?,?,?,?,?)";

                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, thumbnail);
                    pstmt.setString(2, title);
                    pstmt.setInt(3, userId);
                    pstmt.setString(4,content);
                    pstmt.setString(5, subtitle);
                    pstmt.setInt(6, level);

                    System.out.println(sql);

                    pstmt.executeUpdate();


                    pstmt.close();
                    conn.close();

                    result.setState(true);
                    result.setMsg("등록 성공");
                    return gson.toJson(result);
                }
                else {
                    result.setState(false);
                    result.setMsg("모든 값을 입력하지 않으셨습니다");
                }
            }
            else{
                result.setState(false);
                result.setMsg("로그인 하지 않으셨습니다");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            result.setState(false);
            result.setMsg("DB Server Error");
        }
        return gson.toJson(result);
    }

    public String getRecipe(HttpServletRequest req) {
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
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("user_id");

            if(userId != null){
                RecipeVO vo = new RecipeVO();
                String recipeId = req.getParameter("recipe_id");
                String sql = "select recipe_id, thumbnail, title, write_date, user_id, likes, subtitle, levels from if_recipe where recipe_id= ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, recipeId);
                System.out.println(sql);
                rs = pstmt.executeQuery();

                rs.first();

                vo.setRecipeId(rs.getInt("recipe_id"));
                vo.setThumbnail(rs.getString("thumbnail"));
                vo.setTitle(rs.getString("title"));
                vo.setWriteDate(rs.getTimestamp("write_date"));
                vo.setLikes(rs.getInt("likes"));
                vo.setSubtitle(rs.getString("subtitle"));
                vo.setLevels(rs.getInt("levels"));

                String user = "select nickname, is_editor, thumbnail from if_user where user_id = ?";

                pstmt = conn.prepareStatement(user);
                pstmt.setInt(1, rs.getInt("user_id"));
                rs = pstmt.executeQuery();
                rs.first();

                vo.setNickname(rs.getString("nickname"));
                vo.setIsEditor(rs.getInt("is_editor"));
                vo.setUserThumb(rs.getString("thumbnail"));


                String comment = "select count(*) as total from if_recipe_comm where recipe_id=?";
                pstmt = conn.prepareStatement(comment);
                pstmt.setString(1, recipeId);
                rs = pstmt.executeQuery();
                rs.first();
                vo.setComments(rs.getInt("total"));

                rs.close();
                pstmt.close();
                conn.close();
                return gson.toJson(vo);
            }
            else{
                result.setState(false);
                result.setMsg("로그인 하지 않으셨습니다");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            result.setState(false);
            result.setMsg("서버 에러 또는 존재하지 않는 게시물 입니다.");
        }
        return gson.toJson(result);
    }

    public String deleteRecipe(HttpServletRequest req) {
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
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("user_id");

            if(userId != null){
                String recipeId = req.getParameter("recipe_id");
                String sql = "select user_id from if_recipe where recipe_id = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, recipeId);
                System.out.println(sql);
                rs = pstmt.executeQuery();

                rs.first();

                int realUser = rs.getInt("user_id");

                if(realUser == userId){
                    String delete = "delete from if_recipe where recipe_id= ?";
                    pstmt = conn.prepareStatement(delete);
                    pstmt.setString(1, recipeId);
                    pstmt.executeUpdate();

                    result.setState(true);
                    result.setMsg("삭제 성공");
                }
                else {
                    result.setState(false);
                    result.setMsg("잘못된 요청입니다.");
                }
                rs.close();
                pstmt.close();
                conn.close();
                return gson.toJson(result);
            }
            else{
                result.setState(false);
                result.setMsg("로그인 하지 않으셨습니다");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            result.setState(false);
            result.setMsg("서버 에러 또는 존재하지 않는 게시물 입니다.");
        }
        return gson.toJson(result);
    }
    public String likeRecipe(HttpServletRequest req) {
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
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("user_id");

            if(userId != null){
                String recipeId = req.getParameter("recipe_id");
                if(session.getAttribute("like"+recipeId) == null){
                    String sql = "update if_recipe set likes = likes+1 where recipe_id = ?";

                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, recipeId);
                    pstmt.executeUpdate();
                    session.setAttribute("like"+recipeId, "true");

                    result.setState(true);
                    result.setMsg("좋아요 체크");
                }
                else{
                    String sql = "update if_recipe set likes = likes-1 where recipe_id = ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, recipeId);
                    pstmt.executeUpdate();
                    session.removeAttribute("like"+recipeId);

                    result.setState(true);
                    result.setMsg("좋아요 해제");
                }
                pstmt.close();
                conn.close();
                return gson.toJson(result);
            }
            else{
                result.setState(false);
                result.setMsg("로그인 하지 않으셨습니다");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            result.setState(false);
            result.setMsg("서버 에러 또는 존재하지 않는 게시물 입니다.");
        }
        return gson.toJson(result);
    }


    public String getComments(HttpServletRequest req) {
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
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("user_id");
            String recipeId = req.getParameter("recipe_id");

            if(userId != null){
                String sql = "select comment_id, user_id, recipe_id, content from if_recipe_comm where recipe_id=?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, recipeId);

                System.out.println(sql);
                rs = pstmt.executeQuery();

                ArrayList<RecipeCommentVO> datas = new ArrayList<>();

                while(rs.next()){
                    RecipeCommentVO vo = new RecipeCommentVO();

                    String user = "select nickname, is_editor, thumbnail from if_user where user_id="+userId;
                    pstmt = conn.prepareStatement(user);
                    ResultSet userRs = pstmt.executeQuery();
                    userRs.first();

                    vo.setCommentId(rs.getInt("comment_id"));
                    vo.setUserId(rs.getInt("user_id"));
                    vo.setRecipeId(rs.getInt("recipe_id"));
                    vo.setContent(rs.getString("content"));
                    vo.setThumbnail(userRs.getString("thumbnail"));
                    vo.setNickname(userRs.getString("nickname"));
                    vo.setIsEditor(userRs.getInt("is_editor"));

                    userRs.close();
                    datas.add(vo);
                }

                pstmt.close();
                conn.close();
                rs.close();
                return gson.toJson(datas);
            }
            else{
                result.setState(false);
                result.setMsg("로그인 하지 않으셨습니다");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            result.setState(false);
            result.setMsg("DB Server Error");
        }
        return gson.toJson(result);
    }

    public String deleteComment(HttpServletRequest req) {
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
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("user_id");

            if(userId != null){
                String commentId = req.getParameter("comment_id");
                String sql = "select user_id from if_recipe_comm where comment_id = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, commentId);
                System.out.println(sql);
                rs = pstmt.executeQuery();

                rs.first();

                int realUser = rs.getInt("user_id");

                if(realUser == userId){
                    String delete = "delete from if_recipe_comm where comment_id= ?";
                    pstmt = conn.prepareStatement(delete);
                    pstmt.setString(1, commentId);
                    pstmt.executeUpdate();

                    result.setState(true);
                    result.setMsg("삭제 성공");
                }
                else {
                    result.setState(false);
                    result.setMsg("잘못된 요청입니다.");
                }
                rs.close();
                pstmt.close();
                conn.close();
                return gson.toJson(result);
            }
            else{
                result.setState(false);
                result.setMsg("로그인 하지 않으셨습니다");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            result.setState(false);
            result.setMsg("서버 에러 또는 존재하지 않는 게시물 입니다.");
        }
        return gson.toJson(result);
    }

    public String insertComment(HttpServletRequest req) {
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
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("user_id");

            if(userId != null){
                String content = req.getParameter("content");
                String recipeId = req.getParameter("recipe_id");

                if(content != null){
                    String sql = "insert into if_recipe_comm(user_id, recipe_id, content) values (?,?,?)";

                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, userId);
                    pstmt.setString(2, recipeId);
                    pstmt.setString(3,content);


                    System.out.println(sql);

                    pstmt.executeUpdate();


                    pstmt.close();
                    conn.close();

                    result.setState(true);
                    result.setMsg("등록 성공");
                    return gson.toJson(result);
                }
                else {
                    result.setState(false);
                    result.setMsg("모든 값을 입력하지 않으셨습니다");
                }
            }
            else{
                result.setState(false);
                result.setMsg("로그인 하지 않으셨습니다");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            result.setState(false);
            result.setMsg("DB Server Error");
        }
        return gson.toJson(result);
    }

    public String getBestRecipe(HttpServletRequest req) {
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
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("user_id");

            if(userId != null){
                RecipeVO vo = new RecipeVO();
                String recipeId = req.getParameter("recipe_id");
                String sql = "select recipe_id, thumbnail, title, write_date, user_id, likes, subtitle, levels from if_recipe order by likes desc";

                pstmt = conn.prepareStatement(sql);
                System.out.println(sql);
                rs = pstmt.executeQuery();

                rs.first();

                vo.setRecipeId(rs.getInt("recipe_id"));
                vo.setThumbnail(rs.getString("thumbnail"));
                vo.setTitle(rs.getString("title"));
                vo.setWriteDate(rs.getTimestamp("write_date"));
                vo.setLikes(rs.getInt("likes"));
                vo.setSubtitle(rs.getString("subtitle"));
                vo.setLevels(rs.getInt("levels"));

                String user = "select nickname, is_editor, thumbnail from if_user where user_id = ?";

                pstmt = conn.prepareStatement(user);
                pstmt.setInt(1, rs.getInt("user_id"));
                rs = pstmt.executeQuery();
                rs.first();

                vo.setNickname(rs.getString("nickname"));
                vo.setIsEditor(rs.getInt("is_editor"));
                vo.setUserThumb(rs.getString("thumbnail"));


                String comment = "select count(*) as total from if_recipe_comm where recipe_id=?";
                pstmt = conn.prepareStatement(comment);
                pstmt.setString(1, recipeId);
                rs = pstmt.executeQuery();
                rs.first();
                vo.setComments(rs.getInt("total"));

                rs.close();
                pstmt.close();
                conn.close();
                return gson.toJson(vo);
            }
            else{
                result.setState(false);
                result.setMsg("로그인 하지 않으셨습니다");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            result.setState(false);
            result.setMsg("서버 에러 또는 존재하지 않는 게시물 입니다.");
        }
        return gson.toJson(result);
    }

}
