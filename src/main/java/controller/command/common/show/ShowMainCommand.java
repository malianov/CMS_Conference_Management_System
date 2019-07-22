package controller.command.common.show;

import controller.command.Command;
import controller.command.util.CommandUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowMainCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CommandUtil.goToPage(request, response, "/WEB-INF/view/main_page.jsp");
    }
}
