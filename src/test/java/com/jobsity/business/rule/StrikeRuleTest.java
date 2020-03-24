package com.jobsity.business.rule;

import com.jobsity.business.score.ScoreTuple;
import com.jobsity.exception.BusinessException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrikeRuleTest {

    StrikeRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new StrikeRule();
    }

    @Test
    public void apply() throws BusinessException {
        ScoreTuple tuple = new ScoreTuple(7, 2, false);
        Integer expectedResult = 19;
        Integer actualResult = rule.apply(tuple);
        assertEquals(expectedResult, actualResult);
    }
}