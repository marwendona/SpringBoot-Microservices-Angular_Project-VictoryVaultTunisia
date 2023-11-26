package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "scorer")
@Data
public class ScorerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
