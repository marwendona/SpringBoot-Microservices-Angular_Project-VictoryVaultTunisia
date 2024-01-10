package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "replacement")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Replacement {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "replacementTime")
    private int replacementTime;

    @ManyToOne
    @JoinColumn(name = "player_in_position_in_id", nullable = false)
    @ToString.Exclude
    private PlayerInPosition playerIn;

    @ManyToOne
    @JoinColumn(name = "player_in_position_out_id", nullable = false)
    @ToString.Exclude
    private PlayerInPosition playerOut;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    @ToString.Exclude
    private Match match;
}
