package model.service;

import model.dao.daoFactory.DaoFactory;
import model.dao.daoFactory.ConferenceDao;
import model.entity.Conference;
import model.exception.DAOException;
import model.exception.ServiceException;

import java.sql.SQLException;
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
            System.out.println("ConferenceService.java -> findAllConferences// inside try");
            System.out.println("ConferenceService.java -> findAllConferences// inside try" + daoFactory);
            return daoFactory.createConferenceDao().findAllConferences();
        } catch (DAOException | SQLException e) {
            System.out.println("ConferenceService.java -> findAllConferences// inside cath" + e);
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public PaginationResult getConferenceByPagination(int lowerBound, int upperBound) {
        ConferenceDao dao = daoFactory.createConferenceDao();
        return dao.findByPagination(lowerBound, upperBound);
    }

    public static class PaginationResult {
        private int noOfRows;
        private List<Conference> resultList;

        public int getNoOfRows() {
            return noOfRows;
        }

        public void setNoOfRecords(int noOfRecords) {
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
