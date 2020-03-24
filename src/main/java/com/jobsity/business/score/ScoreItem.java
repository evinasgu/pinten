package com.jobsity.business.score;

public class ScoreItem {
    private ScoreTuple scoreTuple;
    private Integer total;

    public ScoreItem(ScoreTuple scoreTuple) {
        this.scoreTuple = scoreTuple;
        this.total = 0;
    }

    public ScoreTuple getScoreTuple() {
        return scoreTuple;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
