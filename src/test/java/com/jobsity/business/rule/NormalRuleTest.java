package com.jobsity.business.rule;

import com.jobsity.business.score.ScoreTuple;
import com.jobsity.exception.BusinessException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NormalRuleTest {

    NormalRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new NormalRule();
    }

    @Test
    public void apply() throws BusinessException {
        ScoreTuple inputTuple = new ScoreTuple(7, 2, false);
        Integer expectedResult = 9;
        Integer actualResult = rule.apply(inputTuple);
        assertEquals(expectedResult, actualResult);
    }
}