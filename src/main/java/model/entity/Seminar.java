package model.entity;

public class Seminar {
    private int idGlobalSeminar;
    private int idSeminar;
    private int idConference;
    private String dayConference;
    private String seminarTime;
    private String seminarTopic;
    private String seminarSpeaker;

    public Seminar(int idGlobalSeminar, int idSeminar, int idConference, String dayConference, String seminarTime, String seminarTopic, String seminarSpeaker) {
        this.idGlobalSeminar = idGlobalSeminar;
        this.idSeminar = idSeminar;
        this.idConference = idConference;
        this.dayConference = dayConference;
        this.seminarTime = seminarTime;
        this.seminarTopic = seminarTopic;
        this.seminarSpeaker = seminarSpeaker;
    }

    public Seminar(int idSeminar, String seminarTime, String seminarTopic, String seminarSpeaker) {
        this.idSeminar = idSeminar;
        this.seminarTime = seminarTime;
        this.seminarTopic = seminarTopic;
        this.seminarSpeaker = seminarSpeaker;
    }

    public Seminar() {
    }

    public int getIdGlobalSeminar() {
        return idGlobalSeminar;
    }

    public void setIdGlobalSeminar(int idGlobalSeminar) {
        this.idGlobalSeminar = idGlobalSeminar;
    }

    public int getIdSeminar() {
        return idSeminar;
    }

    public void setIdSeminar(int idSeminar) {
        this.idSeminar = idSeminar;
    }

    public int getIdConference() {
        return idConference;
    }

    public void setIdConference(int idConference) {
        this.idConference = idConference;
    }

    public String getDayConference() {
        return dayConference;
    }

    public void setDayConference(String dayConference) {
        this.dayConference = dayConference;
    }

    public String getSeminarTime() {
        return seminarTime;
    }

    public void setSeminarTime(String seminarTime) {
        this.seminarTime = seminarTime;
    }

    public String getSeminarTopic() {
        return seminarTopic;
    }

    public void setSeminarTopic(String seminarTopic) {
        this.seminarTopic = seminarTopic;
    }

    public String getSeminarSpeaker() {
        return seminarSpeaker;
    }

    public void setSeminarSpeaker(String seminarSpeaker) {
        this.seminarSpeaker = seminarSpeaker;
    }

    @Override
    public String toString() {
        return "Seminar{" +
                "idGlobalSeminar=" + idGlobalSeminar +
                ", idSeminar=" + idSeminar +
                ", idConference=" + idConference +
                ", dayConference='" + dayConference + '\'' +
                ", seminarTime='" + seminarTime + '\'' +
                ", seminarTopic='" + seminarTopic + '\'' +
                ", seminarSpeaker='" + seminarSpeaker + '\'' +
                '}';
    }
}
