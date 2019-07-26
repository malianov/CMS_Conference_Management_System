package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.entity.User;
import model.exception.ServiceException;
import model.service.ServiceFactory;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminAllUsersPageCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("AdminAllUsersPageCommand.java -> inside execute");

        ServiceFactory serviceFactory   = ServiceFactory.getInstance();
        UserService userService         = serviceFactory.getUserService();

        try {
            List<User> users = serviceFactory.getUserService().findAllUsers();
            request.setAttribute("users", users);
            CommandUtil.goToPage(request,response,"/WEB-INF/view/admin/admin_all_users_page.jsp");
            request.setAttribute("successful", true);
        } catch (RuntimeException e) {
            request.setAttribute("error", true);
        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }
}
