package tn.iit.dto.mapper;

import tn.iit.dto.ScorerDto;
import tn.iit.entity.Scorer;

public class ScorerMapper {
    public static ScorerDto toScorerDto(Scorer scorer) {
        return ScorerDto.builder().
                id(scorer.getId()).
                playerScoringId(scorer.getPlayerInPosition().getId()).
                scoringTime(scorer.getScoringTime()).
                build();
    }
    public static Scorer toScorer(ScorerDto scorerDto) {
        Scorer scorer = new Scorer();
        scorer.setId(scorerDto.getId());
        scorer.setScoringTime(scorerDto.getScoringTime());
        return scorer;
    }
}
