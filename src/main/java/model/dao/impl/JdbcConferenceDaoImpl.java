package model.dao.impl;

import connection.ConnectionPool;
import model.dao.daoFactory.ConferenceDao;
import model.dao.impl.queries.ConferenceSQL;
import model.entity.Conference;
import model.exception.DAOException;
import model.service.ConferenceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcConferenceDaoImpl implements ConferenceDao {

    @Override
    public ConferenceService.PaginationResult findByPagination(int offset, int noOfRows) {
        return null;
    }

    @Override
    public List<Conference> findAllConferences() throws DAOException, SQLException {
        System.out.println("JdbcConferenceDAOImpl.java -> inside findAllConferences");
        List<Conference> list = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(ConferenceSQL.FIND_ALL_CONFERENCES_QUERY.getQUERY());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    System.out.println("JdbcConferenceDAOImpl.java -> inside findAllConferences////do");
                    Conference conference = new Conference();
                    conference.setId_conference(rs.getInt("c_id"));
                    conference.setStart_date(rs.getString("c_start_date"));
                    conference.setEnd_date(rs.getString("c_end_date"));
                    conference.setConference_title(rs.getString("c_title"));
                    conference.setConference_city(rs.getString("c_city"));
                    conference.setConference_place(rs.getString("c_place"));

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
