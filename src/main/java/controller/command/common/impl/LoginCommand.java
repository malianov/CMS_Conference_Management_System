package controller.command.common.impl;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.entity.User;
import model.exception.ServiceException;
import model.service.ServiceFactory;
import model.service.UserService;
import model.validation.Validation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login    = request.getParameter("login").trim();
        String password = request.getParameter("password");

        request.getSession().setAttribute("search_user_id", "");
        request.getSession().setAttribute("search_user_login", "");
        request.getSession().setAttribute("search_user_name", "");
        request.getSession().setAttribute("search_user_surname", "");
        request.getSession().setAttribute("search_user_email", "");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        if(!Validation.isStringValid(login) || !Validation.isPasswordValid(password)) {
            request.setAttribute("wrongPassOrLogin", true);
            String path = "/";
            CommandUtil.goToPage(request, response, path);
        }

        try {
            User user = userService.findUserByLoginAndPassword(login, password);

            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("role", user.getRole());

        } catch (ServiceException e) {
        }

        if (request.getSession().getAttribute("user") != null) {
            String path = "/WEB-INF/view/common/main_page.jsp";
            CommandUtil.goToPage(request, response, path);
        } else {
            request.setAttribute("wrongPassOrLogin", true);
            String path = "/";
            CommandUtil.goToPage(request, response, path);
        }
    }
}