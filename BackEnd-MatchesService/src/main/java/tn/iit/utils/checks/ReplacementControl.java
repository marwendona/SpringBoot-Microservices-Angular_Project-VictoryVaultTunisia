package tn.iit.utils.checks;

import tn.iit.entity.Replacement;

import java.util.Optional;

public class ReplacementControl extends Control<Replacement> {

    public ReplacementControl(Replacement replacement) {
        this.entityToCheck = replacement;
    }

    public static ReplacementControl checkReplacement(Replacement replacement) {
       return new ReplacementControl(replacement);
    }

    public ReplacementControl checkReplacementTime() {
        Optional<Integer> replacementTime = Optional.ofNullable(this.entityToCheck.getReplacementTime());
        this.isValid = replacementTime.isPresent();
        return this;
    }
}
