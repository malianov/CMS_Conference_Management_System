
package model.dao.impl;

import connection.ConnectionPool;
import model.dao.daoFactory.SeminarDao;
import model.dao.impl.queries.SeminarSQL;
import model.dao.mapper.SeminarMapper;
import model.entity.Seminar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JdbcSeminarDaoImpl implements SeminarDao {
    @Override
    public List<Seminar> findSeminarProgram(String conference_id) {
        SeminarMapper seminarMapper = new SeminarMapper();
        List<Seminar> seminars = new ArrayList<>();

        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SeminarSQL.GET_CONFERENCE_PROGRAM.getQUERY());
            ps.setString(1, conference_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Seminar seminar = seminarMapper.extractFromResultSet(rs);
                seminars.add(seminar);
            }
        } catch (SQLException e) {
        }
        return seminars;
    }

    @Override
    public int calculateConferenceDurationDays(String conference_id) {
        int countDaysPS = 0;
        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SeminarSQL.GET_CONFERENCE_DAYS_QUANTITY.getQUERY());
            ps.setString(1, conference_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                countDaysPS = rs.getInt(1);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countDaysPS;
    }

    @Override
    public HashMap<String, List<Seminar>> SeminarsByDays(String conference_id) {

        HashMap<String, List<Seminar>> conferenceSeminarsByDays = new HashMap<>();

        int conferenceDaysNumber = calculateConferenceDurationDays(conference_id);

        for (int day = 1; day <= conferenceDaysNumber; day++) {
            conferenceSeminarsByDays.put("Day-" + day, findSeminarProgramByDay(conference_id, day));
            System.out.println("conferenceSeminarsByDays.put = " + findSeminarProgramByDay(conference_id, day));
        }
        return conferenceSeminarsByDays;
    }

    public List<Seminar> findSeminarProgramByDay(String conference_id, int day_id) {
        SeminarMapper seminarMapper = new SeminarMapper();
        List<Seminar> seminars = new ArrayList<>();

        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SeminarSQL.GET_CONFERENCE_PROGRAM_BY_DAY.getQUERY());
            ps.setString(1, conference_id);
            ps.setInt(2, day_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Seminar seminar = seminarMapper.extractFromResultSet(rs);
                seminars.add(seminar);
            }
        } catch (SQLException e) {
        }
        return seminars;
    }

    @Override
    public void close() throws Exception {
    }
}

