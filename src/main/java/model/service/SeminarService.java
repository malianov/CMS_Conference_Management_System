package model.service;

import model.dao.daoFactory.DaoFactory;
import model.entity.Conference;
import model.entity.Seminar;
import model.exception.DAOException;
import model.exception.ServiceException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class SeminarService {
    private DaoFactory daoFactory;

    public SeminarService() {
        System.out.println("SeminarService.java -> inside UserService()");
        daoFactory = DaoFactory.getInstance();
    }




    public List<Seminar> findSeminarProgram(String conference_id) {
        System.out.println("SeminarService.java - > inside findSeminarProgram");
        return daoFactory.createSeminarDao().findSeminarProgram(conference_id);
    }

    public int calculateConferenceDurationDays(String conference_id) {
        System.out.println("SeminarService.java - > inside calculateConferenceDurationDays");
        return daoFactory.createSeminarDao().calculateConferenceDurationDays(conference_id);
    }

    public HashMap<String, List<Seminar>> SeminarsByDays(String conference_id) {
        System.out.println("SeminarService.java - > inside  printSeminarsByDays");
        return daoFactory.createSeminarDao().SeminarsByDays(conference_id);
    }

    public void changeSeminarTime(String seminar_time, String seminar_id) {
        daoFactory.createSeminarDao().changeSeminarTime(seminar_time, seminar_id);
    }

    public void changeSeminarTopic(String seminar_topic, String seminar_id) {
        daoFactory.createSeminarDao().changeSeminarTopic(seminar_topic, seminar_id);
    }

    public void changeSeminarSpeaker(String seminar_speaker, String seminar_id){
        daoFactory.createSeminarDao().changeSeminarSpeaker(seminar_speaker, seminar_id);
    }
    public void changeSeminarRoom(String seminar_room, String seminar_id){
        daoFactory.createSeminarDao().changeSeminarRoom(seminar_room, seminar_id);
    }
}
