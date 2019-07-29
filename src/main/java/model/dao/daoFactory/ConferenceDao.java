package model.dao.daoFactory;

import model.entity.Conference;
import model.exception.DAOException;
import model.service.ConferenceService;

import java.sql.SQLException;
import java.util.List;

public interface ConferenceDao extends GenericDao<Conference> {
    ConferenceService.PaginationResult findByPagination(int offset, int noOfRows);
    List<Conference> findAllConferences() throws DAOException, SQLException;
}