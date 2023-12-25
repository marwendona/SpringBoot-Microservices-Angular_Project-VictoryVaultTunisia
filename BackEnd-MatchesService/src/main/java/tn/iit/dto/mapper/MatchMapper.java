package tn.iit.dto.mapper;

import tn.iit.dto.MatchDto;
import tn.iit.entity.Match;

public class MatchMapper {

    public static MatchDto toMatchDto(Match match) {
        return MatchDto.builder().
                id(match.getId()).
                date(match.getDate()).
                stadiumId(match.getStadium().getId()).
                refereeId(match.getReferee().getId()).
                lineupAwayId(match.getLineupAway().getId()).
                lineupHomeId(match.getLineupHomes().getId()).
                teamAwayScorers(match.getTeamAwayScorers().stream().map(ScorerMapper::toScorerDto).toList()).
                teamHomeScorers(match.getTeamHomeScorers().stream().map(ScorerMapper::toScorerDto).toList()).
                build();
    }
    public static Match toMatch(MatchDto dto) {
        Match match = new Match();
        match.setDate(dto.getDate());
        match.setId(dto.getId());
        return match;

    }
}
