package tn.iit.controller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.iit.dto.PlayerDto;
import tn.iit.dto.mapper.PlayerMapper;
import tn.iit.entity.Player;
import tn.iit.service.PlayerService;
import tn.iit.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {


    private final PlayerService playerService;
    private final TeamService teamService;

    public PlayerController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto) {
        Player player = PlayerMapper.toPlayer(playerDto);
        if (playerDto.getTeamId() != null) {
            player.setTeam(teamService.getTeamById(playerDto.getTeamId()));
        }
        Player createdPlayer = playerService.createPlayer(player);
        return new ResponseEntity<>(PlayerMapper.toPlayerDto(createdPlayer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<PlayerDto>> getAllPlayers() {
        Page<PlayerDto> players = playerService.getAllPlayers(PageRequest.of(0,10)).map(PlayerMapper::toPlayerDto);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        if (player != null) {
            return new ResponseEntity<>(PlayerMapper.toPlayerDto(player), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> updatePlayer( @PathVariable Long id, @RequestBody PlayerDto playerDto) {
        Player existingPlayer = playerService.getPlayerById(id);
        if (existingPlayer != null) {
            Player player = PlayerMapper.toPlayer(playerDto);
            player.setId(id);
            player.setTeam(teamService.getTeamById(playerDto.getTeamId()));
            Player updatedPlayer = playerService.updatePlayer(player);
            return new ResponseEntity<>(PlayerMapper.toPlayerDto(updatedPlayer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        Player existingPlayer = playerService.getPlayerById(id);
        if (existingPlayer!=null) {
            playerService.deletePlayer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
