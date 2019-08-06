package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.service.ConferenceService;
import model.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePlaceCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ConferenceService conferenceService = serviceFactory.getConferenceService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String placeEng = request.getParameter("place_eng");
        String placeUkr = request.getParameter("place_ukr");
        String idConference = request.getParameter("conferenceId");

            System.out.println("============ hidden role ============" + placeEng + " " + placeUkr);
        conferenceService.changePlace(placeEng, placeUkr, idConference);

        String path = "/view/calendar_page";
            CommandUtil.goToPage(request, response, path);

    }
}
