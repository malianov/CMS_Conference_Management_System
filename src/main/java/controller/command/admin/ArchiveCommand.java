package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ArchiveCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CommandUtil.goToPage(request,response,"/WEB-INF/view/archive_page.jsp");
    }
}
