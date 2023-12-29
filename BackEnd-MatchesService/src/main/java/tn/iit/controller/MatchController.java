package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.MatchDto;
import tn.iit.dto.mapper.MatchMapper;
import tn.iit.dto.mapper.ReplacementMapper;
import tn.iit.dto.mapper.ScorerMapper;
import tn.iit.entity.Match;
import tn.iit.service.LineupService;
import tn.iit.service.MatchService;
import tn.iit.service.RefereeService;
import tn.iit.service.StadiumService;

@RestController
@RequestMapping("/matches")
public class MatchController {
    private final MatchService matchService;
    private final RefereeService refereeService;
    private final LineupService lineupService;
    private final StadiumService stadiumService;

    public MatchController(MatchService matchService,
                           RefereeService refereeService,
                           LineupService lineupService,
                           StadiumService stadiumService) {
        this.matchService = matchService;
        this.refereeService = refereeService;
        this.lineupService = lineupService;
        this.stadiumService = stadiumService;
    }
    @GetMapping
    public ResponseEntity<Page<MatchDto>> getMatches() {
        Page<MatchDto> matches = matchService.getAllMatches(PageRequest.of(0,10)).map(MatchMapper::toMatchDto);
        matches.forEach(match -> {
            match.setTeamAwayScorers(
                    matchService.getMatchById(match.getId()).getTeamAwayScorers().stream().map(ScorerMapper::toScorerDto).toList()
            );
            match.setTeamHomeScorers(
                    matchService.getMatchById(match.getId()).getTeamHomeScorers().stream().map(ScorerMapper::toScorerDto).toList()
            );
            match.setReplacements(
                    matchService.getMatchById(match.getId()).getReplacements().stream().map(ReplacementMapper::toReplacementDto).toList()
            );
        });
        return ResponseEntity.ok(matchService.getAllMatches(PageRequest.of(0,10)).map(MatchMapper::toMatchDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> getMatchById(@PathVariable Long id) {
        MatchDto matchDto = MatchMapper.toMatchDto(matchService.getMatchById(id));
        matchDto.setStadiumId(stadiumService.getStadiumById(matchDto.getStadiumId()).getId());
        matchDto.setRefereeId(refereeService.getRefereeById(matchDto.getRefereeId()).getId());
        matchDto.setLineupAwayId(lineupService.getLineupById(matchDto.getLineupAwayId()).getId());
        matchDto.setLineupHomeId(lineupService.getLineupById(matchDto.getLineupHomeId()).getId());
        if(matchDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matchDto);
    }
    @PostMapping
    public ResponseEntity<MatchDto> createMatch(@RequestBody MatchDto matchDto) {
        Match match = MatchMapper.toMatch(matchDto);
        match.setStadium(stadiumService.getStadiumById(matchDto.getStadiumId()));
        match.setReferee(refereeService.getRefereeById(matchDto.getRefereeId()));
        match.setLineupAway(lineupService.getLineupById(matchDto.getLineupAwayId()));
        match.setLineupHomes(lineupService.getLineupById(matchDto.getLineupHomeId()));
        matchService.createMatch(match);
        return ResponseEntity.status(HttpStatus.CREATED).body(matchDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MatchDto> updateMatch(@PathVariable Long id, @RequestBody MatchDto matchDto) {
        Match oldMatch = matchService.getMatchById(id);
        if(oldMatch == null) {
            return ResponseEntity.notFound().build();
        }
        Match newMatch = MatchMapper.toMatch(matchDto);
        newMatch.setStadium(stadiumService.getStadiumById(matchDto.getStadiumId()));
        newMatch.setReferee(refereeService.getRefereeById(matchDto.getRefereeId()));
        newMatch.setLineupAway(lineupService.getLineupById(matchDto.getLineupAwayId()));
        newMatch.setLineupHomes(lineupService.getLineupById(matchDto.getLineupHomeId()));
        matchService.updateMatch(newMatch);
        return ResponseEntity.ok(matchDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}