package controller.command.common.impl;

import controller.command.Command;
import controller.command.util.LogoutUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ScheduleCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("ScheduleCommand.java -> inside execute");
    }
}