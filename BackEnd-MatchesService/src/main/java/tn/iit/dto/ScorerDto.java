package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import tn.iit.entity.Player;

@Entity
@Table(name = "scorer")
@Data
public class ScorerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scoringTime")
    private int scoringTime;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    @ToString.Exclude
    private MatchDto match;

    @ManyToOne
    @JoinColumn(name = "player_in_position_id", nullable = false)
    @ToString.Exclude
    private PlayerInPositionDto playerInPosition;
}
