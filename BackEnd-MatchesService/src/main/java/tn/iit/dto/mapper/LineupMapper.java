package tn.iit.dto.mapper;

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
        return LineupDto.builder().
                id(lineup.getId()).
                teamId(lineup.getTeam().getId()).
                players(lineup.getPlayerInPositions().stream().map(PlayerInPositionMapper::toPlayerInPositionDto).toList()).
                build();
    }
}
