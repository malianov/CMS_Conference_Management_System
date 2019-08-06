package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.service.ConferenceService;
import model.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ChangeEndDateCommand implements Command {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ConferenceService conferenceService = serviceFactory.getConferenceService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idConference = request.getParameter("conferenceId");
        String newDate = request.getParameter("newDate");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-LL-dd");
        LocalDate localDate = LocalDate.parse(newDate, dateTimeFormatter);
        conferenceService.changeEndDate(idConference, localDate.plusDays(1));

        String path = "/view/calendar_page";
        CommandUtil.goToPage(request, response, path);
    }
}
