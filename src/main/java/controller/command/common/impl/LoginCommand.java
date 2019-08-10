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
        System.out.println("LoginCommand.java -> inside execute");

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

/*
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DAOException {

        String loginFromRequest = request.getParameter("login").trim();
        String passwordFromRequest = request.getParameter("password");

        if (!(Validation.isStringValid(loginFromRequest))) {
            System.out.println("LoginCommand.java ->> login is invalid");
            return LOGIN_FAIL_INVALID_INPUT;
        }

        if (!(Validation.isPasswordValid(loginFromRequest))) {
            System.out.println("LoginCommand.java ->> pasword is invalid");
            return LOGIN_FAIL_INVALID_INPUT;
        }
    }
}*/

/*    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        System.out.println("LoginCommand.java -> inside execute");

        String loginFromRequest = request.getParameter("login").trim();
        String passwordFromRequest = request.getParameter("password");

        if (!userService.ifLoginExists(loginFromRequest)) {
            System.out.println("LoginCommand.java -> !userService.ifLoginExists(loginFromRequest) = " + !userService.ifLoginExists(loginFromRequest));
            request.setAttribute("wrongLogin", true);
            String path = "/";
            CommandUtil.goToPage(request, response, path);
        }

        User user = userService.login(loginFromRequest);
        System.out.println("LoginCommand.java -> user = " + user);
        String password = user.getPassword();

        //if (HashPassword.getPwdHash(passwordFromRequest).equals(password)) {
        if (passwordFromRequest.equals(password)) {
            request.getSession().setAttribute("User", user);
            request.getSession().setAttribute("role", user.getRole());
            String path = "/WEB-INF/view/common/main_page.jsp";
            CommandUtil.goToPage(request, response, path);
        } else {
            request.setAttribute("wrongPassOrLogin", true);
            String path = "/";
            CommandUtil.goToPage(request, response, path);
        }
    }
}*/


//        if(login.isEmpty()||password.isEmpty())
//
//    {
//        System.out.println("Login is empty");
//        String path = "/";
//        CommandUtil.goToPage(request, response, path);
//    }



        /*else {
            request.setAttribute("wrongPassOrLogin", true);
            String path = "/";
            CommandUtil.goToPage(request, response, path);
        }*/


//String desireToBeSpeaker = request.getParameter("desireToBeSpeaker");

//        request.getSession().setAttribute("search_user_id","");
//        request.getSession().setAttribute("search_user_login","");
//        request.getSession().setAttribute("search_user_name","");
//        request.getSession().setAttribute("search_user_surname","");
//        request.getSession().setAttribute("search_user_email","");

/*        request.getSession().setAttribute("search_administrator", "");
        request.getSession().setAttribute("search_moderator", "");
        request.getSession().setAttribute("search_speaker", "");
        request.getSession().setAttribute("search_participant", "");
        request.getSession().setAttribute("search_active", "");
        request.getSession().setAttribute("search_deactivated", "");*/
//
//    ServiceFactory serviceFactory = ServiceFactory.getInstance();
//    UserService userService = serviceFactory.getUserService();
//
//        try
//
//    {
//        System.out.println("LoginCommand.java -> inside try");
//        User user = userService.findUserByLoginAndPassword(login, password);
//        //String path = "/WEB-INF/view/main_page.jsp";
//
//        System.out.println("---------------->>>>>>> " + user.getRole());
//
//        request.getSession().setAttribute("user", user);
//        request.getSession().setAttribute("role", user.getRole());
//
//        //CommandUtil.goToPage(request, response, path);
//
//    } catch(
//    ServiceException e)
//
//    {
//        System.out.println("LoginCommand.java -> inside catch");
//    }
//
//        if(request.getSession().
//
//    getAttribute("user") !=null)
//
//    {
//        String path = "/WEB-INF/view/common/main_page.jsp";
//        CommandUtil.goToPage(request, response, path);
//    } else
//
//    {
//        request.setAttribute("wrongPassOrLogin", true);
//        String path = "/";
//        CommandUtil.goToPage(request, response, path);
//    }
//}
//}
