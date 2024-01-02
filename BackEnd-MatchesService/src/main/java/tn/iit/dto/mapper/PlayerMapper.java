package tn.iit.dto.mapper;

import tn.iit.dto.PlayerDto;
import tn.iit.entity.Player;

public class PlayerMapper {
    public static Player toPlayer(PlayerDto dto) {
        Player player = new Player();
        player.setId(dto.getId());
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setNationality(dto.getNationality());
        return player;
    }
    public static PlayerDto toPlayerDto(Player player) {
        return PlayerDto.builder().
                id(player.getId()).
                firstName(player.getFirstName()).
                lastName(player.getLastName()).
                nationality(player.getNationality()).
                teamId(player.getTeam().getId()).
                teamName(player.getTeam().getName()).
                build();
    }
}
