package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "round")
@Data
public class RoundDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "roundNumber")
    private int roundNumber;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    @ToString.Exclude
    private SeasonDto season;
}
