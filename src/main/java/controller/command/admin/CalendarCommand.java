package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.entity.Conference;
import model.exception.ServiceException;
import model.service.ConferenceService;
import model.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CalendarCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ConferenceService conferenceService = serviceFactory.getConferenceService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("CalendarCommand.java -> inside execute");

        try {
            System.out.println("CalendarCommand.java -> inside try");




            List<Conference> conferences = conferenceService.findAllConferences();




            System.out.println("CalendarCommand.java -> inside try, conferences = " + conferences);
            request.setAttribute("conferences", conferences);
            CommandUtil.goToPage(request,response,"/WEB-INF/view/calendar_page.jsp");
            request.setAttribute("successful", true);
        } catch (RuntimeException e) {
            System.out.println("CalendarCommand.java -> inside catch RuntimeException" + e);
            request.setAttribute("error", true);
        } catch (ServiceException e) {
            System.out.println("CalendarCommand.java -> inside catch ServiceExceptio" + e);
            e.printStackTrace();
        }
    }
}
