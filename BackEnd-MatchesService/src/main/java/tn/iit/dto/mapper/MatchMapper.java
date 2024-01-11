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
                lineupAwayTeamId(match.getLineupAway().getTeam().getId()).
                lineupHomeTeamId(match.getLineupHomes().getTeam().getId()).
                lineupAwayTeamName(match.getLineupAway().getTeam().getName()).
                lineupHomeTeamName(match.getLineupHomes().getTeam().getName()).
                teamAwayScorers(match.getTeamAwayScorers().stream().map(ScorerMapper::toScorerDto).toList()).
                teamHomeScorers(match.getTeamHomeScorers().stream().map(ScorerMapper::toScorerDto).toList()).
                replacements(match.getReplacements().stream().map(ReplacementMapper::toReplacementDto).toList()).
                spectatorNumber(match.getSpectatorNumber()).
                roundId(match.getRoundId()).
                stadiumName(match.getStadium().getName()).
                stadiumCapacity(match.getStadium().getCapacity()).
                refereeFirstName(match.getReferee().getFirstName()).
                refereeLastName(match.getReferee().getLastName()).
                refereeNationality(match.getReferee().getNationality()).
                build();
    }
    public static Match toMatch(MatchDto dto) {
        Match match = new Match();
        match.setDate(dto.getDate());
        match.setId(dto.getId());
        match.setSpectatorNumber(dto.getSpectatorNumber());
        match.setRoundId(dto.getRoundId());
        return match;

    }
}
