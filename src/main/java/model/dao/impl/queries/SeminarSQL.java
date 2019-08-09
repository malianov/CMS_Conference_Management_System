package model.dao.impl.queries;

public enum SeminarSQL {
    GET_CONFERENCE_PROGRAM("SELECT id_seminar, day_conference, seminar_time," +
            "seminar_topic, seminar_speaker FROM CMS.conference_days WHERE id_conference= (?);"),

    GET_CONFERENCE_DAYS_QUANTITY("SELECT count(distinct day_conference) FROM CMS.conference_days WHERE id_conference= (?);"),

    GET_CONFERENCE_PROGRAM_BY_DAY("SELECT id_global_seminar, id_seminar, day_conference, seminar_time, seminar_topic, seminar_speaker, seminar_room FROM CMS.conference_days WHERE id_conference= (?) AND day_conference= (?);"),

    CHANGE_SEMINAR_TIME_QUERY("UPDATE CMS.conference_days SET seminar_time=(?) WHERE id_global_seminar= (?);"),

    CHANGE_SEMINAR_TOPIC_QUERY("UPDATE CMS.conference_days SET seminar_topic=(?) WHERE id_global_seminar= (?);"),

    CHANGE_SEMINAR_SPEAKER_QUERY("UPDATE CMS.conference_days SET seminar_speaker=(?) WHERE id_global_seminar= (?);"),
    CHANGE_SEMINAR_ROOM_QUERY("UPDATE CMS.conference_days SET seminar_room=(?) WHERE id_global_seminar= (?);");

    String QUERY;

    SeminarSQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}


