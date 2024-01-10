package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "referee")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Referee {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "nationality")
    private String nationality;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referee")
    private List<Match> matchs;
}
