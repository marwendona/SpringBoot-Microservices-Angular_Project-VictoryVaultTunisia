package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "player")
@Data
public class PlayerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "nationality")
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @ToString.Exclude
    private TeamDto team;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private List<PlayerInPositionDto> playerInPositions;
}
