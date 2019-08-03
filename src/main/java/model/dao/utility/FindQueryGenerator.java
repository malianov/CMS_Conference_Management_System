package model.dao.utility;

import java.util.Optional;

public class FindQueryGenerator {
    public StringBuilder findUsersByCriteriaRequests(String search_user_id, String search_user_login,
                                                     String search_user_name, String search_user_surname,
                                                     String search_user_email/*, String search_administrator,
                                                     String search_moderator, String search_speaker,
                                                     String search_participant, String search_active,
                                                     String search_deactivated*/) {
        StringBuilder sb = new StringBuilder("SELECT * FROM CMS.users WHERE");

        sb.append(" (u_id LIKE \"%" + search_user_id + "%\")");
        if(search_user_login != "") { sb.append(" AND (u_login LIKE \"%" + search_user_login + "%\")");}
        if(search_user_name != "") { sb.append(" AND (u_name LIKE \"%" + search_user_name + "%\")");}
        if(search_user_surname != "") { sb.append(" AND (u_surname LIKE \"%" + search_user_surname + "%\")");}
        if(search_user_email != "") { sb.append(" AND (u_email LIKE \"%" + search_user_email + "%\")");}
        return sb;
    }

    public StringBuilder calculateUsersByCriteriaRequests(String search_user_id, String search_user_login,
                                                     String search_user_name, String search_user_surname,
                                                     String search_user_email/*, String search_administrator,
                                                     String search_moderator, String search_speaker,
                                                     String search_participant, String search_active,
                                                     String search_deactivated*/) {

        StringBuilder sb = new StringBuilder("SELECT * FROM CMS.users WHERE");

        sb.append(" (u_id LIKE \"%" + search_user_id + "%\")");
        if(search_user_login != "") { sb.append(" AND (u_login LIKE \"%" + search_user_login + "%\")");}
        if(search_user_name != "") { sb.append(" AND (u_name LIKE \"%" + search_user_name + "%\")");}
        if(search_user_surname != "") { sb.append(" AND (u_surname LIKE \"%" + search_user_surname + "%\")");}
        if(search_user_email != "") { sb.append(" AND (u_email LIKE \"%" + search_user_email + "%\")");}
        return sb;
    }
}

