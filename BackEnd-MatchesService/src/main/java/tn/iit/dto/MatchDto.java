package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "football_match")
@Data
public class MatchDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stadium_id", nullable = false)
    @ToString.Exclude
    private StadiumDto stadium;

    @ManyToOne
    @JoinColumn(name = "referee_id", nullable = false)
    @ToString.Exclude
    private RefereeDto referee;

    @CreationTimestamp
    @Column(name = "date")
    Date date;

    @Column(name = "spectatorNumber")
    BigInteger spectatorNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
    private List<ScorerDto> teamHomeScorers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
    private List<ScorerDto> teamAwayScorers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
    private List<LineupDto> lineupHomes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
    private List<LineupDto> lineupAways;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
    private List<ReplacementDto> replacements;
}
