package controller.recipe;

import handler.RecipeHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/api/recipe_comment_delete")
public class RecipeCommentDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Headers", "origin, x-requested-with, content-type, accept");

        resp.setContentType("application/json; charset=utf-8");
        req.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        RecipeHandler recipeHandler = RecipeHandler.getHandler();

        String result = recipeHandler.deleteComment(req);
        out.print(result);
    }
}
