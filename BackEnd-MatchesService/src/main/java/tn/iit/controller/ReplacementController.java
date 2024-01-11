package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.ReplacementDto;
import tn.iit.dto.mapper.ReplacementMapper;
import tn.iit.entity.Replacement;
import tn.iit.service.MatchService;
import tn.iit.service.PlayerInPositionService;
import tn.iit.service.ReplacementService;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/replacements")
public class ReplacementController {
    private final ReplacementService replacementService;
    private final PlayerInPositionService playerInPositionService;
    private final MatchService matchService;

    public ReplacementController(ReplacementService replacementService, PlayerInPositionService playerInPositionService, MatchService matchService) {
        this.replacementService = replacementService;
        this.playerInPositionService = playerInPositionService;
        this.matchService = matchService;
    }
    @GetMapping
    public ResponseEntity<Page<ReplacementDto>> getAllReplacements(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<ReplacementDto> replacements = replacementService.
                getAllReplacements(PageRequest.of(page,size)).
                map(ReplacementMapper::toReplacementDto);
        return ResponseEntity.ok(replacements);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReplacementDto> getReplacementById(@PathVariable Long id) {
        return ResponseEntity.ok(ReplacementMapper.toReplacementDto(replacementService.getReplacementById(id)));
    }
    @PostMapping
    public ResponseEntity<ReplacementDto> createReplacement(@RequestBody ReplacementDto replacementDto) {
        Replacement replacement = ReplacementMapper.toReplacement(replacementDto);
        replacement.setMatch(matchService.getMatchById(replacementDto.getMatchId()));
        replacement.setPlayerIn(playerInPositionService.getPlayerInPositionById(replacementDto.getPlayerInId()));
        replacement.setPlayerOut(playerInPositionService.getPlayerInPositionById(replacementDto.getPlayerOutId()));
        replacementService.createReplacement(replacement);
        return ResponseEntity.status(HttpStatus.CREATED).body(replacementDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ReplacementDto> updateReplacement(@PathVariable Long id, @RequestBody ReplacementDto replacementDto) {
        Replacement oldReplacement = replacementService.getReplacementById(id);
        if (oldReplacement == null) {
            return ResponseEntity.notFound().build();
        }
        Replacement replacement = ReplacementMapper.toReplacement(replacementDto);
        replacement.setId(id);
        replacement.setMatch(matchService.getMatchById(replacementDto.getMatchId()));
        replacement.setPlayerIn(playerInPositionService.getPlayerInPositionById(replacementDto.getPlayerInId()));
        replacement.setPlayerOut(playerInPositionService.getPlayerInPositionById(replacementDto.getPlayerOutId()));
        replacementService.updateReplacement(replacement);
        return ResponseEntity.ok(replacementDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReplacement(@PathVariable Long id) {
        Replacement replacement = replacementService.getReplacementById(id);
        if (replacement == null) {
            return ResponseEntity.notFound().build();
        }
        replacementService.deleteReplacement(id);
        return ResponseEntity.noContent().build();
    }
}
