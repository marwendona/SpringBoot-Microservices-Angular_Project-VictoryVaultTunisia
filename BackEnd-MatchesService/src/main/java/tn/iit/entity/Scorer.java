package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "scorer")
@Data
public class Scorer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scoringTime")
    private int scoringTime;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    @ToString.Exclude
    private Match match;

    @ManyToOne
    @JoinColumn(name = "player_in_position_id", nullable = false)
    @ToString.Exclude
    private PlayerInPosition playerInPosition;
}
