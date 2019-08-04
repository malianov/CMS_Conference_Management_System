package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.entity.Role;
import model.entity.User;
import model.service.ServiceFactory;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static controller.command.TextConstants.Parameters.*;
import static controller.command.TextConstants.Parameters.CURRENT_PAGE;
import static controller.command.TextConstants.Routes.TO_SHOW_ALL_USERS;

public class SearchUsersCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("SearchUsersCommand.java -> inside execute");

        int ROWS_PER_PAGE = 12;
        int current_page = 1;

        if (request.getParameter(CURRENT_PAGE) != null) {
            current_page = Integer.parseInt(request.getParameter(CURRENT_PAGE));
        }

        performPagination(request, current_page, ROWS_PER_PAGE);
        CommandUtil.goToPage(request, response, TO_SHOW_ALL_USERS);
    }

    private void performPagination(HttpServletRequest request, int currentPage, int rowsPerPage) {

        String searchUserId         = String.valueOf(request.getSession().getAttribute("search_user_id"));
        String search_user_login    = String.valueOf(request.getSession().getAttribute("search_user_login"));
        String searchUserName       = String.valueOf(request.getSession().getAttribute("search_user_name"));
        String searchUserSurname    = String.valueOf(request.getSession().getAttribute("search_user_surname"));
        String searchUserEmail      = String.valueOf(request.getSession().getAttribute("search_user_email"));

        String searchAdministrator  = String.valueOf(request.getSession().getAttribute("search_administrator"));
        String searchModerator      = String.valueOf(request.getSession().getAttribute("search_moderator"));
        String searchSpeaker        = String.valueOf(request.getSession().getAttribute("search_speaker"));
        String searchParticipant    = String.valueOf(request.getSession().getAttribute("search_participant"));
        String searchActive         = String.valueOf(request.getSession().getAttribute("search_active"));
        String searchDeactivated    = String.valueOf(request.getSession().getAttribute("search_deactivated"));

        if (request.getParameter("search_user_id") != null) {
            searchUserId = request.getParameter("search_user_id");
        }
        if (request.getParameter("search_user_login") != null) {
            search_user_login = request.getParameter("search_user_login");
        }
        if (request.getParameter("search_user_name") != null) {
            searchUserName = request.getParameter("search_user_name");
        }
        if (request.getParameter("search_user_surname") != null) {
            searchUserSurname = request.getParameter("search_user_surname");
        }
        if (request.getParameter("search_user_email") != null) {
            searchUserEmail = request.getParameter("search_user_email");
        }
        if (request.getParameter("search_administrator") != null) {
            searchAdministrator = "0";
        }
        if (request.getParameter("search_moderator") != null) {
            searchModerator = "1";
        }
        if (request.getParameter("search_speaker") != null) {
            searchSpeaker = "2";
        }
        if (request.getParameter("search_participant") != null) {
            searchParticipant = "3";
        }
        if (request.getParameter("search_active") != null) {
            searchActive = "1";
        }
        if (request.getParameter("search_deactivated") != null) {
            searchDeactivated = "0";
        }

        System.out.println(searchUserId + "\n" +
                search_user_login + "\n" +
                searchUserName + "\n" +
                searchUserSurname + "\n" +
                searchUserEmail +"\n"+
                searchAdministrator +"\n"+
                searchModerator +"\n"+
                searchSpeaker +"\n"+
                searchParticipant +"\n"+
                searchActive +"\n"+
                searchDeactivated);

        int lowerBound = calcLowerBound(currentPage, rowsPerPage);

        UserService.PaginationResult paginationResult = userService.getSearchUsersByPagination(lowerBound, rowsPerPage, searchUserId, search_user_login,
                searchUserName, searchUserSurname, searchUserEmail, String.valueOf(searchAdministrator), searchModerator, searchSpeaker, searchParticipant,
                searchActive, searchDeactivated);

        List<User> users    = paginationResult.getUsersList();
        System.out.println("SearchUsersCommand.java - > users = " + users);
        int noOfRows        = paginationResult.getNoOfRows();
        int noOfPages       = calcNoOfPages(noOfRows, rowsPerPage);

        System.out.println("..........SearchUsersCommand.java -> users " + users);
        System.out.println("..........SearchUsersCommand.java -> noOfRows " + noOfRows);

        request.setAttribute(USERS, users);
        request.setAttribute(NO_OF_PAGES, noOfPages);
        request.setAttribute(CURRENT_PAGE, currentPage);

        System.out.println("SearchUsersCommand.java -> performPagination");
        System.out.println("SearchUsersCommand.java -> users = " + users);
        System.out.println("SearchUsersCommand.java -> no of pages " + noOfPages);
        System.out.println("SearchUsersCommand.java -> current page " + currentPage);
    }

    private int calcLowerBound(int currentPage, int rowsPerPage) {

        System.out.println("currentPage = " + currentPage);
        System.out.println("rowsPerPage = " + rowsPerPage);

        return (currentPage - 1) * rowsPerPage;
    }

    private int calcNoOfPages(int noOfRows, int rowsPerPage) {
        return (int) Math.ceil(noOfRows * 1.0 / rowsPerPage);
    }
}