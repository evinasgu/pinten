package com.jobsity.business.rule;

import com.jobsity.business.score.ScoreTuple;

public class NormalRule implements Rule {
    @Override
    public Integer apply(ScoreTuple tuple) {
        return tuple.getFirstRoll() + tuple.getSecondRoll();
    }
}
