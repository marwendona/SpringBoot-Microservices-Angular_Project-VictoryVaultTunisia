package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "standing")
@Data
public class StandingDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rank")
    private int rank;

    @Column(name = "score")
    private int score;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "standing")
    private SeasonDto season;
}
