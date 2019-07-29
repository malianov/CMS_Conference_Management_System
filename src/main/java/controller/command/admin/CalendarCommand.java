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
        System.out.println("CalendarCommand.java -> inside execute");


        int ROWS_PER_PAGE = 12;
        int current_page = 1;

        System.out.println("CalendarCommand.java -> inside execute// CURRENT_PAGE = " + CURRENT_PAGE);

        if (request.getParameter(CURRENT_PAGE) != null) {
            current_page = Integer.parseInt(request.getParameter(CURRENT_PAGE));
        }

        System.out.println("CalendarCommand.java -> inside execute// currentPage = " + current_page);

        performPagination(request, current_page, ROWS_PER_PAGE);
        CommandUtil.goToPage(request,response,TO_SHOW_ALL_CONFERENCES);
    }
        private void performPagination(HttpServletRequest request, int currentPage, int rowsPerPage){
            //final Conference currentSessionConference = CommandUtility.getCurrentSessionUser(request);
            //final long currentUserId = currentSessionConference.getId();

            int lowerBound = calcLowerBound(currentPage, rowsPerPage);

            System.out.println("CalendarCommand.java -> inside performPagination// lowerBound = " + lowerBound);

            ConferenceService.PaginationResult paginationResult = conferenceService.getConferencesByPagination(lowerBound, rowsPerPage);

            List<Conference> conferences = paginationResult.getResultList();
            int noOfRows = paginationResult.getNoOfRows();
            int noOfPages = calcNoOfPages(noOfRows, rowsPerPage);

            request.setAttribute(CONFERENCES, conferences);
            request.setAttribute(NO_OF_PAGES, noOfPages);
            request.setAttribute(CURRENT_PAGE, currentPage);
            System.out.println("CalendarCommand.java -> performPagination");
            System.out.println("CalendarCommand.java -> conferences = " + conferences);
            System.out.println("CalendarCommand.java -> no of pages " + noOfPages);
            System.out.println("CalendarCommand.java -> current page " + currentPage);
        }

        private int calcLowerBound(int currentPage, int recordsPerPage){

            System.out.println("currentPage = " + currentPage);
            System.out.println("recordsPerPage = " + recordsPerPage);

            return  (currentPage - 1) * recordsPerPage;
        }

        private int calcNoOfPages(int noOfRecords, int recordsPerPage) {
            return (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        }



       /* try {
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
        }*/

}
