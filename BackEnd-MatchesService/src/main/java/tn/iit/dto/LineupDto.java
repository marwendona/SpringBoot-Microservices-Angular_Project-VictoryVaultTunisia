package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "lineup")
@Data
public class LineupDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @ToString.Exclude
    private TeamDto team;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineup")
    private List<PlayerInPositionDto> playerInPositions;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    @ToString.Exclude
    private MatchDto match;
}
