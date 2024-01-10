package tn.iit.utils.checks;

import tn.iit.entity.Player;

import java.util.Optional;

public class PlayerControl extends Control<Player> {

    public PlayerControl(Player player) {
        this.entityToCheck = player;
    }

    public static PlayerControl checkPlayer(Player player) {
       return new PlayerControl(player);
    }

    public PlayerControl checkFirstName(){
        Optional<String> firstName = Optional.ofNullable(this.entityToCheck.getFirstName());
        this.isValid = firstName.isPresent();
        return this;
    }

    public PlayerControl checkLastName(){
        Optional<String> lastName = Optional.ofNullable(this.entityToCheck.getLastName());
        this.isValid = lastName.isPresent();
        return this;
    }

    public PlayerControl checkNationality(){
        Optional<String> nationality = Optional.ofNullable(this.entityToCheck.getNationality());
        this.isValid = nationality.isPresent();
        return this;
    }
}
