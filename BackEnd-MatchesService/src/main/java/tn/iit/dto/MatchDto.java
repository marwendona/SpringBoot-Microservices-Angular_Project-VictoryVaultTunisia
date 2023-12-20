package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Jacksonized
public class MatchDto {
    private Long id;
    StadiumDto stadium;
    RefereeDto referee;
    Date date;
    BigInteger spectatorNumber;
    List<ScorerDto> teamHomeScorers;
    List<ScorerDto> teamAwayScorers;
    LineupDto lineupHome;
    LineupDto lineupAway;
}
