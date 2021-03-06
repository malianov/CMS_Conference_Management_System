package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.service.SeminarService;
import model.service.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controller.command.TextConstants.Routes.*;

public class ChangeProgramCommand implements Command {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    SeminarService seminarService = serviceFactory.getSeminarService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String conference_id = request.getParameter("conference_change_id");
        request.getSession().setAttribute("open_conference_plan_id", seminarService.SeminarsByDays(conference_id));
        request.getSession().setAttribute("conferenceDaysQty", seminarService.calculateConferenceDurationDays(conference_id));
        CommandUtil.goToPage(request, response, TO_CHANGE_PROGRAM);

    }
}
