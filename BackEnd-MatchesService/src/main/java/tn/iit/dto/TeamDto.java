package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class TeamDto {
    private Long id;
    private String name;
    private List<LineupDto> lineups;
    private List<PlayerDto> players;
    private Long coachId;

}
