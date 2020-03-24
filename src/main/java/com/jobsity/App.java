package com.jobsity;

import com.jobsity.business.score.PlayerScore;
import com.jobsity.business.score.TraditionalGlobalScoreCalculator;
import com.jobsity.exception.BusinessException;
import com.jobsity.io.FileInputReader;
import com.jobsity.io.InputReader;

import java.io.IOException;
import java.util.List;

public class App
{
    public static void main(String[] args) throws IOException, BusinessException {
        InputReader inputReader = new FileInputReader();
        List<String> tests = inputReader.readSource(args[0]);
        List<PlayerScore> results = new TraditionalGlobalScoreCalculator().calculateScoreAllPlayers(tests);
    }
}
