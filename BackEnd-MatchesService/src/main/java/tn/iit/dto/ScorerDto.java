package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ScorerDto {
    private Long id;

    private int scoringTime;

    private Long playerInPositionId;
    private String playerInPositionFirstName;
    private String playerInPositionLastName;
    private String playerInPositionNationality;

    private Long matchId;
}
