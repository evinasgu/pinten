package com.jobsity.business.score;

import com.jobsity.business.rule.NormalRule;
import com.jobsity.business.rule.SpareRule;
import com.jobsity.business.rule.StrikeRule;
import com.jobsity.exception.BusinessException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TraditionalSingleScoreCalculatorTest {

    TraditionalSingleScoreCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new TraditionalSingleScoreCalculator();
    }

    @Test
    public void selectRuleNormalRule() throws BusinessException {
        ScoreTuple inputTuple = new ScoreTuple(7, 2, false);
        Class expectedResult = NormalRule.class;
        Class actualResult = calculator.selectRule(inputTuple).getClass();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void selectRuleSpareRule() throws BusinessException {
        ScoreTuple inputTuple = new ScoreTuple(7, 3, false);
        Class expectedResult = SpareRule.class;
        Class actualResult = calculator.selectRule(inputTuple).getClass();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void selectRuleStrikeRule() throws BusinessException {
        ScoreTuple inputTuple = new ScoreTuple(10, 0, false);
        Class expectedResult = StrikeRule.class;
        Class actualResult = calculator.selectRule(inputTuple).getClass();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void applyMaxStrikeRule() throws BusinessException {
        ScoreTuple inputActualTuple = new ScoreTuple(10, 0, false);
        ScoreTuple inputNextTuple = new ScoreTuple(10, 0, false);
        Integer expectedResult = 30;
        Integer actualResult = calculator.applyRule(inputActualTuple, inputNextTuple);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void applyStrikeRule() throws BusinessException {
        ScoreTuple inputActualTuple = new ScoreTuple(10, 0, false);
        ScoreTuple inputNextTuple = new ScoreTuple(7, 3, false);
        Integer expectedResult = 20;
        Integer actualResult = calculator.applyRule(inputActualTuple, inputNextTuple);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void applyNormalRule() throws BusinessException {
        ScoreTuple inputActualTuple = new ScoreTuple(5, 3, false);
        ScoreTuple inputNextTuple = new ScoreTuple(7, 3, false);
        Integer expectedResult = 8;
        Integer actualResult = calculator.applyRule(inputActualTuple, inputNextTuple);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void applySpareRule() throws BusinessException {
        ScoreTuple inputActualTuple = new ScoreTuple(7, 3, false);
        ScoreTuple inputNextTuple = new ScoreTuple(7, 3, false);
        Integer expectedResult = 17;
        Integer actualResult = calculator.applyRule(inputActualTuple, inputNextTuple);
        assertEquals(expectedResult, actualResult);
    }
}