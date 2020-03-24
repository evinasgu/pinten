package com.jobsity.util;

import com.jobsity.exception.FormatException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TenPinUtilTest {

    @Test
    public void transformToIntegerValidInput() throws FormatException {
        String letterInput = "F";
        String numericInput = "1";
        Integer expectedResult = 0;
        Integer actualResult = TenPinUtil.transformToInteger(letterInput);
        assertEquals(expectedResult, actualResult);
        expectedResult = 1;
        actualResult = TenPinUtil.transformToInteger(numericInput);
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = FormatException.class)
    public void transformIntegerNullInput() throws FormatException {
        TenPinUtil.transformToInteger(null);
    }

    @Test(expected = FormatException.class)
    public void transformIntegerNonValidInput() throws FormatException {
        String invalidInput = "a977";
        TenPinUtil.transformToInteger(invalidInput);
    }

    @Test
    public void transformInputFrameToScoreTuple() {
    }
}