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
        //String desireToBeSpeaker = request.getParameter("desireToBeSpeaker");

        request.getSession().setAttribute("search_user_id", "");
        request.getSession().setAttribute("search_user_login", "");
        request.getSession().setAttribute("search_user_name", "");
        request.getSession().setAttribute("search_user_surname", "");
        request.getSession().setAttribute("search_user_email", "");

/*        request.getSession().setAttribute("search_administrator", "");
        request.getSession().setAttribute("search_moderator", "");
        request.getSession().setAttribute("search_speaker", "");
        request.getSession().setAttribute("search_participant", "");
        request.getSession().setAttribute("search_active", "");
        request.getSession().setAttribute("search_deactivated", "");*/

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        try {
            System.out.println("LoginCommand.java -> inside try");
            User user = userService.findUserByLoginAndPassword(login, password);
            //String path = "/WEB-INF/view/main_page.jsp";

            System.out.println("---------------->>>>>>> " + user.getRole());

            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("role", user.getRole());

            //CommandUtil.goToPage(request, response, path);

        } catch (ServiceException e) {
            System.out.println("LoginCommand.java -> inside catch");
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
