package controller.command.admin;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import controller.command.Command;
import controller.command.util.CommandUtil;
import model.service.ConferenceService;
import model.service.SeminarService;
import model.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeSeminarTimeCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    SeminarService seminarService = serviceFactory.getSeminarService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String seminar_time = request.getParameter("seminar_time");
        String seminar_id = request.getParameter("seminar_id");

        seminarService.changeSeminarTime(seminar_time, seminar_id);
        System.out.println("ChangeSeminarTimeCommand.java -> after seminarService.changeSeminarTime(seminar_time, seminar_id)");
        String path = "/view/calendar_page";
            CommandUtil.goToPage(request, response, path);

    }
}
