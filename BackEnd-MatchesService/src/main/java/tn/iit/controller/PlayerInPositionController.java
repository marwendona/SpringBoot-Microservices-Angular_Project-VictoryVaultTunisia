package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.PlayerInPositionDto;
import tn.iit.dto.mapper.PlayerInPositionMapper;
import tn.iit.entity.PlayerInPosition;
import tn.iit.service.LineupService;
import tn.iit.service.PlayerInPositionService;
import tn.iit.service.PlayerService;
import tn.iit.service.TeamService;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/playerinposition")
public class PlayerInPositionController {
    private final PlayerInPositionService playerInPositionService;
    private final PlayerService playerService;
    private final LineupService lineupService;

    public PlayerInPositionController(PlayerInPositionService playerInPositionService,
                                      PlayerService playerService,
                                      LineupService lineupService) {
        this.playerInPositionService = playerInPositionService;
        this.playerService = playerService;
        this.lineupService = lineupService;
    }
    @GetMapping
    public ResponseEntity<Page<PlayerInPositionDto>> getAllPlayerInPosition(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<PlayerInPositionDto> playerInPositionDto = playerInPositionService.
                getAllPlayerInPositions(PageRequest.of(page, size)).
                map(PlayerInPositionMapper::toPlayerInPositionDto);
        return ResponseEntity.ok(playerInPositionDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlayerInPositionDto> getPlayerInPositionById(@PathVariable Long id) {
        PlayerInPositionDto playerInPositionDto = PlayerInPositionMapper.toPlayerInPositionDto(playerInPositionService.getPlayerInPositionById(id));
        if (playerInPositionDto != null) {
            return ResponseEntity.ok(playerInPositionDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<PlayerInPositionDto> createPlayerInPosition(@RequestBody PlayerInPositionDto playerInPositionDto) {
        PlayerInPosition playerInPosition = PlayerInPositionMapper.toPlayerInPosition(playerInPositionDto);
        playerInPosition.setPlayer(playerService.getPlayerById(playerInPositionDto.getPlayerId()));
        playerInPosition.setLineup(lineupService.getLineupById(playerInPositionDto.getLineupId()));
        playerInPositionService.createPlayerInPosition(playerInPosition);
        return ResponseEntity.status(HttpStatus.CREATED).body(playerInPositionDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PlayerInPositionDto> updatePlayerInPosition(@PathVariable Long id, @RequestBody PlayerInPositionDto playerInPositionDto) {
        PlayerInPosition existingPlayerInPosition = playerInPositionService.getPlayerInPositionById(id);
        if (existingPlayerInPosition != null) {
            PlayerInPosition playerInPosition = PlayerInPositionMapper.toPlayerInPosition(playerInPositionDto);
            playerInPosition.setId(id);
            playerInPosition.setPlayer(playerService.getPlayerById(existingPlayerInPosition.getPlayer().getId()));
            playerInPosition.setLineup(lineupService.getLineupById(existingPlayerInPosition.getLineup().getId()));
            playerInPositionService.updatePlayerInPosition(playerInPosition);
            return ResponseEntity.ok(playerInPositionDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerInPosition(@PathVariable Long id) {
        playerInPositionService.deletePlayerInPosition(id);
        return ResponseEntity.noContent().build();
    }
}
