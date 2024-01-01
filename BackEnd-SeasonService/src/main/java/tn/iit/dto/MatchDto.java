package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class MatchDto {

    private Long id;
    private String nameTeamHome;
    private String nameTeamAway;
    private Long scoreTeamHome;
    private Long scoreTeamAway;
    private Long roundId;
}
