package com.jobsity.business.score;

import com.jobsity.business.rule.Rule;

public interface SingleScoreCalculator {
    Rule selectRule(ScoreTuple tuple);
    Integer applyRule(ScoreTuple actualTuple, ScoreTuple nextTuple);
}
