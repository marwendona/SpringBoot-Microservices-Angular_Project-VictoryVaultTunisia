package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.CoachDto;
import tn.iit.dto.mapper.CoachMapper;
import tn.iit.entity.Coach;
import tn.iit.service.CoachService;


@RestController
@RequestMapping("/coach")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public ResponseEntity<Page<CoachDto>> getAllCoaches() {
        Page<CoachDto> coaches = coachService.
                getAllCoaches(PageRequest.of(0,10)).
                map(CoachMapper::toCoachDto);
        return ResponseEntity.ok(coaches);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CoachDto> getCoachById(@PathVariable Long id) {
        Coach coach = coachService.getCoachById(id);
        if (coach != null) {
            CoachDto coachDto = CoachMapper.toCoachDto(coach);
            return ResponseEntity.ok(coachDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CoachDto> createCoach(@RequestBody CoachDto coachDto) {
        Coach coach = CoachMapper.toCoach(coachDto);
        Coach createdCoach = coachService.createCoach(coach);
        CoachDto createdCoachDto = CoachMapper.toCoachDto(createdCoach);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCoachDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoachDto> updateCoach(@PathVariable Long id, @RequestBody CoachDto coachDto) {
        Coach existingCoach = coachService.getCoachById(id);
        if (existingCoach != null) {
            Coach coach = CoachMapper.toCoach(coachDto);
            Coach updatedCoach = coachService.updateCoach(coach);
            CoachDto updatedCoachDto = CoachMapper.toCoachDto(updatedCoach);
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
