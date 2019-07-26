package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminArchiveCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("AdminMainPageCommand.java -> inside execute");
        CommandUtil.goToPage(request,response,"/WEB-INF/view/admin/admin_archive_page.jsp");
    }
}
