package com.jobsity.business.score;

import com.jobsity.exception.BusinessException;

import java.util.List;

public interface GlobalScoreCalculator {
    PlayerScore calculateGlobalPlayerScore(String playerName, List<ScoreItem> scoreItems);
    List<PlayerScore> calculateScoreAllPlayers(List<String> players) throws BusinessException;
}
