package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.iit.dto.LineupDto;
import tn.iit.dto.PlayerDto;
import tn.iit.dto.TeamDto;
import tn.iit.dto.mapper.LineupMapper;
import tn.iit.dto.mapper.PlayerMapper;
import tn.iit.dto.mapper.TeamMapper;
import tn.iit.entity.Coach;
import tn.iit.entity.Team;
import tn.iit.service.CoachService;
import tn.iit.service.LineupService;
import tn.iit.service.PlayerInPositionService;
import tn.iit.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final CoachService coachService;
    private final TeamService teamService;

    public TeamController(CoachService coachService,
                          TeamService teamService) {
        this.coachService = coachService;
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        Team team = TeamMapper.toTeam(teamDto);
        team.setCoach(coachService.getCoachById(teamDto.getCoachId()));
        teamService.createTeam(team);
        return new ResponseEntity<>(teamDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<TeamDto>> getAllTeams() {
        Page<TeamDto> teams = teamService.getAllTeams(PageRequest.of(0,10)).map(TeamMapper::toTeamDto);
        teams.forEach(team ->
                team.setLineups(
                        teamService.getTeamById(team.getId()).
                        getLineups().stream().map(LineupMapper::toLineupDto).toList()
                )
        );
        teams.forEach(team ->
                team.setPlayers(
                        teamService.getTeamById(team.getId()).
                                getPlayers().stream().map(PlayerMapper::toPlayerDto).toList()
                )
        );
        teams.forEach(team ->
                team.setCoachId(
                        teamService.getTeamById(team.getId()).
                                getCoach().getId()
                )
        );
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable Long id) {
        Team team = teamService.getTeamById(id);
        TeamDto teamDto = TeamMapper.toTeamDto(team);
        teamDto.setLineups(team.getLineups().stream().map(LineupMapper::toLineupDto).toList());
        teamDto.setPlayers(team.getPlayers().stream().map(PlayerMapper::toPlayerDto).toList());
        teamDto.setCoachId(team.getCoach().getId());
        if (team != null) {
            return new ResponseEntity<>(teamDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable Long id, @RequestBody TeamDto team) {
        Team existingTeam = teamService.getTeamById(id);
        team.setLineups(team.getLineups());
        team.setPlayers(team.getPlayers());
        team.setCoachId(team.getCoachId());

        if (existingTeam != null) {
            teamService.updateTeam(TeamMapper.toTeam(team));
            return new ResponseEntity<>(team, HttpStatus.OK);
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
