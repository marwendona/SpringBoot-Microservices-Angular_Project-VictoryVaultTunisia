package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "stadium")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Stadium {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private BigInteger capacity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stadium")
    private List<Match> matches;
}
