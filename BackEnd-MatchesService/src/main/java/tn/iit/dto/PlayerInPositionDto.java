package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "player_in_position")
@Data
public class PlayerInPositionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    @ToString.Exclude
    private PlayerDto player;

    @ManyToOne
    @JoinColumn(name = "lineup_id", nullable = false)
    @ToString.Exclude
    private LineupDto lineup;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerInPosition")
    private List<ScorerDto> scorers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerIn")
    private List<ReplacementDto> playerIns;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerOut")
    private List<ReplacementDto> playerOuts;
}
