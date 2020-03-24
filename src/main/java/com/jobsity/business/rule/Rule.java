package com.jobsity.business.rule;

import com.jobsity.business.score.ScoreTuple;

public interface Rule {
    Integer apply(ScoreTuple tuple);
}
