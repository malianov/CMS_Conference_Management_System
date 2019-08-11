package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.service.SeminarService;
import model.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeSeminarRoomCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    SeminarService seminarService = serviceFactory.getSeminarService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String seminar_room = request.getParameter("seminar_room");
        String seminar_id = request.getParameter("seminar_id");

        seminarService.changeSeminarRoom(seminar_room, seminar_id);
        String path = "/view/calendar_page";
        CommandUtil.goToPage(request, response, path);

    }
}
