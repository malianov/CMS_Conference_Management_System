package model.dao.impl.queries;

public enum ConferenceSQL {

    //FIND_ALL_CONFERENCES_QUERY("SELECT * FROM CMS.conferences LIMIT 10 OFFSET 19;");
    FIND_ALL_CONFERENCES_QUERY("SELECT * FROM CMS.conferences;");

    String QUERY;

    ConferenceSQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}

