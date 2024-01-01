package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class StandingDto {
    private Long id;
    private int rank;
    private int score;
    private int teamId;
}
