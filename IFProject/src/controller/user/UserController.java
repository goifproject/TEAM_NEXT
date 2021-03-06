package controller.user;

import handler.UserHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/user_info")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Headers", "origin, x-requested-with, content-type, accept");
        resp.setContentType("application/json; charset=utf-8");
        
        PrintWriter out = resp.getWriter();

        UserHandler userHandler = UserHandler.getHandler();
        
        String result = userHandler.getUserData(req.getSession());
        out.println(result);
    }
}
