package tn.iit.utils.checks;

import tn.iit.entity.Scorer;

import java.util.Optional;

public class ScorerControl extends Control<Scorer> {

    public ScorerControl(Scorer scorer) {
        this.entityToCheck = scorer;
    }

    public static ScorerControl checkScorer(Scorer scorer) {
       return new ScorerControl(scorer);
    }

    public ScorerControl checkScoringTime() {
        Optional<Integer> scoringTime = Optional.ofNullable(this.entityToCheck.getScoringTime());
        this.isValid = scoringTime.isPresent();
        return this;
    }
}
