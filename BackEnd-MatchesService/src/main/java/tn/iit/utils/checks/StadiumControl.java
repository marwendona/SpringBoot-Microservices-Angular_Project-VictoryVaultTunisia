package tn.iit.utils.checks;

import tn.iit.entity.Stadium;

import java.util.Optional;
import java.math.BigInteger;

public class StadiumControl extends Control<Stadium> {

    public StadiumControl(Stadium stadium) {
        this.entityToCheck = stadium;
    }

    public static StadiumControl checkStadium(Stadium stadium) {
       return new StadiumControl(stadium);
    }

    public StadiumControl checkName(){
        Optional<String> name = Optional.ofNullable(this.entityToCheck.getName());
        this.isValid = name.isPresent();
        return this;
    }

    public StadiumControl checkCapacity(){
        Optional<BigInteger> capacity = Optional.ofNullable(this.entityToCheck.getCapacity());
        this.isValid = capacity.isPresent();
        return this;
    }
}
