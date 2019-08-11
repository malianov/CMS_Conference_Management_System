package model.entity;

public class Conference {
    private int idConference;
    private String startDate;
    private String endDate;
    private String conferenceTitleEng;
    private String conferenceTitleUkr;
    private String conferenceCityEng;
    private String conferenceCityUkr;
    private String conferencePlaceEng;
    private String conferencePlaceUkr;

    public Conference() {}

    public Conference(String startDate, String endDate, String conferenceTitleEng, String conferenceTitleUkr,
                      String conferenceCityEng, String conferenceCityUkr, String conferencePlaceEng, String conferencePlaceUkr) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.conferenceTitleEng = conferenceTitleEng;
        this.conferenceTitleUkr = conferenceTitleUkr;
        this.conferenceCityEng = conferenceCityEng;
        this.conferenceCityUkr = conferenceCityUkr;
        this.conferencePlaceEng = conferencePlaceEng;
        this.conferencePlaceUkr = conferencePlaceUkr;
    }

    public Conference(int idConference, String startDate, String endDate, String conferenceTitleEng, String conferenceTitleUkr,
                      String conferenceCityEng, String conferenceCityUkr, String conferencePlaceEng, String conferencePlaceUkr) {
        this.idConference = idConference;
        this.startDate = startDate;
        this.endDate = endDate;
        this.conferenceTitleEng = conferenceTitleEng;
        this.conferenceTitleUkr = conferenceTitleUkr;
        this.conferenceCityEng = conferenceCityEng;
        this.conferenceCityUkr = conferenceCityUkr;
        this.conferencePlaceEng = conferencePlaceEng;
        this.conferencePlaceUkr = conferencePlaceUkr;
    }

    public int getIdConference() {
        return idConference;
    }

    public void setIdConference(int idConference) {
        this.idConference = idConference;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getConferenceTitleEng() {
        return conferenceTitleEng;
    }

    public void setConferenceTitleEng(String conferenceTitleEng) {
        this.conferenceTitleEng = conferenceTitleEng;
    }

    public String getConferenceTitleUkr() {
        return conferenceTitleUkr;
    }

    public void setConferenceTitleUkr(String conferenceTitleUkr) {
        this.conferenceTitleUkr = conferenceTitleUkr;
    }

    public String getConferenceCityEng() {
        return conferenceCityEng;
    }

    public void setConferenceCityEng(String conferenceCityEng) {
        this.conferenceCityEng = conferenceCityEng;
    }

    public String getConferenceCityUkr() {
        return conferenceCityUkr;
    }

    public void setConferenceCityUkr(String conferenceCityUkr) {
        this.conferenceCityUkr = conferenceCityUkr;
    }

    public String getConferencePlaceEng() {
        return conferencePlaceEng;
    }

    public void setConferencePlaceEng(String conferencePlaceEng) {
        this.conferencePlaceEng = conferencePlaceEng;
    }

    public String getConferencePlaceUkr() {
        return conferencePlaceUkr;
    }

    public void setConferencePlaceUkr(String conferencePlaceUkr) {
        this.conferencePlaceUkr = conferencePlaceUkr;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "idConference=" + idConference +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", conferenceTitleEng='" + conferenceTitleEng + '\'' +
                ", conferenceTitleUkr='" + conferenceTitleUkr + '\'' +
                ", conferenceCityEng='" + conferenceCityEng + '\'' +
                ", conferenceCityUkr='" + conferenceCityUkr + '\'' +
                ", conferencePlaceEng='" + conferencePlaceEng + '\'' +
                ", conferencePlaceUkr='" + conferencePlaceUkr + '\'' +
                '}';
    }

}
