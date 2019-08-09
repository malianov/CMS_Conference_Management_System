package controller.command.util;

public enum Operation {

    LOGIN("/view/login"),
    LOGOUT("/view/logout"),
    NOT_FOUND_PAGE("/view/not_found_page"),

    MAIN_PAGE("/view/main_page"),
    ALL_USERS_PAGE("/view/all_users_page"),
    //ALL_USERS_PAGE(         "/view/search_users"),
    CALENDAR_PAGE("/view/calendar_page"),
    ARCHIVE_PAGE("/view/archive_page"),

    //SEARCH_USERS(           "/view/search_users"),
    SEARCH_USERS("/view/all_users_page"),

    CHANGE_USER_ROLE("/view/change_user_role"),
    CHANGE_USER_ACTIVITY_STATUS("/view/change_user_activity_status"),
    USER_MAIN_PAGE("/view/user_page"),

    ADD_NEW_CONFERENCE("/view/create_conference"),
    CHANGE_START_DATE("/view/change_start_date"),
    CHANGE_END_DATE("/view/change_end_date"),

    CHANGE_CITY("/view/change_conference_city"),
    CHANGE_PLACE("/view/change_conference_place"),


    CHANGE_PROGRAM("/view/change_program"),
    CHANGE_SEMINAR_TIME("/view/change_seminar_time"),
    CHANGE_SEMINAR_TOPIC("/view/change_seminar_topic"),
    CHANGE_SEMINAR_SPEAKER("/view/change_seminar_speaker"),
    CHANGE_SEMINAR_ROOM("/view/change_seminar_room");

    private String path;

    Operation(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}