package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "coach")
@Data
public class CoachDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "nationality")
    private String nationality;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    @ToString.Exclude
    private TeamDto team;
}
