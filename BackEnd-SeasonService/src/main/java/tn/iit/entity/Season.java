package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "season")
@Data
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "season")
    private List<Round> rounds;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "season")
    private List<Standing> generalStanding;

    public Season() {
    }
}
