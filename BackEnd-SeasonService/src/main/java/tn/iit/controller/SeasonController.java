package tn.iit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.SeasonDto;
import tn.iit.dto.mapper.SeasonMapper;
import tn.iit.entity.Season;
import tn.iit.proxy.MatchController;
import tn.iit.service.SeasonService;


@RestController
@RequestMapping("/seasons")
public class SeasonController {

    private final SeasonService seasonService;
    private final MatchController matchController;

    public SeasonController(SeasonService seasonService,
            MatchController matchController) {
        this.matchController = matchController;
        this.seasonService = seasonService;
    }

    @GetMapping
    public ResponseEntity<List<SeasonDto>> getAllSeasons(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1000") int size) {
        Page<SeasonDto> seasons = seasonService.
                getAllSeasons(PageRequest.of(page, size)).
                map(SeasonMapper::toSeasonDto);
        seasons.getContent().forEach(season->{
            if(Optional.ofNullable(season.getGeneralStanding()).isPresent())
                {season.getGeneralStanding().forEach(standing->
                    standing.setTeamName(matchController.getTeamByID(standing.getTeamId()).getBody().getName()

                ));}
        });
        
        return ResponseEntity.ok(seasons.getContent());
    }
    @GetMapping("/{id}")
    public ResponseEntity<SeasonDto> getSeasonById(@PathVariable Long id) {
        Season season = seasonService.getSeasonById(id);
        if (season != null) {
            SeasonDto seasonDto = SeasonMapper.toSeasonDto(season);
            return ResponseEntity.ok(seasonDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SeasonDto> createSeason(@RequestBody SeasonDto seasonDto) {
        Season season = SeasonMapper.toSeason(seasonDto);
        Season createdSeason = seasonService.createSeason(season);
        SeasonDto createdSeasonDto = SeasonMapper.toSeasonDto(createdSeason);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeasonDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeasonDto> updateSeason(@PathVariable Long id, @RequestBody SeasonDto seasonDto) {
        Season existingSeason = seasonService.getSeasonById(id);
        if (existingSeason != null) {
            Season season = SeasonMapper.toSeason(seasonDto);
            season.setId(id);
            Season updatedSeason = seasonService.updateSeason(season);
            SeasonDto updatedSeasonDto = SeasonMapper.toSeasonDto(updatedSeason);
            return ResponseEntity.ok(updatedSeasonDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeason(@PathVariable Long id) {
        Season existingSeason = seasonService.getSeasonById(id);
        if (existingSeason != null) {
            seasonService.deleteSeason(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
