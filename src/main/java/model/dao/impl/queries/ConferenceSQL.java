package model.dao.impl.queries;

public enum ConferenceSQL {

    GET_CONFERENCES_BY_PAGINATION_QUERY("SELECT * FROM CMS.conferences LIMIT ?, ?;"),
    FIND_ALL_CONFERENCES_QUERY("SELECT * FROM CMS.conferences;"),
    CALC_CONFERENCES_ROWS("SELECT count(*) from CMS.conferences");

    String QUERY;

    ConferenceSQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}

