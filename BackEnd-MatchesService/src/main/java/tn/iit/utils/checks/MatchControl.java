package tn.iit.utils.checks;

import tn.iit.entity.Match;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

public class MatchControl extends Control<Match> {

    public MatchControl(Match match) {
        this.entityToCheck = match;
    }

    public static MatchControl checkMatch(Match match) {
       return new MatchControl(match);
    }

    public MatchControl checkDate() {
        Optional<Date> date = Optional.ofNullable(this.entityToCheck.getDate());
        this.isValid = date.isPresent();
        return this;
    }

    public MatchControl checkSpectatorNumber(){
        Optional<BigInteger> spectatorNumber = Optional.ofNullable(this.entityToCheck.getSpectatorNumber());
        this.isValid = spectatorNumber.isPresent();
        return this;
    }
}
