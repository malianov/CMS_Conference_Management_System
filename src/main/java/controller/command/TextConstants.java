package controller.command;


public interface TextConstants {

    interface Parameters {
        String CURRENT_PAGE = "currentPage";
        String CONFERENCES = "conferences";
        String NO_OF_PAGES = "noOfPages";
        String USERS = "users";
    }

    interface Routes {
        String TO_SHOW_ALL_USERS = "/WEB-INF/view/all_users_page.jsp";
        String TO_SHOW_ALL_CONFERENCES = "/WEB-INF/view/calendar_page.jsp";
        String TO_CHANGE_PROGRAM = "/WEB-INF/view/change_program_page.jsp";
    }

    interface CommandPaths {
        //account
        String REGISTRATION = "registration";
        String LOGIN = "login";
        String LOGOUT = "logout";
    }
}
