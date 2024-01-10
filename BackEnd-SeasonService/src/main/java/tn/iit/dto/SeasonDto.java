package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class SeasonDto {
    private Long id;
    private String name;
    private List<RoundDto> rounds;
    private List<StandingDto> generalStanding ;
}
