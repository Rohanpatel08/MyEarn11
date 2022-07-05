package com.example.MyEarn11.Model;

public class FootballClientModel {
    String MatchName, MTime, MDate, Venue, Status, Id;

    public FootballClientModel() {
    }

    public String getMatchName() {
        return MatchName;
    }

    public String getMTime() {
        return MTime;
    }

    public String getMDate() {
        return MDate;
    }

    public String getVenue() {
        return Venue;
    }

    public String getStatus() {
        return Status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
