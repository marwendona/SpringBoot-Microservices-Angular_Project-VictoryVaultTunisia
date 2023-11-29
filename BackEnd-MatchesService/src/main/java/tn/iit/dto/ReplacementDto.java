package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ReplacementDto {
    private int replacementTime;
    private PlayerDto playerIn;
    private PlayerDto playerOut;
}
