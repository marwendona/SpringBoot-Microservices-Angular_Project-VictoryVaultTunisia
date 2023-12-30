package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "match")
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_team_home")
    private String nameTeamHome;

    @Column(name = "name_team_away")
    private String nameTeamAway;

    @Column(name = "score_team_home")
    private Long scoreTeamHome;

    @Column(name = "score_team_away")
    private Long scoreTeamAway;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "round_id", nullable = false)
    @ToString.Exclude
    private Round round;
}
