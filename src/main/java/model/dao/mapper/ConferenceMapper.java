package model.dao.mapper;

import model.entity.Conference;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConferenceMapper implements ObjectMapper<Conference> {

    private static final String ID = "c_id";
    private static final String START_DATE = "c_start_date";
    private static final String END_DATE = "c_end_date";
    private static final String TITLE_ENG = "c_title_eng";
    private static final String TITLE_UKR = "c_title_ukr";
    private static final String CITY_ENG = "c_city_eng";
    private static final String CITY_UKR = "c_city_ukr";
    private static final String PLACE_ENG = "c_place_eng";
    private static final String PLACE_UKR = "c_place_ukr";

    @Override
    public Conference extractFromResultSet(ResultSet rs) throws SQLException {
        Conference conference = new Conference();

        conference.setIdConference(rs.getInt(ID));
        conference.setStartDate(rs.getString(START_DATE));
        conference.setEndDate(rs.getString(END_DATE));
        conference.setConferenceTitleEng(rs.getString(TITLE_ENG));
        conference.setConferenceTitleUkr(rs.getString(TITLE_UKR));
        conference.setConferenceCityEng(rs.getString(CITY_ENG));
        conference.setConferenceCityUkr(rs.getString(CITY_UKR));
        conference.setConferencePlaceEng(rs.getString(PLACE_ENG));
        conference.setConferencePlaceUkr(rs.getString(PLACE_UKR));
        return conference;
    }
}
