package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.LineupDto;
import tn.iit.dto.mapper.LineupMapper;
import tn.iit.entity.Lineup;
import tn.iit.entity.Team;
import tn.iit.service.LineupService;
import tn.iit.service.PlayerInPositionService;
import tn.iit.service.TeamService;

@RestController
@RequestMapping("/lineups")
public class LineupController {

    private final TeamService teamService;
    private final LineupService lineupService;

    LineupController(TeamService teamService, LineupService lineupService, PlayerInPositionService playerInPositionService) {
        this.teamService = teamService;
        this.lineupService = lineupService;
    }
    @GetMapping
    public ResponseEntity<Page<LineupDto>> getAllLineups() {
        Page<LineupDto> lineups = lineupService.getAllLineups(PageRequest.of(0,10)).map(LineupMapper::toLineupDto);
        return ResponseEntity.ok(lineups);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LineupDto> getLineupById(@PathVariable Long id) {
        LineupDto lineup = LineupMapper.toLineupDto(lineupService.getLineupById(id));
        if (lineup != null) {
            return ResponseEntity.ok(lineup);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<LineupDto> createLineup(@RequestBody LineupDto lineupDto) {
        Lineup lineup = LineupMapper.toLineup(lineupDto);
        Team team = teamService.getTeamById(lineupDto.getTeamId());
        lineup.setTeam(team);
        lineupService.createLineup(lineup);
        return ResponseEntity.status(HttpStatus.CREATED).body(lineupDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LineupDto> updateLineup(@PathVariable Long id, @RequestBody LineupDto lineupDto) {
        Lineup existingLineup = lineupService.getLineupById(id);
        if (existingLineup != null) {
            Lineup lineup = LineupMapper.toLineup(lineupDto);
            Team team = teamService.getTeamById(lineupDto.getTeamId());
            lineup.setTeam(team);
            Lineup updatedLineup = lineupService.updateLineup(lineup);
            LineupDto updatedLineupDto = LineupMapper.toLineupDto(updatedLineup);
            return ResponseEntity.ok(updatedLineupDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLineup(@PathVariable Long id) {
        Lineup existingLineup = lineupService.getLineupById(id);
        if (existingLineup != null) {
            lineupService.deleteLineup(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
