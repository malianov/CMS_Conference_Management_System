package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.entity.Conference;
import model.service.ConferenceService;
import model.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static controller.command.TextConstants.Parameters.*;
import static controller.command.TextConstants.Routes.TO_SHOW_ALL_CONFERENCES;

public class CalendarCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ConferenceService conferenceService = serviceFactory.getConferenceService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int ROWS_PER_PAGE = 12;
        int current_page = 1;

        if (request.getParameter(CURRENT_PAGE) != null) {
            current_page = Integer.parseInt(request.getParameter(CURRENT_PAGE));
        }

        performPagination(request, current_page, ROWS_PER_PAGE);
        CommandUtil.goToPage(request, response, TO_SHOW_ALL_CONFERENCES);
    }

    private void performPagination(HttpServletRequest request, int currentPage, int rowsPerPage) {
        //final Conference currentSessionConference = CommandUtility.getCurrentSessionUser(request);
        //final long currentUserId = currentSessionConference.getId();

        int lowerBound = calcLowerBound(currentPage, rowsPerPage);

        ConferenceService.PaginationResult paginationResult = conferenceService.getConferencesByPagination(lowerBound, rowsPerPage);

        List<Conference> conferences = paginationResult.getResultList();
        int noOfRows = paginationResult.getNoOfRows();
        int noOfPages = calcNoOfPages(noOfRows, rowsPerPage);

        request.setAttribute(CONFERENCES, conferences);
        request.setAttribute(NO_OF_PAGES, noOfPages);
        request.setAttribute(CURRENT_PAGE, currentPage);
    }

    private int calcLowerBound(int currentPage, int rowsPerPage) {
        return (currentPage - 1) * rowsPerPage;
    }

    private int calcNoOfPages(int noOfRows, int rowsPerPage) {
        return (int) Math.ceil(noOfRows * 1.0 / rowsPerPage);
    }

}
