package com.leaguemanager.premierleaguemanager.model;


import java.io.Serializable;

public class SportsClub implements Comparable, Serializable {
    private String name;
    private String location;
    private  String Statistic;
    private int numberOfMatchesPlayed = 0;


    public SportsClub(String name, String location, String statistic) {
        this.name = name;
        this.location = location;
        this.Statistic = statistic;
    }

    //Getters and Setters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatistic() {
        return this.Statistic;
    }

    public void setStatistic(String statistic) {
        this.Statistic = statistic;
    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }

    public void incrementMatch() {
        this.numberOfMatchesPlayed += 1;
    }


    //Check sportsclub name
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return name.equals(that.name);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
