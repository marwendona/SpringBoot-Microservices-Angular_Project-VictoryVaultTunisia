package tn.iit.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.RoundDto;
import tn.iit.dto.mapper.RoundMapper;
import tn.iit.entity.Round;
import tn.iit.entity.Season;
import tn.iit.proxy.MatchController;
import tn.iit.service.RoundService;
import tn.iit.service.SeasonService;



@RestController
@RequestMapping("/rounds")
public class RoundController {

    private final RoundService roundService;
    private final SeasonService seasonService;
    private final MatchController matchController;

    public RoundController(RoundService roundService, SeasonService seasonService, MatchController matchController) {
        this.roundService = roundService;
        this.seasonService = seasonService;
        this.matchController = matchController;
    }

    @GetMapping
    public ResponseEntity<List<RoundDto>> getAllRounds(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1000") int size) {
        Page<RoundDto> rounds = roundService.
                getAllRounds(PageRequest.of(page, size)).
                map(RoundMapper::toRoundDto).
                map(roundDto -> {
                    roundDto.setMatches(matchController.getMatchesByRoundId(roundDto.getId()).getBody());
                    return roundDto;
                } );
        return ResponseEntity.ok(rounds.getContent());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoundDto> getRoundById(@PathVariable Long id) {
        Round round = roundService.getRoundById(id);
        if (round != null) {
            RoundDto roundDto = RoundMapper.toRoundDto(round);
            roundDto.setMatches(matchController.getMatchesByRoundId(roundDto.getId()).getBody());
            return ResponseEntity.ok(roundDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{seasonId}")
    public ResponseEntity<RoundDto> createRound(@RequestBody RoundDto roundDto, @PathVariable Long seasonId) {
        Round round = RoundMapper.toRound(roundDto);
        Round createdRound = roundService.createRound(round, seasonId);
        RoundDto createdRoundDto = RoundMapper.toRoundDto(createdRound);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoundDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoundDto> updateRound(@PathVariable Long id, @RequestBody RoundDto roundDto) {
        Round existingRound = roundService.getRoundById(id);
        if (existingRound != null) {
            Round round = RoundMapper.toRound(roundDto);
            round.setId(id);
            Season existingSeason = existingRound.getSeason();
            round.setSeason(existingSeason);
            Round updatedRound = roundService.updateRound(round);
            RoundDto updatedRoundDto = RoundMapper.toRoundDto(updatedRound);
            return ResponseEntity.ok(updatedRoundDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRound(@PathVariable Long id) {
        Round existingRound = roundService.getRoundById(id);
        if (existingRound != null) {
            roundService.deleteRound(id);
            matchController.deleteMatchesByRoundId(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
