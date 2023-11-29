package tn.iit.entity;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Replacement {
    private int replacementTime;
    private Player playerIn;
    private Player playerOut;
}
