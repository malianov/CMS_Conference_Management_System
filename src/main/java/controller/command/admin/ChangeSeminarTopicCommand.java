package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.service.SeminarService;
import model.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeSeminarTopicCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    SeminarService seminarService = serviceFactory.getSeminarService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String seminar_topic = request.getParameter("seminar_topic");
        String seminar_id = request.getParameter("seminar_id");

        seminarService.changeSeminarTopic(seminar_topic, seminar_id);
        String path = "/view/calendar_page";
            CommandUtil.goToPage(request, response, path);

    }
}
