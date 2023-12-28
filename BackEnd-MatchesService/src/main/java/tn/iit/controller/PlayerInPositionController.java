package tn.iit.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.PlayerInPositionDto;
import tn.iit.dto.mapper.PlayerInPositionMapper;
import tn.iit.entity.PlayerInPosition;
import tn.iit.service.PlayerInPositionService;
import tn.iit.service.PlayerService;

@RestController
@RequestMapping("/playerinposition")
public class PlayerInPositionController {
    private final PlayerInPositionService playerInPositionService;
    private final PlayerService playerService;

    public PlayerInPositionController(PlayerInPositionService playerInPositionService, PlayerService playerService) {
        this.playerInPositionService = playerInPositionService;
        this.playerService = playerService;
    }
    @GetMapping
    public ResponseEntity<PlayerInPositionDto> getAllPlayerInPosition() {
        PlayerInPositionDto playerInPositionDto = playerInPositionService.
                getAllPlayerInPositions(PageRequest.of(0,10)).
                map(PlayerInPositionMapper::toPlayerInPositionDto).getContent().get(0);
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
        playerInPosition.setPlayer(playerService.getPlayerById(playerInPosition.getPlayer().getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(playerInPositionDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PlayerInPositionDto> updatePlayerInPosition(@PathVariable Long id, @RequestBody PlayerInPositionDto playerInPositionDto) {
        PlayerInPosition existingPlayerInPosition = playerInPositionService.getPlayerInPositionById(id);
        if (existingPlayerInPosition != null) {
            PlayerInPosition playerInPosition = PlayerInPositionMapper.toPlayerInPosition(playerInPositionDto);
            playerInPosition.setPlayer(playerService.getPlayerById(playerInPosition.getPlayer().getId()));
            return ResponseEntity.ok(PlayerInPositionMapper.toPlayerInPositionDto(playerInPositionService.updatePlayerInPosition(playerInPosition)));
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
