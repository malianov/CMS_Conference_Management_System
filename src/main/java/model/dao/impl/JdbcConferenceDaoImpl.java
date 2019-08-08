package model.dao.impl;

import connection.ConnectionPool;
import model.dao.daoFactory.ConferenceDao;
import model.dao.impl.queries.ConferenceSQL;
import model.dao.mapper.ConferenceMapper;
import model.entity.Conference;
import model.exception.DAOException;
import model.service.ConferenceService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class JdbcConferenceDaoImpl implements ConferenceDao {

    @Override
    public ConferenceService.PaginationResult findByPagination(int lowerBound, int upperBound) {
        ConferenceService.PaginationResult paginationResult = new ConferenceService.PaginationResult();

        List<Conference> conferences = new ArrayList<>();
        ConferenceMapper conferenceMapper = new ConferenceMapper();

        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement conferencesPS = conn.prepareStatement(ConferenceSQL.GET_CONFERENCES_BY_PAGINATION_QUERY.getQUERY());
            PreparedStatement countConferencesPS = conn.prepareStatement(ConferenceSQL.CALC_CONFERENCES_ROWS.getQUERY());

            conferencesPS.setInt(1, lowerBound);
            conferencesPS.setInt(2, upperBound);

            ResultSet rs = conferencesPS.executeQuery();
            while (rs.next()) {
                Conference conference = conferenceMapper.extractFromResultSet(rs);
                conferences.add(conference);
            }
            rs.close();

            rs = countConferencesPS.executeQuery();
            if (rs.next()) {
                paginationResult.setNoOfRecords(rs.getInt(1));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        paginationResult.setResultList(conferences);/////////////////////////////////
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
    public void addNewConference(Conference conference) {
        System.out.println("JdbcConferenceDaoImpl.java -> inside addNewConference");
        try (Connection conn = ConnectionPool.getConnection()) {
            System.out.println("JdbcConferenceDaoImpl.java -> inside addNewConference TRY");
            PreparedStatement ps = conn.prepareStatement(ConferenceSQL.CREATE_NEW_CONFERENCE_QUERY.getQUERY());
            ps.setString(1, conference.getStartDate());
            ps.setString(2, conference.getEndDate());
            ps.setString(3, conference.getConferenceTitleEng());
            ps.setString(4, conference.getConferenceTitleUkr());
            ps.setString(5, conference.getConferenceCityEng());
            ps.setString(6, conference.getConferenceCityUkr());
            ps.setString(7, conference.getConferencePlaceEng());
            ps.setString(8, conference.getConferencePlaceUkr());

            int result = ps.executeUpdate();
            System.out.println("JdbcConferenceDaoImpl.java -> result = " + result);
            if (result != 0) {
                conn.commit();
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public void changeStartDate(String idConference, LocalDate newDate) {
        try (Connection conn = ConnectionPool.getConnection()) {
            System.out.println("JdbcConferenceDaoImpl.java -> inside changDate TRY");

            PreparedStatement ps = conn.prepareStatement(ConferenceSQL.CHANGE_START_DATE_QUERY.getQUERY());
            ps.setString(2, idConference);
            ps.setDate(1, Date.valueOf(newDate));

            System.out.println("JdbcConferenceDaoImpl.java -> newDate = " + newDate);
            System.out.println("JdbcConferenceDaoImpl.java -> ps = " + ps);
            int result = ps.executeUpdate();
            System.out.println("JdbcConferenceDaoImpl.java -> result = " + result);
            if (result != 0) {
                conn.commit();
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public void changeEndDate(String idConference, LocalDate newDate) {
        try (Connection conn = ConnectionPool.getConnection()) {
            System.out.println("JdbcConferenceDaoImpl.java -> inside changDate TRY");

            PreparedStatement ps = conn.prepareStatement(ConferenceSQL.CHANGE_END_DATE_QUERY.getQUERY());
            ps.setString(2, idConference);
            ps.setDate(1, Date.valueOf(newDate));

            System.out.println("JdbcConferenceDaoImpl.java -> newDate = " + newDate);
            System.out.println("JdbcConferenceDaoImpl.java -> ps = " + ps);
            int result = ps.executeUpdate();
            System.out.println("JdbcConferenceDaoImpl.java -> result = " + result);
            if (result != 0) {
                conn.commit();
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public void changeCity(String cityEng, String cityUkr, String idConference) {
        try (Connection conn = ConnectionPool.getConnection()) {
            System.out.println("JdbcConferenceDaoImpl.java -> inside changeCity TRY");

            PreparedStatement ps = conn.prepareStatement(ConferenceSQL.CHANGE_CITY_QUERY.getQUERY());
            ps.setString(1, cityEng);
            ps.setString(2, cityUkr);
            ps.setString(3, idConference);

            System.out.println("JdbcConferenceDaoImpl.java -> ps = " + ps);
            int result = ps.executeUpdate();
            System.out.println("JdbcConferenceDaoImpl.java -> result = " + result);
            if (result != 0) {
                conn.commit();
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public void changePlace(String placeEng, String placeUkr, String idConference) {
        try (Connection conn = ConnectionPool.getConnection()) {
            System.out.println("JdbcConferenceDaoImpl.java -> inside changeCity TRY");

            PreparedStatement ps = conn.prepareStatement(ConferenceSQL.CHANGE_PLACE_QUERY.getQUERY());
            ps.setString(1, placeEng);
            ps.setString(2, placeUkr);
            ps.setString(3, idConference);

            System.out.println("JdbcConferenceDaoImpl.java -> ps = " + ps);
            int result = ps.executeUpdate();
            System.out.println("JdbcConferenceDaoImpl.java -> result = " + result);
            if (result != 0) {
                conn.commit();
            }
        } catch (SQLException e) {
        }
    }



    @Override
        public void close () throws Exception {
        }
    }
