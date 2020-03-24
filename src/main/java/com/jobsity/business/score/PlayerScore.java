package com.jobsity.business.score;

import java.util.List;

public class PlayerScore {
    private String playerName;
    private List<ScoreItem> scoreItems;

    public PlayerScore(String playerName, List scoreItems) {
        this.playerName = playerName;
        this.scoreItems = scoreItems;
    }

    public List<ScoreItem> getScoreItems() {
        return scoreItems;
    }
}
