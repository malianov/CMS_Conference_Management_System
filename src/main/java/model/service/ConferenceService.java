package model.service;

import model.dao.daoFactory.ConferenceDao;
import model.dao.daoFactory.DaoFactory;
import model.entity.Conference;

import java.util.List;

public class ConferenceService {
    private DaoFactory daoFactory;

    public PaginationResult getCalendarByPagination(int lowerBound, int upperBound) {
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
