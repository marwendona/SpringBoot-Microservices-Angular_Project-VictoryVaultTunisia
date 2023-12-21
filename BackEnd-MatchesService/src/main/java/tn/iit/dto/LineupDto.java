package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class LineupDto {
    private Long id;
    private Long teamId;
    private Long matchId;
    private List<PlayerDto> players;
}
