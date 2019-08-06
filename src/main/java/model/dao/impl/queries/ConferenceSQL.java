package model.dao.impl.queries;

public enum ConferenceSQL {

    GET_CONFERENCES_BY_PAGINATION_QUERY("SELECT * FROM CMS.conferences LIMIT ?, ?;"),
    FIND_ALL_CONFERENCES_QUERY("SELECT * FROM CMS.conferences;"),
    CALC_CONFERENCES_ROWS("SELECT count(*) from CMS.conferences;"),

    CREATE_NEW_CONFERENCE_QUERY("INSERT INTO CMS.conferences(c_start_date, c_end_date, c_title_eng, c_title_ukr, c_city_eng, c_city_ukr, c_place_eng, c_place_ukr) VALUES (?,?,?,?,?,?,?,?);"),

    //CHANGE_START_DATE_QUERY("UPDATE CMS.conferences SET c_start_date = (?) WHERE c_id = (?);");
    CHANGE_START_DATE_QUERY("UPDATE CMS.conferences SET c_start_date=(?) WHERE c_id= (?);"),
    CHANGE_END_DATE_QUERY("UPDATE CMS.conferences SET c_end_date=(?) WHERE c_id= (?);"),
    CHANGE_CITY_QUERY("UPDATE CMS.conferences SET c_city_eng=(?), c_city_ukr=(?) WHERE c_id= (?);"),
    CHANGE_PLACE_QUERY("UPDATE CMS.conferences SET c_place_eng=(?), c_place_ukr=(?) WHERE c_id= (?);");
    String QUERY;

    ConferenceSQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}

