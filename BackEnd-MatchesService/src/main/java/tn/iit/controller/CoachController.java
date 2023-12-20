package tn.iit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.CoachDto;
import tn.iit.entity.Coach;
import tn.iit.service.CoachService;

@RestController
@RequestMapping("/coaches")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachDto> getCoachById(@PathVariable Long id) {
        Coach coach = coachService.getCoachById(id);
        if (coach != null) {
            CoachDto coachDto = convertToDto(coach);
            return ResponseEntity.ok(coachDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CoachDto> createCoach(@RequestBody CoachDto coachDto) {
        Coach coach = convertToEntity(coachDto);
        Coach createdCoach = coachService.createCoach(coach);
        CoachDto createdCoachDto = convertToDto(createdCoach);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCoachDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoachDto> updateCoach(@PathVariable Long id, @RequestBody CoachDto coachDto) {
        Coach existingCoach = coachService.getCoachById(id);
        if (existingCoach != null) {
            Coach coach = convertToEntity(coachDto);
            coach.setId(id);
            Coach updatedCoach = coachService.updateCoach(coach);
            CoachDto updatedCoachDto = convertToDto(updatedCoach);
            return ResponseEntity.ok(updatedCoachDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        Coach existingCoach = coachService.getCoachById(id);
        if (existingCoach != null) {
            coachService.deleteCoach(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}