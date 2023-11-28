package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "season")
@Data
public class SeasonDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "season")
    private List<RoundDto> rounds;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "season")
    private StandingDto generalStanding;
}
