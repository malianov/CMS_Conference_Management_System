package controller.command.common.show;

import controller.command.Command;
import controller.command.util.CommandUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowLoginCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ShowLoginCommand.java -> inside execute");
        CommandUtil.goToPage(request,response,"/login.jsp");
    }
}
