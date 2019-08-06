package controller.command.util;

public enum Operation {

    LOGIN(                  "/view/login"),
    LOGOUT(                 "/view/logout"),
    NOT_FOUND_PAGE(         "/view/not_found_page"),

    MAIN_PAGE(              "/view/main_page"),
    ALL_USERS_PAGE(         "/view/all_users_page"),
    //ALL_USERS_PAGE(         "/view/search_users"),
    CALENDAR_PAGE(          "/view/calendar_page"),
    ARCHIVE_PAGE(           "/view/archive_page"),

    //SEARCH_USERS(           "/view/search_users"),
    SEARCH_USERS(           "/view/all_users_page"),

    CHANGE_USER_ROLE(       "/view/change_user_role"),
    CHANGE_USER_ACTIVITY_STATUS("/view/change_user_activity_status"),
    USER_MAIN_PAGE(         "/view/user_page"),

    ADD_NEW_CONFERENCE(     "/view/create_conference"),
    CHANGE_START_DATE(      "/view/change_start_date"),
    CHANGE_END_DATE(        "/view/change_end_date"),

    CHANGE_CITY(            "/view/change_conference_city"),
    CHANGE_PLACE(           "/view/change_conference_place"),
    SHOW_LOGIN_PAGE(        "/view/show_login_page"),
    SHOW_MAIN_PAGE(         "/view/main_page"),

    SCHEDULE(               "/view/schedule"),
    SHOW_SCHEDULE(          "/view/schedule_page"),

    SHOW_ADD_THE_BOOK(      "/view/main_page/add_book_page"),
    ADD_THE_BOOK(           "/view/main_page/add_book"),

    SHOW_ADD_THE_READER(    "/view/main_page/add_reader_page"),
    ADD_THE_READER(         "/view/main_page/add_reader"),

    SHOW_ADD_THE_LIBRARIAN( "/view/main_page/add_user_page"),
    ADD_THE_LIBRARIAN(      "/view/main_page/add_user"),

    MODIFY_THE_BOOK(        "/view/main_page/modify_book"),
    DELETE_THE_BOOK(        "/view/main_page/delete_book"),
    MODIFY_READER_INFORMATION(  "/view/main_page/modify_reader"),
    DEACTIVATE_THE_READER(      "/view/main_page/delete_reader"),
    MODIFY_LIBRARIAN_INFORMATION("/view/main_page/modify_user"),
    DEACTIVATE_LIBRARIAN(       "/view/main_page/deactivate_user"),
    LIST_OF_ALL_LIBRARIANS(     "/view/main_page/report_all_users"),

    LIST_OF_BOOKS_READERS(      "/view/main_page/report_books_readers"),
    SHOW_LIST_OF_BOOKS_READERS( "/view/main_page/report_books_readers_page"),

    SHOW_FIND_THE_BOOK(        "/view/main_page/find_book_page"),
    FIND_THE_BOOK(             "/view/main_page/find_book"),

    SHOW_SERV_THE_READER(        "/view/main_page/serv_reader_page"),
    SERV_THE_READER(             "/view/main_page/serv_reader"),

    SERV_THE_READER_BOOKS_ORDER( "/view/main_page/serv_reader_books_order"),
    SERV_THE_READER_BOOKS(       "/view/main_page/serv_reader_books");

    private String path;

    Operation(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}