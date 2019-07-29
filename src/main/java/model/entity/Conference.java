package model.entity;

public class Conference {
    private int id_conference;
    private String start_date;
    private String end_date;
    private String conference_title;
    private String conference_city;
    private String conference_place;

    public Conference() {}

    public Conference(int id_conference, String start_date, String end_date, String conference_title, String conference_city, String conference_place) {
        this.id_conference = id_conference;
        this.start_date = start_date;
        this.end_date = end_date;
        this.conference_title = conference_title;
        this.conference_city = conference_city;
        this.conference_place = conference_place;
    }

    public int getId_conference() {
        return id_conference;
    }

    public void setId_conference(int id_conference) {
        this.id_conference = id_conference;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getConference_title() {
        return conference_title;
    }

    public void setConference_title(String conference_title) {
        this.conference_title = conference_title;
    }

    public String getConference_city() {
        return conference_city;
    }

    public void setConference_city(String conference_city) {
        this.conference_city = conference_city;
    }

    public String getConference_place() {
        return conference_place;
    }

    public void setConference_place(String conference_place) {
        this.conference_place = conference_place;
    }
}
