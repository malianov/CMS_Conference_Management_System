package model.dao.impl;

import connection.ConnectionPool;
import model.dao.daoFactory.ConferenceDao;
import model.dao.impl.queries.ConferenceSQL;
import model.dao.mapper.ConferenceMapper;
import model.entity.Conference;
import model.exception.DAOException;
import model.service.ConferenceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class JdbcConferenceDaoImpl implements ConferenceDao {

    @Override
    public ConferenceService.PaginationResult findByPagination(int lowerBound, int upperBound) {
        ConferenceService.PaginationResult paginationResult = new ConferenceService.PaginationResult();

        Map<Integer, Conference> conferences = new HashMap<>();
        ConferenceMapper conferenceMapper = new ConferenceMapper();

        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement conferencesPS = conn.prepareStatement(ConferenceSQL.GET_CONFERENCES_BY_PAGINATION_QUERY.getQUERY());
            PreparedStatement countConferencesPS = conn.prepareStatement(ConferenceSQL.CALC_CONFERENCES_ROWS.getQUERY());

            conferencesPS.setInt(1, lowerBound);
            conferencesPS.setInt(2, upperBound);

            ResultSet rs = conferencesPS.executeQuery();
            while (rs.next()) {
                Conference conference = conferenceMapper.extractFromResultSet(rs);
                conference = conferenceMapper.makeUnique(conferences, conference);
            }
            rs.close();

            rs = countConferencesPS.executeQuery();
            if(rs.next()) {
                paginationResult.setNoOfRecords(rs.getInt(1));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        paginationResult.setResultList(new ArrayList<>(conferences.values()));
        return paginationResult;
    }

    @Override
    public List<Conference> findAllConferences() throws DAOException, SQLException {
        System.out.println("JdbcConferenceDAOImpl.java -> inside findAllConferences");

        ConferenceMapper conferenceMapper = new ConferenceMapper();
        Conference conference;

        List<Conference> list = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(ConferenceSQL.FIND_ALL_CONFERENCES_QUERY.getQUERY());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    System.out.println("JdbcConferenceDAOImpl.java -> inside findAllConferences////do");
                    conference = conferenceMapper.extractFromResultSet(rs);
                    list.add(conference);
                } while (rs.next());
            } else {
                //logger
            }
        } catch (SQLException e) {
            //logger
        }
        System.out.println(list);
        return list;
    }

    @Override
    public void close() throws Exception {
    }
}
