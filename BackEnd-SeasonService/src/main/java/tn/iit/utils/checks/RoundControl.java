package tn.iit.utils.checks;

import tn.iit.entity.Round;

import java.util.Optional;

public class RoundControl extends Control<Round> {

    public RoundControl(Round round) {
        this.entityToCheck = round;
    }

    public static RoundControl checkRound(Round round) {
       return new RoundControl(round);
    }
    public RoundControl checkName(){
        Optional<String> name = Optional.ofNullable(this.entityToCheck.getName());
        this.isValid = name.isPresent();
        return this;
    }

    public RoundControl checkRoundNumber(){
        Optional<Integer> roundNumber = Optional.ofNullable(this.entityToCheck.getRoundNumber());
        this.isValid = roundNumber.isPresent();
        return this;
    }
}
