package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

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

    public Round() {
    }
}
