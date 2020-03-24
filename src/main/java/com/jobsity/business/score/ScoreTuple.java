package com.jobsity.business.score;

import com.jobsity.exception.BusinessException;

public class ScoreTuple {
    private Integer firstRoll;
    private Integer secondRoll;
    private Boolean isLastFrame;

    public ScoreTuple(Integer firstRoll, Integer secondRoll, Boolean isLastFrame) throws BusinessException {
        if(firstRoll >= 0 && secondRoll >= 0 && (firstRoll + secondRoll <= 10 || isLastFrame)) {
            this.firstRoll = firstRoll;
            this.secondRoll = secondRoll;
            this.isLastFrame = isLastFrame;
        } else {
            throw new BusinessException("Invalid numeric values provided");
        }
    }

    public Integer getFirstRoll() {
        return firstRoll;
    }

    public Integer getSecondRoll() {
        return secondRoll;
    }

    public Boolean isLastFrame() {
        return isLastFrame;
    }
}
