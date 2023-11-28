package tn.iit.entity;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigInteger;
import java.util.List;

@Data
@Builder
@Jacksonized
public class Standing {
    private BigInteger rank;
    private BigInteger score;
}
