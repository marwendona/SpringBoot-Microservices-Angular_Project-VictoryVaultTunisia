package tn.iit.entity;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigInteger;

@Data
@Builder
@Jacksonized
public class Scorer {
    private Player playerScoring;
    private BigInteger scoringTime;
}
