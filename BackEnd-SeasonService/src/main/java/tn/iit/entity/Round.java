package tn.iit.entity;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Round {
    private String name;
    private int roundNumber;
}
