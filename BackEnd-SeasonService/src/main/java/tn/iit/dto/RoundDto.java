package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class RoundDto {
    private Long id;
    private String name;
    private int roundNumber;
}
