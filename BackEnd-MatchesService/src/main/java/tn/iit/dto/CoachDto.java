package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class CoachDto {
    private String firstName;
    private String lastName;
    private String nationality;
}
