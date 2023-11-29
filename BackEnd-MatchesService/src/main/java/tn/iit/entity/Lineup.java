package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "lineup")
@Data
public class Lineup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @ToString.Exclude
    private Team team;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineup")
    private List<PlayerInPosition> playerInPositions;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    @ToString.Exclude
    private Match match;
}
