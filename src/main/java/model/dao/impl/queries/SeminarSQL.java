package model.dao.impl.queries;

public enum SeminarSQL {
    GET_CONFERENCE_PROGRAM("SELECT id_seminar, day_conference, seminar_time," +
            "seminar_topic, seminar_speaker FROM CMS.conference_days WHERE id_conference= (?);"),

    GET_CONFERENCE_DAYS_QUANTITY("SELECT count(distinct day_conference) FROM CMS.conference_days WHERE id_conference= ('?');");

    String QUERY;

    SeminarSQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}


