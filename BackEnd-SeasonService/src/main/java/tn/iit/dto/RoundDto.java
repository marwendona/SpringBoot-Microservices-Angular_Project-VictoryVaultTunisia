package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class RoundDto {
    private Long id;
    private String name;
    private int roundNumber;
    private List<MatchDto> matches;
    private int seasonId;
}
