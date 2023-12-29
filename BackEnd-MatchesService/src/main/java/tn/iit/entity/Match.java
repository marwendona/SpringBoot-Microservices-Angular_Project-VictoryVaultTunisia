package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "football_match")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Match {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stadium_id", nullable = false)
    @ToString.Exclude
    private Stadium stadium;

    @ManyToOne
    @JoinColumn(name = "referee_id", nullable = false)
    @ToString.Exclude
    private Referee referee;

    @CreationTimestamp
    @Column(name = "date")
    Date date;

    @Column(name = "spectatorNumber")
    BigInteger spectatorNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
    private List<Scorer> teamHomeScorers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
    private List<Scorer> teamAwayScorers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lineup_homes_id", nullable = false)
    private Lineup lineupHomes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lineup_away_id", nullable = false)
    private Lineup lineupAway;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
    private List<Replacement> replacements;
}
