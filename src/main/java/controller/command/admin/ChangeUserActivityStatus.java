package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.exception.ServiceException;
import model.service.ServiceFactory;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeUserActivityStatus implements Command {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newAcivityStatus = request.getParameter("newAcivityStatus");
        String userLogin = request.getParameter("userLogin");
        String page = request.getParameter("page");

        System.out.println("============ hidden newAcivityStatus ============" + newAcivityStatus + " " + userLogin);
        userService.changeUserAcivityStatus(userLogin, newAcivityStatus);

        String path = "/view/all_users_page?currentPage=" + page;
        CommandUtil.goToPage(request, response, path);

    }
}
