package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.iit.dto.PlayerDto;
import tn.iit.dto.TeamDto;
import tn.iit.dto.mapper.PlayerMapper;
import tn.iit.dto.mapper.TeamMapper;
import tn.iit.entity.Player;
import tn.iit.entity.Team;
import tn.iit.service.CoachService;
import tn.iit.service.PlayerService;
import tn.iit.service.TeamService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final CoachService coachService;
    private final TeamService teamService;
    private final PlayerService playerService;

    public TeamController(CoachService coachService,
                          TeamService teamService,
                          PlayerService playerService) {
        this.coachService = coachService;
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        Team team = TeamMapper.toTeam(teamDto);
        team.setCoach(coachService.getCoachById(teamDto.getCoachId()));
        Team createdTeam = teamService.createTeam(team);
        List<Player> players = teamDto.getPlayers().stream().map(PlayerMapper::toPlayer).toList();
        List<Player> playersPresent = new ArrayList<>();
        for (Player player : players) {
            Player existingPlayer = playerService.getPlayerById(player.getId());
            existingPlayer.setTeam(team);
            playersPresent.add(existingPlayer); 
        }
        createdTeam.setPlayers(playersPresent);
        return new ResponseEntity<>(TeamMapper.toTeamDto(createdTeam), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<TeamDto>> getAllTeams(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<TeamDto> teams = teamService.getAllTeams(PageRequest.of(page, size)).map(TeamMapper::toTeamDto);
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable Long id) {
        Team team = teamService.getTeamById(id);

        if (team != null) {
            TeamDto teamDto = TeamMapper.toTeamDto(team);
            teamDto.setCoachId(team.getCoach().getId());
            return new ResponseEntity<>(teamDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable Long id, @RequestBody TeamDto team) {
        Team existingTeam = teamService.getTeamById(id);
        if (existingTeam != null) {
            Team newTeam = TeamMapper.toTeam(team);

            newTeam.setId(id);
            newTeam.setCoach(coachService.getCoachById(team.getCoachId()));
            Team updateTeam = teamService.updateTeam(newTeam);

            TeamDto teamDto = TeamMapper.toTeamDto(updateTeam);

            return ResponseEntity.ok(teamDto);
        } else {
            return  ResponseEntity.notFound().build();
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
    @GetMapping("/{id}/players")
    public ResponseEntity<List<PlayerDto>> getPlayersByTeam(@PathVariable Long id) {
        Team team = teamService.getTeamById(id);
        if (team != null) {
            return new ResponseEntity<>(team.getPlayers().stream().map(PlayerMapper::toPlayerDto).toList(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
