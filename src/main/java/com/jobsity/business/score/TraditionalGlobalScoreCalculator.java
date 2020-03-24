package com.jobsity.business.score;

import com.jobsity.exception.BusinessException;
import com.jobsity.business.data.DataProvider;

import java.util.*;

public class TraditionalGlobalScoreCalculator implements GlobalScoreCalculator {

    TraditionalSingleScoreCalculator calculator = new TraditionalSingleScoreCalculator();

    @Override
    public PlayerScore calculateGlobalPlayerScore(String playerName, List<ScoreItem> scoreItems) {
        PlayerScore scoreResult = new PlayerScore(playerName, scoreItems);
        Integer partialSum = 0;
        for (int i = 0; i < scoreItems.size(); i++) {
            if(i < scoreItems.size() - 1) {
                ScoreTuple actualTuple = scoreResult.getScoreItems().get(i).getScoreTuple();
                ScoreTuple nextTuple = scoreResult.getScoreItems().get(i + 1).getScoreTuple();
                Integer partialTotal = partialSum + calculator.applyRule(actualTuple, nextTuple);
                scoreResult.getScoreItems().get(i).setTotal(partialTotal);
                partialSum = partialTotal;
            } else {
                ScoreTuple actualTuple = scoreResult.getScoreItems().get(i).getScoreTuple();
                scoreResult.getScoreItems().get(i).setTotal(partialSum + calculator.applyRule(actualTuple, actualTuple));
            }
        }
        return scoreResult;
    }

    @Override
    public List<PlayerScore> calculateScoreAllPlayers(List<String> rawRolls) throws BusinessException {
        List<PlayerScore> result = new ArrayList<>();
        DataProvider dp = new DataProvider();
        Map<String, List<String>> rollsData = dp.provideRollsData(rawRolls);
        for(String name : rollsData.keySet()) {
            PlayerScore aux = dp.providePlayerScore(rollsData, name);
            result.add(calculateGlobalPlayerScore(name, aux.getScoreItems()));
        }
        return result;
    }
}
