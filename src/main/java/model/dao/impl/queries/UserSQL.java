package model.dao.impl.queries;

/**
 * SQL queries for students table.
 */
public enum UserSQL {
    FIND_USER_BY_LOGIN_AND_PASSWORD_QUERY("SELECT * FROM CMS.users WHERE u_login = (?) AND u_password = (?);"),
    FIND_ALL_USERS_QUERY("SELECT * FROM CMS.users LIMIT 10 OFFSET 19;"),




    READ_ONE("select * from persons where id_person=(?)"),
    READ_ALL("select * from persons"),
    INSERT("INSERT INTO persons " +
            "(first_name, last_name, email, password, id_role) " +
            "VALUES ((?),(?),(?),(?),(?))"),

    DELETE(""),
    UPDATE(""),

    READ_BY_EMAIL("SELECT * FROM persons where email=(?);"),
    READ_BY_EMAIL_PASSWORD("SELECT * FROM persons where email=(?) and password=(?);"),
    READ_ALL_INSPECTORS("select * from persons where id_role=1"),
    READ_ALL_BY_INSPECTOR_ID("SELECT * FROM persons where id_inspector=(?);"),
    ASSIGN_INSPECTOR_TO_CLIENT("UPDATE persons SET id_inspector=(?) WHERE id_person=(?);"),




    FIND_USER_BY_LOGIN_QUERY("SELECT * FROM LMS.users WHERE u_login = (?);"),

    CHANGE_USER_ACTIVE_STATUS_BY_LOGIN_QUERY("UPDATE LMS.users SET u_is_active = (?) WHERE l_login = (?);"),
    CREATE_USER_QUERY("INSERT INTO LMS.users (u_login, u_name, u_surname) VALUES ((?), (?), (?));"),
    MAX_USER_ID_QUERY("SELECT max(l_id) FROM LMS.users"),
    CHANGE_USER_MANAGERIAL_STATUS_BY_LOGIN_QUERY("UPDATE LMS.users SET u_is_manager = ? WHERE u_login = (?);");

    String QUERY;

    UserSQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}