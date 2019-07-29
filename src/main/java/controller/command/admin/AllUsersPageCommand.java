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

public class AllUsersPageCommand implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("AdminAllUsersPageCommand.java -> inside execute");
        try {
            List<User> users = userService.findAllUsers();
            request.setAttribute("users", users);
            CommandUtil.goToPage(request,response,"/WEB-INF/view/all_users_page.jsp");
            request.setAttribute("successful", true);
        } catch (RuntimeException e) {
            request.setAttribute("error", true);
        } catch (ServiceException e) {
            e.printStackTrace();
       }

//    @Override
//    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println("AdminAllUsersPageCommand.java -> inside execute");
//
//        ServiceFactory serviceFactory = ServiceFactory.getInstance();
//        UserService userService = serviceFactory.getUserService();
//
//        int ROWS_PER_PAGE = 12;
//        int currentPage = 1;
//        if (request.getParameter(CURRENT_PAGE) != null) {
//            currentPage = Integer.parseInt(request.getParameter(CURRENT_PAGE));
//        }
//
//        performPagination(request, currentPage, ROWS_PER_PAGE);
//        CommandUtil.goToPage(request,response,"/WEB-INF/view/all_users_page.jsp");
//        //return TO_SHOW_ALL_USERS;
//    }
//
//    private void performPagination(HttpServletRequest request, int currentPage, int rowsPerPage) {
//        int lowerBound = calcLowerBound(currentPage, rowsPerPage);
//
//        //UserService.PaginationResult paginationResult = userService.getRowsByPagination(lowerBound, rowsPerPage, currentUserId);
//    }
//
//    private int calcLowerBound(int currentPage, int rowsPerPage){
//        return  (currentPage - 1) * rowsPerPage;
//    }
//
//    private int calcNoOfPages(int noOfRecords, int rowsPerPage) {
//        return (int) Math.ceil(noOfRecords * 1.0 / rowsPerPage);
//    }
//

//        try {
//            List<User> users = userService.findAllUsers();
//            request.setAttribute("users", users);
//            CommandUtil.goToPage(request,response,"/WEB-INF/view/admin/all_users_page.jsp");
//            request.setAttribute("successful", true);
//        } catch (RuntimeException e) {
//            request.setAttribute("error", true);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//       }
//
//
//    }
}}
