package tn.iit.dto.mapper;


import java.util.Optional;

import tn.iit.dto.MatchDto;
import tn.iit.entity.Lineup;
import tn.iit.entity.Match;

public class MatchMapper {
     
    public static MatchDto toMatchDto(Match match) {
        Lineup lineupAway=new Lineup();
        Lineup lineupHome=new Lineup();
        Optional<Lineup> optionalLineupAway= Optional.ofNullable(lineupAway);
        Optional<Lineup> optionalLineupHome = Optional.ofNullable(lineupHome);

        if (optionalLineupAway.isPresent()) {
            lineupAway = optionalLineupAway.get();
        }
        if (optionalLineupHome.isPresent()) {
            lineupHome = optionalLineupHome.get();
        }
        return MatchDto.builder().
                id(match.getId()).
                date(match.getDate()).
                stadiumId(match.getStadium().getId()).
                refereeId(match.getReferee().getId()).
                lineupAwayId(lineupAway.getId()).
                lineupHomeId(lineupHome.getId()).
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
