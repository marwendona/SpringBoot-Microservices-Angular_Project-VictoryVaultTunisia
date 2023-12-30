package tn.iit.dto.mapper;

import tn.iit.dto.MatchDto;
import tn.iit.entity.Match;

public class MatchMapper {
    public static MatchDto toMatchDto(Match match) {
        return MatchDto.builder()
                .id(match.getId())
                .nameTeamHome(match.getNameTeamHome())
                .nameTeamAway(match.getNameTeamAway())
                .scoreTeamHome(match.getScoreTeamHome())
                .scoreTeamAway(match.getScoreTeamAway())
                .roundId(match.getRound().getId())
                .build();
    }
    public static Match toMatch(MatchDto matchDto) {
        Match match = new Match();
        match.setId(matchDto.getId());
        match.setNameTeamHome(matchDto.getNameTeamHome());
        match.setNameTeamAway(matchDto.getNameTeamAway());
        match.setScoreTeamHome(matchDto.getScoreTeamHome());
        match.setScoreTeamAway(matchDto.getScoreTeamAway());
        return match;
    }
}
