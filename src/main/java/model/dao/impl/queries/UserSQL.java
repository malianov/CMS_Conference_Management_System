package model.dao.impl.queries;

public enum UserSQL {
    FIND_USER_BY_LOGIN_QUERY("SELECT * FROM CMS.users WHERE u_login = (?);"),
    FIND_USER_BY_LOGIN_AND_PASSWORD_QUERY("SELECT * FROM CMS.users WHERE u_login = (?) AND u_password = (?) AND u_is_active='1';"),
    CHANGE_USER_ROLE_BY_ID_AND_NEW_ROLE_QUERY("UPDATE CMS.users SET u_role = (?) WHERE u_login = (?);"),
    CHANGE_USER_ACTIVITY_STATUS_QUERY("UPDATE CMS.users SET u_is_active = (?) WHERE u_login = (?);"),
    CHECK_LOGIN_EXISTS("SELECT EXISTS(SELECT 1 FROM CMS.users WHERE u_login = (?) LIMIT 1);");

    String QUERY;

    UserSQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}