package tn.iit.dto.mapper;

import com.google.common.base.Optional;

import tn.iit.dto.MatchSeasonServiceDto;
import tn.iit.entity.Match;

public class MatchSeasonServiceMapper {

    public static MatchSeasonServiceDto toMatchSeasonServiceDto(Match match) {
        MatchSeasonServiceDto dto = MatchSeasonServiceDto.builder()
                .id(match.getId())
                .roundId(match.getRoundId())
                .build();

                if(Optional.fromNullable(match.getLineupAway()).isPresent()&&Optional.fromNullable(match.getLineupHomes()).isPresent()) {
                    dto.setNameTeamHome(match.getLineupHomes().getTeam().getName());
                    dto.setNameTeamAway(match.getLineupAway().getTeam().getName());
                    dto.setScoreTeamHome((long) match.getTeamHomeScorers().size());
                    dto.setScoreTeamAway((long) match.getTeamAwayScorers().size());
                }
                return dto;
    }
}
