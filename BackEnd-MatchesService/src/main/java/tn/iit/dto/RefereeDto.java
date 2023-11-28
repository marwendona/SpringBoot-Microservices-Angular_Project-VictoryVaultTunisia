package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "referee")
@Data
public class RefereeDto {
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
    private List<MatchDto> matchs;
}
