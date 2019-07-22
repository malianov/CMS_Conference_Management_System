package model.dao.daoFactory;

import model.entity.User;

public interface IUserNEWDAO {
    User findUserByLoginAndPassword(String login, String password);
    void meetingParticipateConfirm();
    void meetingCheckIn();
    void meetingParticipateCancel();
}
