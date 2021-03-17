package com.leaguemanager.premierleaguemanager.model;

public class FootBallClub extends SportsClub implements Comparable {

    private int numberOfWins;
    private int numberOfLoss;
    private int numberOfMatchDraw;
    private int numberOfGoalsScored;
    private int numberOfGoalsAgainst;
    private int numberOfPoints;
    private int numberOfGoalDifference;

    public FootBallClub(String name,
                        String location,
                        String statistic) {
        super(name, location, statistic);

    }

    //Getters and Setters
    public int getNumberOfWins() {
        return numberOfWins;
    }
    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }
    public int getNumberOfLoss() {
        return numberOfLoss;
    }
    public void setNumberOfLoss(int numberOfLoss) {
        this.numberOfLoss = numberOfLoss;
    }
    public int getNumberOfMatchDraw() {
        return numberOfMatchDraw;
    }
    public void setNumberOfMatchDraw(int numberOfMatchDraw) {
        this.numberOfMatchDraw = numberOfMatchDraw;
    }
    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored = numberOfGoalsScored;
    }

    public int getNumberOfGoalsAgainst() {
        return numberOfGoalsAgainst;
    }

    public void setNumberOfGoalsAgainst(int numberOfGoalsAgainst) {
        this.numberOfGoalsAgainst = numberOfGoalsAgainst;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberOfGoalDifference() {
        return numberOfGoalDifference;
    }

    public void setNumberOfGoalDifference(int numberOfGoalDifference) {
        this.numberOfGoalDifference = numberOfGoalDifference;
    }

    public void incrementDraw() {
        this.numberOfMatchDraw += 1;
    }

    public void incrementWins() {
        this.numberOfWins += 1;
    }

    public void incrementLoss() {
        this.numberOfLoss += 1;
    }

    @Override
    public String toString() {
        return "FootBallClub{" +
                "numberOfWins=" + numberOfWins +
                ", numberOfLoss=" + numberOfLoss +
                ", numberOfMatchDraw=" + numberOfMatchDraw +
                ", numberOfMatchesPlayed=" + this.getNumberOfMatchesPlayed() +
                ", numberOfGoalsScored=" + numberOfGoalsScored +
                ", numberOfGoalReceived=" + numberOfGoalsAgainst +
                ", numberOfPoints=" + numberOfPoints +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        FootBallClub footBallClub = (FootBallClub) o;
        if (this.getNumberOfPoints()> footBallClub.numberOfPoints){
            return -1;
        }else if (this.getNumberOfPoints() < footBallClub.numberOfPoints) {
            return 1;
        }else {
            if ((this.getNumberOfGoalsScored() - this.getNumberOfGoalsAgainst()) >
                    (footBallClub.getNumberOfGoalsScored() - footBallClub.getNumberOfGoalsAgainst())){
                return -1;
            }else if ((this.getNumberOfGoalsScored() - this.getNumberOfGoalsAgainst()) <
                    (footBallClub.getNumberOfGoalsScored() - footBallClub.getNumberOfGoalsAgainst())) {
                return 1;
            }else {
                return 0;
            }
        }
    }
}
