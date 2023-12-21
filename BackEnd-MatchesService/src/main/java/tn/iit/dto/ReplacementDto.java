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
    private Long playerOutId;
}
