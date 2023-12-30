package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "standing")
@Data
public class Standing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ranking") //rank is a reserved word in SQL
    private int rank;

    @Column(name = "score")
    private int score;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "season_id", nullable = false)
    @ToString.Exclude
    private Season season;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team_id", nullable = false)
    @ToString.Exclude
    private Team team;

    public Standing() {
    }
}
