package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ScorerDto {
    private PlayerDto playerScoring;
    private int scoringTime;
}
