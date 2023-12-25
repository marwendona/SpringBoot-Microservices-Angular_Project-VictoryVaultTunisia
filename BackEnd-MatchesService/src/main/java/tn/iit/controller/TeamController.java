package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.iit.dto.TeamDto;
import tn.iit.dto.mapper.TeamMapper;
import tn.iit.entity.Coach;
import tn.iit.entity.Team;
import tn.iit.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team createdTeam = teamService.createTeam(team);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<TeamDto>> getAllTeams() {
        Page<TeamDto> teams = teamService.getAllTeams(PageRequest.of(0,10)).map(TeamMapper::toTeamDto);
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable Long id) {
        Team team = teamService.getTeamById(id);
        TeamDto teamDto = TeamMapper.toTeamDto(team);
        if (team != null) {
            return new ResponseEntity<>(teamDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable Long id, @RequestBody Team team) {
        Team existingTeam = teamService.getTeamById(id);
        if (existingTeam != null) {
            Team updatedTeam = teamService.updateTeam(team);
            TeamDto updatedTeamDto = TeamMapper.toTeamDto(updatedTeam);
            return new ResponseEntity<>(updatedTeamDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {

        if (teamService.getTeamById(id) != null) {
            teamService.deleteTeam(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
