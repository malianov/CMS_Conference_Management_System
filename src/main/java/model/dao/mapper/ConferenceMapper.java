package model.dao.mapper;

import model.entity.Conference;
import model.service.ConferenceService;
import model.service.ServiceFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ConferenceMapper implements ObjectMapper<Conference> {

    private static final String ID = "c_id";
    private static final String START_DATE = "c_start_date";
    private static final String END_DATE = "c_end_date";
    private static final String TITLE = "c_title";
    private static final String CITY = "c_city";
    private static final String PLACE = "c_place";

    @Override
    public Conference extractFromResultSet(ResultSet rs) throws SQLException {
        Conference conference = new Conference();

        conference.setId_conference(rs.getInt(ID));
        conference.setStart_date(rs.getString(START_DATE));
        conference.setEnd_date(rs.getString(END_DATE));
        conference.setConference_title(rs.getString(TITLE));
        conference.setConference_city(rs.getString(CITY));
        conference.setConference_place(rs.getString(PLACE));
        return conference;
    }

    //@Override
    public Conference makeUnique(Map<Integer, Conference> existing, Conference entity) {
        existing.putIfAbsent(entity.getId_conference(), entity);

        return existing.get(entity.getId_conference());
    }
}
