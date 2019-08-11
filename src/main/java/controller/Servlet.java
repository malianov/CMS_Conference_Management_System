package controller;

import controller.command.Command;
import controller.command.CommandFactory;
import controller.command.util.CommandUtil;
import model.exception.DAOException;
import model.exception.NotFoundCommandException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String path = req.getRequestURI();
        try {
            if (path.contains("view")) {
                path = path.substring(path.indexOf("view") - 1);
            } else {
                throw new NotFoundCommandException();
            }
            Command command = CommandFactory.getCommand(path);
            command.execute(req, resp);
        } catch (NotFoundCommandException | DAOException ex) {
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/not_found_page.jsp");
        }
    }
}
