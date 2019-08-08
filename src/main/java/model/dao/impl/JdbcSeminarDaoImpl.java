
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
import java.util.List;

public class JdbcSeminarDaoImpl implements SeminarDao {
    @Override
    public List<Seminar> findSeminarProgram(String conference_id) {

        SeminarMapper seminarMapper = new SeminarMapper();
        List<Seminar> seminars = new ArrayList<>();


        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        try (Connection conn = ConnectionPool.getConnection()) {
            System.out.println("JdbcSeminarDaoImpl.java -> inside findConferenceProgram TRY");

            PreparedStatement ps = conn.prepareStatement(SeminarSQL.GET_CONFERENCE_PROGRAM.getQUERY());
            ps.setString(1, conference_id);
            System.out.println("JdbcSeminarDaoImpl.java -> inside findConferenceProgram ps.executeQuery()" + ps);
            ResultSet rs = ps.executeQuery();
            System.out.println("JdbcSeminarDaoImpl.java -> inside findConferenceProgram RS" + rs);
            while (rs.next()) {
                Seminar seminar = seminarMapper.extractFromResultSet(rs);
                System.out.println("JdbcSeminarDaoImpl.java -> inside findConferenceProgram seminar = " + seminar);
                seminars.add(seminar);
            }

            System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" + seminars);
        } catch (SQLException e) {
        }
        System.out.println("seminars = " + seminars.size());
        return seminars;
    }

        @Override
        public void close () throws Exception {

        }
    }

