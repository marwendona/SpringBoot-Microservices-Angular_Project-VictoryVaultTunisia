package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "lineup")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lineup {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @ToString.Exclude
    private Team team;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineup")
    private List<PlayerInPosition> playerInPositions;

    @OneToOne(mappedBy = "lineupHomes")
    @ToString.Exclude
    private Match matchHomes;
    @OneToOne(mappedBy = "lineupAway")
    @ToString.Exclude
    private Match matchAway;
}
