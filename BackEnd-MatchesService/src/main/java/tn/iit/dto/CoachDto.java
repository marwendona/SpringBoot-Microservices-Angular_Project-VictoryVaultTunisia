package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "coach")
@Data
public class CoachDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
