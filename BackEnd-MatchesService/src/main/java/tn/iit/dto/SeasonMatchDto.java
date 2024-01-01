package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class SeasonMatchDto {
    private Long id;
    private String nameTeamHome;
    private String nameTeamAway;
    private Long scoreTeamHome;
    private Long scoreTeamAway;
    private Long roundId;
}
