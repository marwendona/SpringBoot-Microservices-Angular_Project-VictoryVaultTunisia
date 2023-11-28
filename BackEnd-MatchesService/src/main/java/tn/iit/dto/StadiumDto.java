package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "stadium")
@Data
public class StadiumDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private BigInteger capacity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stadium")
    private List<MatchDto> matchs;
}
