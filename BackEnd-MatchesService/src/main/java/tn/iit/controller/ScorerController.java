package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.ScorerDto;
import tn.iit.dto.mapper.ScorerMapper;
import tn.iit.entity.Scorer;
import tn.iit.service.MatchService;
import tn.iit.service.PlayerInPositionService;
import tn.iit.service.ScorerService;

@RestController
@RequestMapping("scorers")
public class ScorerController {
    private final ScorerService scorerService;
    private final MatchService matchService;
    private final PlayerInPositionService playerInPositionService;

    public ScorerController(ScorerService scorerService,
                            MatchService matchService,
                            PlayerInPositionService playerInPositionService) {
        this.scorerService = scorerService;
        this.matchService = matchService;
        this.playerInPositionService = playerInPositionService;
    }

    @GetMapping
    public ResponseEntity<Page<ScorerDto>> getScorers() {
        return ResponseEntity.ok(
                scorerService.getAllScorers(
                        PageRequest.of(0, 10)
                ).map(ScorerMapper::toScorerDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ScorerDto> getScorerById(@PathVariable Long id) {
        ScorerDto scorerDto = ScorerMapper.toScorerDto(scorerService.getScorerById(id));
        if(scorerDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scorerDto);
    }
    @PostMapping
    public ResponseEntity<ScorerDto> createScorer(@RequestBody ScorerDto scorerDto) {
        Scorer scorer = ScorerMapper.toScorer(scorerDto);
        scorer.setMatch(matchService.getMatchById(scorerDto.getMatchId()));
        scorer.setPlayerInPosition(playerInPositionService.getPlayerInPositionById(scorerDto.getPlayerInPositionId()));
        scorerService.createScorer(scorer);
        return ResponseEntity.status(HttpStatus.CREATED).body(scorerDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ScorerDto> updateScorer(@PathVariable Long id, @RequestBody ScorerDto scorerDto) {
        Scorer oldScorer = scorerService.getScorerById(id);
        if(oldScorer == null) {
            return ResponseEntity.notFound().build();
        }
        Scorer newScorer = ScorerMapper.toScorer(scorerDto);
        newScorer.setMatch(matchService.getMatchById(scorerDto.getMatchId()));
        newScorer.setPlayerInPosition(playerInPositionService.getPlayerInPositionById(scorerDto.getPlayerInPositionId()));
        scorerService.updateScorer(newScorer);
        return ResponseEntity.ok(scorerDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScorer(@PathVariable Long id) {
        scorerService.deleteScorer(id);
        return ResponseEntity.noContent().build();
    }
}
