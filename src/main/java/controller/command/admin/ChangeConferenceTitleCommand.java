package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.service.ConferenceService;
import model.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeConferenceTitleCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ConferenceService conferenceService = serviceFactory.getConferenceService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String conferenceTitleEng = request.getParameter("conference_title_eng");
        String conferenceTitleUkr = request.getParameter("conference_title_ukr");
        String conferenceId = request.getParameter("conferenceId");

        conferenceService.changeConferenceTitle(conferenceTitleEng, conferenceTitleUkr, conferenceId);
        String path = "/view/calendar_page";
            CommandUtil.goToPage(request, response, path);
    }
}
