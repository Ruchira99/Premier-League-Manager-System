package com.leaguemanager.premierleaguemanager.model;

public class SchoolFootballClub extends FootBallClub {
    private String schoolName;
    private String schoolLocation;



    public SchoolFootballClub(String name, String location, String statistic,String schoolName, String schoolLocation) {
        super(name, location, statistic);
        this.schoolName = schoolName;
        this.schoolLocation = schoolLocation;
    }


    //Getters and Setters
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

}
