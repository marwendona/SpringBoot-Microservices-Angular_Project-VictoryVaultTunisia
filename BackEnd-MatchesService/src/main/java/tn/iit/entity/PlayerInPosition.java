package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "player_in_position")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PlayerInPosition {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    @ToString.Exclude
    private Player player;

    @ManyToOne
    @JoinColumn(name = "lineup_id", nullable = false)
    @ToString.Exclude
    private Lineup lineup;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerInPosition")
    private List<Scorer> scorers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerIn")
    private List<Replacement> playerIns;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerOut")
    private List<Replacement> playerOuts;
}
