package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.StandingDto;
import tn.iit.dto.mapper.StandingMapper;
import tn.iit.entity.Standing;
import tn.iit.entity.Season;
import tn.iit.service.StandingService;
import tn.iit.service.SeasonService;


@RestController
@RequestMapping("/standings")
public class StandingController {

    private final StandingService standingService;
    private final SeasonService seasonService;

    public StandingController(StandingService standingService, SeasonService seasonService) {
        this.standingService = standingService;
        this.seasonService = seasonService;
    }

    @GetMapping
    public ResponseEntity<Page<StandingDto>> getAllStandings() {
        Page<StandingDto> standings = standingService.
                getAllStandings(PageRequest.of(0,10)).
                map(StandingMapper::toStandingDto);
        return ResponseEntity.ok(standings);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandingDto> getStandingById(@PathVariable Long id) {
        Standing standing = standingService.getStandingById(id);
        if (standing != null) {
            StandingDto standingDto = StandingMapper.toStandingDto(standing);
            return ResponseEntity.ok(standingDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{seasonId}")
    public ResponseEntity<StandingDto> createStanding(@RequestBody StandingDto standingDto, @PathVariable Long seasonId) {
        Standing standing = StandingMapper.toStanding(standingDto);
        Standing createdStanding = standingService.createStanding(standing, seasonId);
        StandingDto createdStandingDto = StandingMapper.toStandingDto(createdStanding);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStandingDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandingDto> updateStanding(@PathVariable Long id, @RequestBody StandingDto standingDto) {
        Standing existingStanding = standingService.getStandingById(id);
        if (existingStanding != null) {
            Standing standing = StandingMapper.toStanding(standingDto);
            standing.setId(id);

            Season existingSeason = existingStanding.getSeason();
            standing.setSeason(existingSeason);

            Standing updatedStanding = standingService.updateStanding(standing);
            StandingDto updatedStandingDto = StandingMapper.toStandingDto(updatedStanding);
            return ResponseEntity.ok(updatedStandingDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStanding(@PathVariable Long id) {
        Standing existingStanding = standingService.getStandingById(id);
        if (existingStanding != null) {
            standingService.deleteStanding(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
