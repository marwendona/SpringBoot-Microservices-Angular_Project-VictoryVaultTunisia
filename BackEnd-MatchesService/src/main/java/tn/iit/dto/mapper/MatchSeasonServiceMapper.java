package tn.iit.dto.mapper;

import tn.iit.dto.MatchSeasonServiceDto;
import tn.iit.entity.Match;

public class MatchSeasonServiceMapper {

    public static MatchSeasonServiceDto toMatchSeasonServiceDto(Match match) {
        return MatchSeasonServiceDto.builder()
                .id(match.getId())
                .nameTeamHome(match.getLineupHomes().getTeam().getName())
                .nameTeamAway(match.getLineupAway().getTeam().getName())
                .scoreTeamHome((long) match.getTeamHomeScorers().size())
                .scoreTeamAway((long) match.getTeamAwayScorers().size())
                .roundId(match.getRoundId())
                .build();
    }
}
