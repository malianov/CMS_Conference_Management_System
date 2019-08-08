package model.dao.daoFactory;

import model.entity.Seminar;

import java.util.HashMap;
import java.util.List;

public interface SeminarDao extends GenericDao {
    List<Seminar> findSeminarProgram(String conference_id);

    int calculateConferenceDurationDays(String conference_id);

    HashMap<String, List<Seminar>> SeminarsByDays(String conference_id);
}
