package tn.iit.entity;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class Season {
    private String name;
    private List<Round> rounds;
    private List<Standing> generalStanding ;
}
