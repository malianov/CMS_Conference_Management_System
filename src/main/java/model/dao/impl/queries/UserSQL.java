package model.dao.impl.queries;

/**
 * SQL queries for students table.
 */
public enum UserSQL {
    FIND_USER_BY_LOGIN_QUERY("SELECT * FROM CMS.users WHERE u_login = (?);"),
    FIND_USER_BY_LOGIN_AND_PASSWORD_QUERY("SELECT * FROM CMS.users WHERE u_login = (?) AND u_password = (?) AND u_is_active='1';"),
    CHANGE_USER_ROLE_BY_ID_AND_NEW_ROLE_QUERY("UPDATE CMS.users SET u_role = (?) WHERE u_login = (?);"),
    CHANGE_USER_ACTIVITY_STATUS_QUERY("UPDATE CMS.users SET u_is_active = (?) WHERE u_login = (?);"),
    CHECK_LOGIN_EXISTS("SELECT EXISTS(SELECT 1 FROM CMS.users WHERE u_login = (?) LIMIT 1);"),



    FIND_ALL_USERS_QUERY("SELECT * FROM CMS.users LIMIT 10 OFFSET 19;"),
    GET_USERS_BY_PAGINATION("SELECT SQL_CALC_FOUND_ROWS * FROM CMS.users LIMIT ?, ?;"),
    CALC_USERS_BY_WHOLE("SELECT COUNT(*) FROM CMS.users");


    String QUERY;

    UserSQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}