package model.dao.mapper;

import model.entity.Conference;
import model.entity.Seminar;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeminarMapper implements ObjectMapper<Seminar> {

    private static final String GLOBAL_SEMINAR_ID = "id_global_seminar";
    private static final String SEMINAR_ID = "id_seminar";
    //private static final String CONFERENCE_ID = "id_conference";
    private static final String CONFERENCE_DAY = "day_conference";
    private static final String SEMINAR_TIME = "seminar_time";
    private static final String SEMINAR_TOPIC = "seminar_topic";
    private static final String SEMINAR_SPEAKER = "seminar_speaker";
    private static final String SEMINAR_ROOM = "seminar_room";

    @Override
    public Seminar extractFromResultSet(ResultSet rs) throws SQLException {
        Seminar seminar = new Seminar();

        seminar.setIdGlobalSeminar(rs.getInt(GLOBAL_SEMINAR_ID));
        seminar.setIdSeminar(rs.getInt(SEMINAR_ID));
        //seminar.setIdConference(rs.getInt(CONFERENCE_ID));
        seminar.setDayConference(rs.getString(CONFERENCE_DAY));
        seminar.setSeminarTime(rs.getString(SEMINAR_TIME));
        seminar.setSeminarTopic(rs.getString(SEMINAR_TOPIC));
        seminar.setSeminarSpeaker(rs.getString(SEMINAR_SPEAKER));
        seminar.setSeminarRoom(rs.getString(SEMINAR_ROOM));
        return seminar;
    }

    //@Override
/*    public Conference makeUnique(Map<Integer, Conference> existing, Conference entity) {
        existing.putIfAbsent(entity.getIdConference(), entity);

        return existing.get(entity.getIdConference());
    }*/
}
