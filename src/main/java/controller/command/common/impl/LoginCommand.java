package controller.command.common.impl;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.entity.User;
import model.exception.ServiceException;
import model.service.ServiceFactory;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("LoginCommand.java -> inside execute");

        String login    = request.getParameter("login").trim();
        String password = request.getParameter("password");

        ServiceFactory serviceFactory   = ServiceFactory.getInstance();
        UserService userService         = serviceFactory.getUserService();

        try {
            System.out.println("LoginCommand.java -> inside try");
            User user = userService.findUserByLoginAndPassword(login, password);
            request.getSession().setAttribute("user", user);
        } catch (ServiceException e) {
        }

        if (request.getSession().getAttribute("user") != null) {
            String path = "/WEB-INF/view/main_page.jsp";
            CommandUtil.goToPage(request, response, path);
        } else {
            request.setAttribute("wrongPassOrLogin", true);
            String path = "/";
            CommandUtil.goToPage(request, response, path);
        }
    }
}
