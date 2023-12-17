package tn.iit.utils.checks;

import tn.iit.entity.Coach;

import java.util.Optional;

public class CoachControl extends Control<Coach> {

    public CoachControl(Coach coach) {
        this.entityToCheck = coach;
    }

    public static CoachControl checkCoach(Coach coach) {
       return new CoachControl(coach);
    }
    public CoachControl checkNationality() {
        Optional<String> nationality = Optional.ofNullable(this.entityToCheck.getNationality());
        this.isValid = nationality.isPresent();
        return this;
    }
    public CoachControl checkFirstName(){
        Optional<String> firstName = Optional.ofNullable(this.entityToCheck.getFirstName());
        this.isValid = firstName.isPresent();
        return this;
    }

    public CoachControl checkLastName(){
        Optional<String> lastName = Optional.ofNullable(this.entityToCheck.getLastName());
        this.isValid = lastName.isPresent();
        return this;
    }


}
