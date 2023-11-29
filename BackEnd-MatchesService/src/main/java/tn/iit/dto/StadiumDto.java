package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigInteger;

@Data
@Builder
@Jacksonized
public class StadiumDto {
    private String name;
    private BigInteger capacity;
}
