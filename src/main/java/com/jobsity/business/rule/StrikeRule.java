package com.jobsity.business.rule;

import com.jobsity.business.score.ScoreTuple;

public class StrikeRule implements Rule {
    private static final Integer POINTS_TO_ADD = 10;

    @Override
    public Integer apply(ScoreTuple tuple) {
        return POINTS_TO_ADD + tuple.getFirstRoll() + tuple.getSecondRoll();
    }
}
