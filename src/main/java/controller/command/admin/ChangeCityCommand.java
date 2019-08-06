package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.exception.ServiceException;
import model.service.ConferenceService;
import model.service.ServiceFactory;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeCityCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ConferenceService conferenceService = serviceFactory.getConferenceService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cityEng = request.getParameter("city_eng");
        String cityUkr = request.getParameter("city_ukr");
        String idConference = request.getParameter("conferenceId");

            System.out.println("============ hidden role ============" + cityEng + " " + cityUkr);
        conferenceService.changeCity(cityEng, cityUkr, idConference);

        String path = "/view/calendar_page";
            CommandUtil.goToPage(request, response, path);

    }
}
