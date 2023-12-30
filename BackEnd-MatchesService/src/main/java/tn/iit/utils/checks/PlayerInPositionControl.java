package tn.iit.utils.checks;

import tn.iit.entity.PlayerInPosition;

import java.util.Optional;

public class PlayerInPositionControl extends Control<PlayerInPosition> {

    public PlayerInPositionControl(PlayerInPosition playerInPosition) {
        this.entityToCheck = playerInPosition;
    }

    public static PlayerInPositionControl checkPlayerInPosition(PlayerInPosition playerInPosition) {
        return new PlayerInPositionControl(playerInPosition);
    }

    public PlayerInPositionControl checkPosition() {
        Optional<String> position = Optional.ofNullable(this.entityToCheck.getPosition());
        this.isValid = position.isPresent();
        return this;
    }
}
