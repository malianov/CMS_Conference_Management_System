package model.dao.utility;

public class FindQueryGenerator {
    public StringBuilder findUsersByCriteriaRequests(String search_user_id, String search_user_login,
                                                     String search_user_name, String search_user_surname,
                                                     String search_user_email/*, String search_administrator,
                                                     String search_moderator, String search_speaker,
                                                     String search_participant, String search_active,
                                                     String search_deactivated*/) {
        StringBuilder sb = new StringBuilder("SELECT * FROM CMS.users WHERE");
        sb.append(" (u_id LIKE               \"%" + (search_user_id          == null ? "_" :search_user_id)      + "%\")");
        sb.append(" AND (u_login LIKE        \"%" + (search_user_login       == null ? "_":search_user_login)    + "%\")");
        sb.append(" AND (u_name LIKE         \"%" + (search_user_name        == null ? "_":search_user_name)     + "%\")");
        sb.append(" AND (u_surname LIKE      \"%" + (search_user_surname     == null ? "_":search_user_surname)  + "%\")");
        sb.append(" AND (u_email LIKE        \"%" + (search_user_email       == null ? "_":search_user_email)    + "%\");");
//        sb.append(" OR (u_role LIKE         \"%" + (search_administrator    == null ? "_":search_administrator) + "%\")");
//        sb.append(" OR (u_isActive LIKE     \"%" + (search_moderator        == null ? "_":search_moderator)     + "%\")");
//        sb.append(" OR (u_password LIKE     \"%" + (search_speaker          == null ? "_":search_speaker)       + "%\")");
//        sb.append(" OR (u_name LIKE         \"%" + (search_participant      == null ? "_":search_participant)   + "%\")");
//        sb.append(" OR (u_login LIKE        \"%" + (search_active           == null ? "_":search_active)        + "%\")");
//        sb.append(" OR (u_name LIKE         \"%" + (search_deactivated      == null ? "_":search_deactivated)   + "%\");");
        return sb;
    }

    public StringBuilder calculateUsersByCriteriaRequests(String search_user_id, String search_user_login,
                                                     String search_user_name, String search_user_surname,
                                                     String search_user_email/*, String search_administrator,
                                                     String search_moderator, String search_speaker,
                                                     String search_participant, String search_active,
                                                     String search_deactivated*/) {
        StringBuilder sb = new StringBuilder("SELECT COUNT(*) FROM CMS.users WHERE");
        sb.append(" (u_id LIKE \"%" + (search_user_id == null ? "_" :search_user_id) + "%\")");
        sb.append(" AND (u_login LIKE \"%" + (search_user_login == null ? "_":search_user_login) + "%\")");
        sb.append(" AND (u_name LIKE \"%" + (search_user_name == null ? "_":search_user_name) + "%\")");
        sb.append(" AND (u_surname LIKE \"%" + (search_user_surname == null ? "_":search_user_surname) + "%\")");
        sb.append(" AND (u_email LIKE \"%" + (search_user_email == null ? "_":search_user_email) + "%\");");
//        sb.append(" AND (u_role LIKE \"%" + (search_administrator == null ? "_":search_administrator) + "%\")");
//        sb.append(" AND (u_isActive LIKE \"%" + (search_moderator == null ? "_":search_moderator) + "%\")");
//        sb.append(" AND (u_password LIKE \"%" + (search_speaker == null ? "_":search_speaker) + "%\")")
//        sb.append(" AND (u_name LIKE \"%" + (search_participant == null ? "_":search_participant) + "%\")");
//        sb.append(" AND (u_login LIKE \"%" + (search_active == null ? "_": search_active) + "%\")");
//        sb.append(" AND (u_name LIKE \"%" + (search_deactivated == null ? "_":search_deactivated) + "%\");");
        return sb;
    }
}

