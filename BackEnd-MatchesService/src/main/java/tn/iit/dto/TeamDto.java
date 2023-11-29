package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class TeamDto {
    private String name;
    private List<PlayerDto> players;
    private CoachDto coach;
}
