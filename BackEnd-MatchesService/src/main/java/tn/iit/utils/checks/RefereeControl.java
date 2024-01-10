package tn.iit.utils.checks;

import tn.iit.entity.Referee;

import java.util.Optional;

public class RefereeControl extends Control<Referee> {

    public RefereeControl(Referee referee) {
        this.entityToCheck = referee;
    }

    public static RefereeControl checkReferee(Referee referee) {
       return new RefereeControl(referee);
    }
    public RefereeControl checkNationality() {
        Optional<String> nationality = Optional.ofNullable(this.entityToCheck.getNationality());
        this.isValid = nationality.isPresent();
        return this;
    }
    public RefereeControl checkFirstName(){
        Optional<String> firstName = Optional.ofNullable(this.entityToCheck.getFirstName());
        this.isValid = firstName.isPresent();
        return this;
    }

    public RefereeControl checkLastName(){
        Optional<String> lastName = Optional.ofNullable(this.entityToCheck.getLastName());
        this.isValid = lastName.isPresent();
        return this;
    }
}
