package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.entity.Conference;
import model.service.ConferenceService;
import model.service.ServiceFactory;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class ChangeStartDateCommand implements Command {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ConferenceService conferenceService = serviceFactory.getConferenceService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idConference = request.getParameter("conferenceId");
        String newDate = request.getParameter("newDate");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-LL-dd");
        LocalDate localDate = LocalDate.parse(newDate, dateTimeFormatter);
        conferenceService.changeStartDate(idConference, localDate.plusDays(1));

        String path = "/view/calendar_page";
        CommandUtil.goToPage(request, response, path);
    }
}
