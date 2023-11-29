package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "replacement")
@Data
public class ReplacementDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "replacementTime")
    private int replacementTime;

    @ManyToOne
    @JoinColumn(name = "player_in_position_in_id", nullable = false)
    @ToString.Exclude
    private PlayerInPositionDto playerIn;

    @ManyToOne
    @JoinColumn(name = "player_in_position_out_id", nullable = false)
    @ToString.Exclude
    private PlayerInPositionDto playerOut;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    @ToString.Exclude
    private MatchDto match;
}
