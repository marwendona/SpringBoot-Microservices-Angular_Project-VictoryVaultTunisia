package tn.iit.utils.checks;

import tn.iit.entity.Season;

import java.util.Optional;

public class SeasonControl extends Control<Season> {

    public SeasonControl(Season season) {
        this.entityToCheck = season;
    }

    public static SeasonControl checkSeason(Season season) {
       return new SeasonControl(season);
    }
    public SeasonControl checkName(){
        Optional<String> name = Optional.ofNullable(this.entityToCheck.getName());
        this.isValid = name.isPresent();
        return this;
    }
}
