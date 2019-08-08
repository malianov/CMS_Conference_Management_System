package model.dao.daoFactory;

import model.entity.Seminar;

import java.util.List;

public interface SeminarDao extends GenericDao {
    List<Seminar> findSeminarProgram(String conference_id);
}
