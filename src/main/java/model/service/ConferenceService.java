package model.service;

import model.dao.daoFactory.DaoFactory;
import model.dao.daoFactory.ConferenceDao;
import model.entity.Conference;
import model.exception.DAOException;
import model.exception.ServiceException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ConferenceService {
    private DaoFactory daoFactory;

    public ConferenceService() {
        System.out.println("UserService.java -> inside UserService()");
        daoFactory = DaoFactory.getInstance();
    }

    public List<Conference> findAllConferences() throws ServiceException {
        System.out.println("ConferenceService.java -> findAllConferences");
        try {
            return daoFactory.createConferenceDao().findAllConferences();

        } catch (DAOException | SQLException e) {
            System.out.println("ConferenceService.java -> findAllConferences// inside cath" + e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public PaginationResult getConferencesByPagination(int lowerBound, int upperBound) {
        System.out.println("ConferenceService.java -> getConferencesByPaginatio");

        return daoFactory.createConferenceDao().findByPagination(lowerBound, upperBound);
    }

    public void addNewConference(Conference conference) {
        daoFactory.createConferenceDao().addNewConference(conference);
    }

    public void changeStartDate(String idConference, LocalDate newDate) {
        daoFactory.createConferenceDao().changeStartDate(idConference, newDate);
    }

    public void changeEndDate(String idConference, LocalDate newDate) {
        daoFactory.createConferenceDao().changeEndDate(idConference, newDate);
    }

    public void changeCity(String cityEng, String cityUkr, String idConference) {
        daoFactory.createConferenceDao().changeCity(cityEng, cityUkr, idConference);
    }

    public void changePlace(String placeEng, String placeUkr, String idConference) {
        daoFactory.createConferenceDao().changePlace(placeEng, placeUkr, idConference);
    }

    public void findProgram(String conference_id) {
        daoFactory.createSeminarDao().findSeminarProgram(conference_id);
    }

    public static class PaginationResult {

        private int noOfRows;
        private List<Conference> resultList;

        public int getNoOfRows() {
            return noOfRows;
        }

        public void setNoOfRecords(int noOfRows) {
            this.noOfRows = noOfRows;
        }

        public List<Conference> getResultList() {
            return resultList;
        }

        public void setResultList(List<Conference> resultList) {
            this.resultList = resultList;
        }
    }
}
