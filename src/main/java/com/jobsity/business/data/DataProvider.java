package com.jobsity.business.data;

import com.jobsity.business.score.PlayerScore;
import com.jobsity.business.score.ScoreItem;
import com.jobsity.business.score.ScoreTuple;
import com.jobsity.exception.BusinessException;

import java.util.*;

public class DataProvider {
    public Map<String, List<String>> provideRollsData(List<String> inputData) {
        Map<String, List<String>> rollsData = new HashMap<>();
        //TODO Validate aux
        inputData.stream().map(item -> item.split(" ")).forEach(aux -> {
            if (rollsData.containsKey(aux[0])) {
                rollsData.get(aux[0]).add(aux[1]);
            } else {
                List<String> auxList = new ArrayList<>();
                auxList.add(aux[1]);
                rollsData.put(aux[0], auxList);
            }
        });
        return rollsData;
    }

    public PlayerScore providePlayerScore(Map<String, List<String>> inputData, String name) throws BusinessException {
        List<String> rollList = inputData.get(name);
        LinkedList<ScoreItem> scoreItems = new LinkedList<>();
        Integer pairCount = 0;
        Integer generalCount = 0;
        for(int i=0; i < rollList.size() && generalCount < 10; i=i+1) {
            if(rollList.get(i).equals("10") && pairCount == 0) {
                if(generalCount != 9) {
                    ScoreTuple scoreTuple = new ScoreTuple(10, 0, false);
                    scoreItems.add(new ScoreItem(scoreTuple));
                    pairCount++;
                } else {
                    if(rollList.get(i+1).equals("10")) {
                        ScoreTuple scoreTuple = new ScoreTuple(10, 10, true);
                        scoreItems.add(new ScoreItem(scoreTuple));
                    } else {
                        Integer firstRoll = rollList.get(i+1).equals("F") ? 0 : Integer.parseInt(rollList.get(i+1));
                        Integer secondRoll = rollList.get(i+2).equals("F") ? 0 : Integer.parseInt(rollList.get(i+2));
                        ScoreTuple scoreTuple = new ScoreTuple(10 + firstRoll, secondRoll, true);
                        scoreItems.add(new ScoreItem(scoreTuple));
                    }
                    i++;
                }
            } else {
                if(generalCount != 9) {
                    if(pairCount == 0) {
                        Integer firstRoll = rollList.get(i).equals("F") ? 0 : Integer.parseInt(rollList.get(i));
                        Integer secondRoll = rollList.get(i+1).equals("F") ? 0 : Integer.parseInt(rollList.get(i+1));
                        ScoreTuple scoreTuple = new ScoreTuple(firstRoll, secondRoll, false);
                        scoreItems.add(new ScoreItem(scoreTuple));
                        pairCount++;
                        i++;
                    }
                } else {
                    Integer firstRoll = Integer.parseInt(rollList.get(i));
                    ScoreTuple scoreTuple = new ScoreTuple(firstRoll, 0, true);
                    scoreItems.add(new ScoreItem(scoreTuple));
                }
            }
            generalCount++;
            pairCount = 0;
            }
        return new PlayerScore(name, scoreItems);
    }


}
