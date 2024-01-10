package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigInteger;
import java.util.List;

@Data
@Builder
@Jacksonized
public class StadiumDto {
    private Long id;
    private String name;
    private BigInteger capacity;
    private String photo;
    private List<MatchDto> matches;
}
