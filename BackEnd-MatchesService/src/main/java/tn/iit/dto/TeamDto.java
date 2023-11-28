package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "team")
@Data
public class TeamDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<LineupDto> lineups;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<PlayerDto> players;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "team")
    private CoachDto coach;
}
