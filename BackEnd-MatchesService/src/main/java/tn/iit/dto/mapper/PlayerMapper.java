package tn.iit.dto.mapper;

import tn.iit.dto.PlayerDto;
import tn.iit.dto.TeamDto;
import tn.iit.entity.Player;
import tn.iit.entity.Team;

import java.util.Optional;

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
        Long teamId = null;
        String teamName = null;
        Optional<Team> team = Optional.ofNullable(player.getTeam());
        if(team.isPresent()){
            teamId = team.get().getId();
            teamName = team.get().getName();
        }
        return PlayerDto.builder().
                id(player.getId()).
                firstName(player.getFirstName()).
                lastName(player.getLastName()).
                nationality(player.getNationality()).
                teamId(teamId).
                teamName(teamName).
                build();
    }
}
