package model.dao.daoFactory;

import model.entity.Seminar;

import java.util.HashMap;
import java.util.List;

public interface SeminarDao extends GenericDao {
    List<Seminar> findSeminarProgram(String conference_id);

    int calculateConferenceDurationDays(String conference_id);

    HashMap<String, List<Seminar>> SeminarsByDays(String conference_id);

    void changeSeminarTime(String seminar_time, String seminar_id);

    public void changeSeminarTopic(String seminar_topic, String seminar_id);

    public void changeSeminarSpeaker(String seminar_speaker, String seminar_id);
    public void changeSeminarRoom(String seminar_room, String seminar_id);
}
