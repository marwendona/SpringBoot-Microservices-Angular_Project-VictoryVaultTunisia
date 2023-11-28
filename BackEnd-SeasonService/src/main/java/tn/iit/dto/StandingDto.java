package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "standing")
@Data
public class StandingDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ranking") //rank is a reserved word in SQL
    private int rank;

    @Column(name = "score")
    private int score;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "season_id")
    @ToString.Exclude
    private SeasonDto season;
}
