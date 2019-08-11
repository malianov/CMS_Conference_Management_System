package controller.command.common.impl;

import controller.command.Command;
import controller.command.util.CommandUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFoundPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        CommandUtil.goToPage(request, response, "/WEB-INF/view/not_found_page.jsp");
    }
}
