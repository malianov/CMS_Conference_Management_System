package controller;

import controller.command.Command;
import controller.command.CommandFactory;
import controller.command.util.CommandUtil;
import model.exception.NotFoundCommandException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Servlet.java -> inside doGet");
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Servlet.java -> inside doPost");
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String path = req.getRequestURI();
        System.out.println("Servlet.java -< path = " + path);
        try {
            System.out.println("Servlet.java -> inside try");
            if (path.contains("view")) {
                System.out.println("Servlet.java -> inside if");
                System.out.println("Servlet.java -> path is = " + path);
                path = path.substring(path.indexOf("view") - 1);
                System.out.println("Servlet.java -> path is = " + path);
            } else {
                System.out.println("Servlet.java -> inside else");
                throw new NotFoundCommandException();
            }
            Command command = CommandFactory.getCommand(path);
            command.execute(req, resp);
        } catch (NotFoundCommandException ex) {
            System.out.println("Servlet.java -> inside catch");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/not_found_page.jsp");
        }
    }
}
