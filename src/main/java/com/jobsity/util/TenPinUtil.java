package com.jobsity.util;

import com.jobsity.exception.FormatException;

public class TenPinUtil {
    public static Integer transformToInteger(String input) throws FormatException {
        if(input != null && input.equals("F")) {
            return 0;
        } else {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException err) {
                throw new FormatException("Integer character expected");
            } catch (NullPointerException err) {
                throw new FormatException("null values are not supported");
            }
        }
    }
}
