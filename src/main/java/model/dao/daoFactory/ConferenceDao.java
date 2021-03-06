package model.dao.daoFactory;

import model.entity.Conference;
import model.exception.DAOException;
import model.service.ConferenceService;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface ConferenceDao extends AutoCloseable {
    ConferenceService.PaginationResult findByPagination(int offset, int noOfRows);
    List<Conference> findAllConferences() throws DAOException, SQLException;
    void addNewConference(Conference conference);
    void changeStartDate(String idConference, LocalDate newDate);
    void changeEndDate(String idConference, LocalDate newDate);
    void changeCity(String cityEng, String cityUkr, String idConference);
    void changePlace(String placeEng, String placeUkr, String idConference);
    void changeConferenceTitle(String conferenceTitleEng, String conferenceTitleUkr, String conferenceId);
}