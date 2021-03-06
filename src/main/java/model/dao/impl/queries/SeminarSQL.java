package model.dao.impl.queries;

public enum SeminarSQL {
    GET_CONFERENCE_PROGRAM("SELECT id_seminar, day_conference, seminar_time," +
            "seminar_topic, seminar_speaker FROM cms.conference_days WHERE id_conference= (?);"),

    GET_CONFERENCE_DAYS_QUANTITY("SELECT count(distinct day_conference) FROM cms.conference_days WHERE id_conference= (?);"),

    GET_CONFERENCE_PROGRAM_BY_DAY("SELECT id_global_seminar, id_seminar, day_conference, seminar_time, seminar_title_eng, seminar_title_ukr, seminar_speaker, seminar_room FROM cms.conference_days WHERE id_conference= (?) AND day_conference= (?);"),

    CHANGE_SEMINAR_TIME_QUERY("UPDATE cms.conference_days SET seminar_time=(?) WHERE id_global_seminar= (?);"),

    CHANGE_SEMINAR_TITLE_QUERY("UPDATE cms.conference_days SET seminar_title_eng=(?), seminar_title_ukr=(?) WHERE id_global_seminar= (?);"),

    CHANGE_SEMINAR_SPEAKER_QUERY("UPDATE cms.conference_days SET seminar_speaker=(?) WHERE id_global_seminar= (?);"),
    CHANGE_SEMINAR_ROOM_QUERY("UPDATE cms.conference_days SET seminar_room=(?) WHERE id_global_seminar= (?);"),
    CHANGE_SEMINAR_DAY_QUERY("UPDATE cms.conference_days SET day_conference=(?) WHERE id_global_seminar= (?);");
    String QUERY;

    SeminarSQL(String QUERY) {
        this.QUERY = QUERY;
    }

    public String getQUERY() {
        return QUERY;
    }
}


