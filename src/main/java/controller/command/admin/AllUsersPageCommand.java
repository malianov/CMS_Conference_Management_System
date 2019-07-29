package controller.command.admin;

import controller.command.Command;
import controller.command.util.CommandUtil;
import model.entity.User;
import model.exception.ServiceException;
import model.service.ServiceFactory;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static controller.command.TextConstants.Parameters.*;
import static controller.command.TextConstants.Routes.TO_SHOW_ALL_CONFERENCES;
import static controller.command.TextConstants.Routes.TO_SHOW_ALL_USERS;

public class AllUsersPageCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("AllUsersPaginatedCommand.java -> inside execute");

        int ROWS_PER_PAGE = 12;
        int current_page = 1;

        if (request.getParameter(CURRENT_PAGE) != null) {
            current_page = Integer.parseInt(request.getParameter(CURRENT_PAGE));
        }

        performPagination(request, current_page, ROWS_PER_PAGE);
        CommandUtil.goToPage(request, response, TO_SHOW_ALL_USERS);
    }

    private void performPagination(HttpServletRequest request, int currentPage, int rowsPerPage) {

        int lowerBound = calcLowerBound(currentPage, rowsPerPage);

        UserService.PaginationResult paginationResult = userService.getUsersByPagination(lowerBound, rowsPerPage);

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

    private int calcLowerBound(int currentPage, int recordsPerPage) {

        System.out.println("currentPage = " + currentPage);
        System.out.println("recordsPerPage = " + recordsPerPage);

        return (currentPage - 1) * recordsPerPage;
    }

    private int calcNoOfPages(int noOfRecords, int recordsPerPage) {
        return (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
    }
}
