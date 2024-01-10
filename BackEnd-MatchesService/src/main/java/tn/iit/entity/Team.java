package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "team")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Team {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Lineup> lineups;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Player> players;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    @ToString.Exclude
    private Coach coach;
}
