package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "stadium")
@Data
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private BigInteger capacity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stadium")
    private List<Match> matchs;
}
