package tn.iit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "coach")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Coach {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "nationality")
    private String nationality;

    @OneToOne(mappedBy = "coach")
    private Team team;
}
