package com.leaguemanager.premierleaguemanager.model;

public class UniversityFootBallClub extends FootBallClub {

    private String universityName;
    private String universityLocation;


    public UniversityFootBallClub( String name, String location, String statistic,String universityName ,String universityLocation ) {
        super(name, location, statistic);
        this.universityName = universityName;
        this.universityLocation = universityLocation;
    }



    //Getters and Setters
    public String getUniversityName() { return universityName; }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityLocation() {
        return this.universityLocation;
    }

    public void setUniversityLocation(String universityLocation) {
        this.universityLocation = universityLocation;
    }


}
