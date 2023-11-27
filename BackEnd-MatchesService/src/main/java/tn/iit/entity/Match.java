package tn.iit.entity;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Jacksonized
public class Match {
    Stadium stadium;
    Referee referee;
    Date date;
    BigInteger spectatorNumber;
    List<Scorer> teamHomeScorers;
    List<Scorer> teamAwayScorers;
    Lineup lineupHome;
    Lineup lineupAway;
}
