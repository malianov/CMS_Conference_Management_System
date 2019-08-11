package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.entity.Conference;
import model.service.ConferenceService;
import model.service.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewConferenceCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ConferenceService conferenceService = serviceFactory.getConferenceService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String startDate = request.getParameter("start_date");
        String endDate = request.getParameter("end_date");
        String titleEng = request.getParameter("title_eng");
        String titleUkr = request.getParameter("title_ukr");
        String cityEng = request.getParameter("city_eng");
        String cityUkr = request.getParameter("city_ukr");
        String placeEng = request.getParameter("place_eng");
        String placeUkr = request.getParameter("place_ukr");
        String moderator = request.getParameter("moderator");
        String page = request.getParameter("page");

        Conference newConference = new Conference(startDate, endDate, titleEng, titleUkr, cityEng, cityUkr, placeEng, placeUkr);

        conferenceService.addNewConference(newConference);
        String path = "/view/calendar_page";
        CommandUtil.goToPage(request, response, path);
    }
}
