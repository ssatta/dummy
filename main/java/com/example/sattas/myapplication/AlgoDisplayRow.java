package com.example.sattas.myapplication;

/**
 * Created by sattas on 11/16/2014.
 */
public class AlgoDisplayRow {
    private String algoName;
    private long timeTaken;
    private long averageTimeTaken;

    public AlgoDisplayRow(String algoName, long timeTaken, long averageTimeTaken) {
        this.algoName = algoName;
        this.timeTaken = timeTaken;
        this.averageTimeTaken = averageTimeTaken;
    }

    public String getAlgoName() {
        return algoName;
    }

    public void setAlgoName(String algoName) {
        this.algoName = algoName;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    public long getAverageTimeTaken() {
        return averageTimeTaken;
    }

    public void setAverageTimeTaken(long averageTimeTaken) {
        this.averageTimeTaken = averageTimeTaken;
    }
}
