package model.entity;

public class Seminar {
    private int idGlobalSeminar;
    private int idSeminar;
    private int idConference;
    private String dayConference;
    private String seminarTime;
    private String seminarTitle_eng;
    private String seminarTitle_ukr;
    private String seminarSpeaker;
    private String seminarRoom;

    public Seminar(int idGlobalSeminar, int idSeminar, int idConference, String dayConference, String seminarTime, String seminarTitle_eng, String seminarTitle_ukr, String seminarSpeaker, String seminarRoom) {
        this.idGlobalSeminar = idGlobalSeminar;
        this.idSeminar = idSeminar;
        this.idConference = idConference;
        this.dayConference = dayConference;
        this.seminarTime = seminarTime;
        this.seminarTitle_eng = seminarTitle_eng;
        this.seminarTitle_ukr = seminarTitle_ukr;
        this.seminarSpeaker = seminarSpeaker;
        this.seminarRoom = seminarRoom;
    }

    public Seminar(int idSeminar, String seminarTime, String seminarTitle_eng, String seminarTitle_ukr, String seminarSpeaker) {
        this.idSeminar = idSeminar;
        this.seminarTime = seminarTime;
        this.seminarTitle_eng = seminarTitle_eng;
        this.seminarTitle_ukr = seminarTitle_ukr;
        this.seminarSpeaker = seminarSpeaker;
    }

    public Seminar() {
    }

    public String getSeminarRoom() {
        return seminarRoom;
    }

    public void setSeminarRoom(String seminarRoom) {
        this.seminarRoom = seminarRoom;
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

    public String getSeminarSpeaker() {
        return seminarSpeaker;
    }

    public void setSeminarSpeaker(String seminarSpeaker) {
        this.seminarSpeaker = seminarSpeaker;
    }

    public String getSeminarTitle_eng() {
        return seminarTitle_eng;
    }

    public void setSeminarTitle_eng(String seminarTitle_eng) {
        this.seminarTitle_eng = seminarTitle_eng;
    }

    public String getSeminarTitle_ukr() {
        return seminarTitle_ukr;
    }

    public void setSeminarTitle_ukr(String seminarTitle_ukr) {
        this.seminarTitle_ukr = seminarTitle_ukr;
    }

    @Override
    public String toString() {
        return "Seminar{" +
                "idGlobalSeminar=" + idGlobalSeminar +
                ", idSeminar=" + idSeminar +
                ", idConference=" + idConference +
                ", dayConference='" + dayConference + '\'' +
                ", seminarTime='" + seminarTime + '\'' +
                ", seminarTitle_eng='" + seminarTitle_eng + '\'' +
                ", seminarTitle_ukr='" + seminarTitle_ukr + '\'' +
                ", seminarSpeaker='" + seminarSpeaker + '\'' +
                ", seminarRoom='" + seminarRoom + '\'' +
                '}';
    }
}
