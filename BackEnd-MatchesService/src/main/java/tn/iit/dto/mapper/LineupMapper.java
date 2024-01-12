package tn.iit.dto.mapper;

import java.util.Optional;

import org.aspectj.weaver.Position;

import tn.iit.dto.LineupDto;
import tn.iit.entity.Lineup;
import tn.iit.service.MatchService;
import tn.iit.service.TeamService;

public class LineupMapper {

    public static Lineup toLineup(LineupDto dto) {
        Lineup lineup = new Lineup();
        lineup.setId(dto.getId());
        return lineup;
    }
    public static LineupDto toLineupDto(Lineup lineup) {
        LineupDto var =LineupDto.builder().
                id(lineup.getId()).
                teamId(lineup.getTeam().getId()).
                // players(lineup.getPlayerInPositions().stream().map(PlayerInPositionMapper::toPlayerInPositionDto).toList()).
                // teamName(lineup.getTeam().getName()).
                build();
            if(Optional.ofNullable(lineup.getPlayerInPositions()).isPresent()){
                var.setPlayers(lineup.getPlayerInPositions().stream().map(PlayerInPositionMapper::toPlayerInPositionDto).toList());
                var.setTeamName(lineup.getTeam().getName());
            }
                return var;
    }
}
