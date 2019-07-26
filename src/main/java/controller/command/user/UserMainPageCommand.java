package controller.command.user;

import controller.command.Command;
import controller.command.util.CommandUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserMainPageCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("UserMainPageCommand.java -> inside execute");
        CommandUtil.goToPage(request,response,"/WEB-INF/view/user/user_page.jsp");
    }
}
