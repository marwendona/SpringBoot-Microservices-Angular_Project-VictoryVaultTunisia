package tn.iit.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "season")
@Data
public class SeasonDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
