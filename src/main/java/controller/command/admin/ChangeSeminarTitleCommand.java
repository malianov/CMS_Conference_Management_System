package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.service.SeminarService;
import model.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeSeminarTitleCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    SeminarService seminarService = serviceFactory.getSeminarService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String seminarTitleEng = request.getParameter("seminar_title_eng");
        String seminarTitleUkr = request.getParameter("seminar_title_ukr");
        String seminarGlobalId = request.getParameter("seminar_global_id");

        seminarService.changeSeminarTitle(seminarTitleEng, seminarTitleUkr, seminarGlobalId);
        String path = "/view/calendar_page";
        CommandUtil.goToPage(request, response, path);
    }
}
