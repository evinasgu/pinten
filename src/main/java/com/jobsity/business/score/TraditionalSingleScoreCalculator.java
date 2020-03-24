package com.jobsity.business.score;

import com.jobsity.business.rule.NormalRule;
import com.jobsity.business.rule.Rule;
import com.jobsity.business.rule.SpareRule;
import com.jobsity.business.rule.StrikeRule;

import java.util.function.Predicate;

public class TraditionalSingleScoreCalculator implements SingleScoreCalculator {

    private Predicate<ScoreTuple> strikeRulePredicate = scoreTuple -> scoreTuple.getFirstRoll() == 10;

    private Predicate<ScoreTuple> spareRulePredicate = scoreTuple -> !strikeRulePredicate.test(scoreTuple) & (scoreTuple.getFirstRoll() + scoreTuple.getSecondRoll() == 10);

    private Predicate<ScoreTuple> normalRulePredicate = scoreTuple -> scoreTuple.getFirstRoll() + scoreTuple.getSecondRoll() != 10;

    private Integer solveLastFrame(ScoreTuple tuple) {
        if(strikeRulePredicate.test(tuple)) {
            if(tuple.getSecondRoll() == 10) {
                return 30;
            } else {
                return tuple.getFirstRoll() + tuple.getSecondRoll();
            }
        } else {
            return tuple.getFirstRoll();
        }
    }

    @Override
    public Rule selectRule(ScoreTuple tuple) {
        if(normalRulePredicate.test(tuple)) {
            return new NormalRule();
        } else if(spareRulePredicate.test(tuple)) {
            return new SpareRule();
        } else {
            return new StrikeRule();
        }
    }

    @Override
    public Integer applyRule(ScoreTuple actualTuple, ScoreTuple nextTuple) {
        Rule ruleToApply = selectRule(actualTuple);
        if(!actualTuple.isLastFrame()) {
            if(ruleToApply.getClass() == NormalRule.class) {
                return ruleToApply.apply(actualTuple);
            } else if(ruleToApply.getClass() == StrikeRule.class){
                if (selectRule(nextTuple).getClass() == StrikeRule.class) {
                    return 30;
                } else {
                    return ruleToApply.apply(nextTuple);
                }
            } else {
                return ruleToApply.apply(nextTuple);
            }
        } else {
            return solveLastFrame(actualTuple);
        }
    }
}
