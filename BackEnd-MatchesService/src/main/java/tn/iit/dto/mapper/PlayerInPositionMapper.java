package tn.iit.dto.mapper;

import tn.iit.dto.PlayerInPositionDto;
import tn.iit.entity.PlayerInPosition;

public class PlayerInPositionMapper {
    public static PlayerInPositionDto toPlayerInPositionDto(PlayerInPosition playerInPosition) {
        return PlayerInPositionDto.builder().
                id(playerInPosition.getId()).
                position(playerInPosition.getPosition()).
                playerId(playerInPosition.getPlayer().getId()).
                build();
    }
    public static PlayerInPosition toPlayerInPosition(PlayerInPositionDto playerInPositionDto) {
        PlayerInPosition playerInPosition = new PlayerInPosition();
        playerInPosition.setId(playerInPositionDto.getId());
        playerInPosition.setPosition(playerInPositionDto.getPosition());
        return playerInPosition;
    }
}
