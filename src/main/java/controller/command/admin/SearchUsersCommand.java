package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.entity.User;
import model.service.ServiceFactory;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        String searchUserId             = request.getParameter("search_user_id");
        String search_user_login        = request.getParameter("search_user_login");
        String searchUserName           = request.getParameter("search_user_name");
        String searchUserSurname        = request.getParameter("search_user_surname");
        String searchUserEmail          = request.getParameter("search_user_email");
        String search_administrator     = request.getParameter("search_administrator");
        String search_moderator         = request.getParameter("search_moderator");
        String search_speaker           = request.getParameter("search_speaker");
        String search_participant       = request.getParameter("search_participant");
        String search_active            = request.getParameter("search_active");
        String search_deactivated       = request.getParameter("search_deactivated");

        System.out.println(searchUserId +"\n"+ search_user_login +"\n"+ searchUserName +"\n"+ searchUserSurname +"\n"+ searchUserEmail +"\n"+ search_administrator +"\n"+
                search_moderator +"\n"+ search_speaker +"\n"+ search_participant +"\n"+ search_active +"\n"+ search_deactivated);

        int lowerBound = calcLowerBound(currentPage, rowsPerPage);





        UserService.PaginationResult paginationResult = userService.getSearchUsersByPagination(lowerBound, rowsPerPage, searchUserId, search_user_login,
                searchUserName, searchUserSurname, searchUserEmail/*, search_administrator, search_moderator, search_speaker, search_participant,
                search_active, search_deactivated*/);

        List<User> users = paginationResult.getResultList();
        int noOfRows = paginationResult.getNoOfRows();
        int noOfPages = calcNoOfPages(noOfRows, rowsPerPage);

        request.setAttribute(USERS, users);
        request.setAttribute(NO_OF_PAGES, noOfPages);
        request.setAttribute(CURRENT_PAGE, currentPage);
        System.out.println("AllUsersPageCommand.java -> performPagination");
        System.out.println("AllUsersPageCommand.java -> users = " + users);
        System.out.println("AllUsersPageCommand.java -> no of pages " + noOfPages);
        System.out.println("AllUsersPageCommand.java -> current page " + currentPage);
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