package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.exception.ServiceException;
import model.service.ServiceFactory;
import model.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controller.command.TextConstants.Routes.TO_SHOW_ALL_USERS;

public class ChangeUserRoleCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newRole = request.getParameter("newRole");
        String userLogin = request.getParameter("userLogin");
        String page = request.getParameter("page");

        try {
            userService.changeUserRole(userLogin, newRole);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        String path = "/view/all_users_page?currentPage=" + page;
        CommandUtil.goToPage(request, response, path);

    }
}