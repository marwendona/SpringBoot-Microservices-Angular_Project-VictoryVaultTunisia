package tn.iit.utils.checks;

import tn.iit.entity.Standing;

import java.util.Optional;

public class StandingControl extends Control<Standing> {

    public StandingControl(Standing standing) {
        this.entityToCheck = standing;
    }

    public static StandingControl checkStanding(Standing standing) {
       return new StandingControl(standing);
    }

    public StandingControl checkRank() {
        Optional<Integer> rank = Optional.ofNullable(this.entityToCheck.getRank());
        this.isValid = rank.isPresent();
        return this;
    }

    public StandingControl checkScore() {
        Optional<Integer> score = Optional.ofNullable(this.entityToCheck.getScore());
        this.isValid = score.isPresent();
        return this;
    }
}
