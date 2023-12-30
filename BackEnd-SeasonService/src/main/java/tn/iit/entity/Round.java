package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "round")
@Data
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "roundNumber")
    private int roundNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "season_id", nullable = false)
    @ToString.Exclude
    private Season season;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "round")
    @ToString.Exclude
    private List<Match> matches;

    public Round() {
    }
}
