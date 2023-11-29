package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "player")
@Data
public class Player {
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
    private Team team;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private List<PlayerInPosition> playerInPositions;
}
