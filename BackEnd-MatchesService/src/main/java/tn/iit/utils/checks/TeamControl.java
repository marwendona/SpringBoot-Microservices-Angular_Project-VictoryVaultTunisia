package tn.iit.utils.checks;

import tn.iit.entity.Team;

import java.util.Optional;

public class TeamControl extends Control<Team> {

    public TeamControl(Team team) {
        this.entityToCheck = team;
    }

    public static TeamControl checkTeam(Team team) {
       return new TeamControl(team);
    }

    public TeamControl checkName(){
        Optional<String> name = Optional.ofNullable(this.entityToCheck.getName());
        this.isValid = name.isPresent();
        return this;
    }
}
