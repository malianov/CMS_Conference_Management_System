package model.dao.daoFactory;

public interface IModeratorNEWDAO {
    void topicTitleToSpeakerApprove();
    void topicTitleToSpeakerPropose();
    void topicTitleChange();
    void changeMeetingTime();
    void changeMeetingDate();
    void deleteMeeting();
}
