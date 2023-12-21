package tn.iit.dto.mapper;

import tn.iit.dto.LineupDto;
import tn.iit.entity.Lineup;
import tn.iit.service.MatchService;
import tn.iit.service.TeamService;

public class LineupMapper {
    private static TeamService teamService;
    private static MatchService matchService;

    public LineupMapper() {
    }

    public static Lineup  toLineup(LineupDto dto) {
        Lineup lineup = new Lineup();
        lineup.setId(dto.getId());
        //lineup.setTeam(getTeamId()));
        //lineup.setMatch(dto.getMatchId());
        lineup.setPlayerInPositions(dto.getPlayers().stream().map(PlayerInPositionMapper::toPlayerInPosition).toList());
        return lineup;
    }
    public static LineupDto toLineupDto(Lineup lineup) {
        return LineupDto.builder().
                id(lineup.getId()).
                teamId(lineup.getTeam().getId()).
                matchId(lineup.getMatch().getId()).
                players(lineup.getPlayerInPositions().stream().map(PlayerInPositionMapper::toPlayerInPositionDto).toList()).
                build();
    }
}
