package model.dao.daoFactory;

import java.util.List;

public interface IAdminNEWDAO {
    void AddConference(String conferenceTitle);
    void AddModerator(String moderatorLogin);
    void AddSpeaker(String speakerLogin);
    void ApproveModerator(String moderatorLogin);
    void ApproveSpeaker(String speakerLogin);
    /*
    List<conference without moderators;
    List<conference without speakers;
    статистика зарегистрированных и пришедших пользователей.
     */

}
