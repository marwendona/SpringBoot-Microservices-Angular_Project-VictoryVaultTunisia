package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ReplacementDto {
    private Long id;

    private int replacementTime;

    private Long playerInId;
    private String playerInFirstName;
    private String playerInLastName;
    private String playerInNationality;

    private Long playerOutId;
    private String playerOutFirstName;
    private String playerOutLastName;
    private String playerOutNationality;

    private Long matchId;
}
