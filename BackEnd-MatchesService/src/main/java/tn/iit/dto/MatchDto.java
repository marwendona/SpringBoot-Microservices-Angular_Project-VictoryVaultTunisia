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

    private Long stadiumId;
    private String stadiumName;
    private BigInteger stadiumCapacity;

    private Long refereeId;
    private String refereeFirstName;
    private String refereeLastName;
    private String refereeNationality;

    private Date date;
    private BigInteger spectatorNumber;

    private List<ScorerDto> teamHomeScorers;
    private List<ScorerDto> teamAwayScorers;

    private Long lineupHomeId;
    private Long lineupHomeTeamId;
    private String lineupHomeTeamName;

    private Long lineupAwayId;
    private Long lineupAwayTeamId;
    private String lineupAwayTeamName;

    private List<ReplacementDto> replacements;

    private Long roundId;
}
