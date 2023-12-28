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
    Long stadiumId;
    Long refereeId;
    Date date;
    BigInteger spectatorNumber;
    List<ScorerDto> teamHomeScorers;
    List<ScorerDto> teamAwayScorers;
    Long lineupHomeId;
    Long lineupAwayId;
    List<ReplacementDto> replacements;
}
