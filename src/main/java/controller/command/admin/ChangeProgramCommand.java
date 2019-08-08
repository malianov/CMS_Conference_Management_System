package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.entity.Conference;
import model.service.ConferenceService;
import model.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static controller.command.TextConstants.Parameters.*;
import static controller.command.TextConstants.Routes.TO_CHANGE_PROGRAM;
import static controller.command.TextConstants.Routes.TO_SHOW_ALL_CONFERENCES;

public class ChangeProgramCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ConferenceService conferenceService = serviceFactory.getConferenceService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

            String idConference = request.getParameter("conferenceId");
        System.out.println("ChangeProgramCommand.java -> inside execute" + idConference);



        CommandUtil.goToPage(request, response, TO_CHANGE_PROGRAM);
    }
}
