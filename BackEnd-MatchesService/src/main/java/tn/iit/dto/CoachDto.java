package tn.iit.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class CoachDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String nationality;
}
