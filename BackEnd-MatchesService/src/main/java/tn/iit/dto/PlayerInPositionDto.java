package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class PlayerInPositionDto {
    private Long id;
    private String position;

    private Long playerId;
    private String playerFirstName;
    private String playerLastName;
    private String playerNationality;

    private Long lineupId;
}
