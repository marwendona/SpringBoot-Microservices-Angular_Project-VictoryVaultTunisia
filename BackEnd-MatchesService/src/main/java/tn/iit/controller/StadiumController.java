package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.StadiumDto;
import tn.iit.dto.mapper.StadiumMapper;
import tn.iit.entity.Stadium;
import tn.iit.service.StadiumService;

@RestController
@RequestMapping("stadiums")
public class StadiumController {
    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping
    public ResponseEntity<Page<StadiumDto>> getStadiums() {
        return ResponseEntity.ok(
                stadiumService.getAllStadiums(
                        PageRequest.of(0, 10)
                ).map(StadiumMapper::toStadiumDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<StadiumDto> getStadiumById(@PathVariable Long id) {
        return ResponseEntity.ok(
                StadiumMapper.toStadiumDto(stadiumService.getStadiumById(id)));
    }
    @PostMapping
    public ResponseEntity<StadiumDto> createStadium(@RequestBody StadiumDto stadiumDto) {
        stadiumService.createStadium(StadiumMapper.toStadium(stadiumDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(stadiumDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StadiumDto> updateStadium(@PathVariable Long id, @RequestBody StadiumDto stadiumDto) {
        Stadium oldStadium = stadiumService.getStadiumById(id);
        if (oldStadium == null) {
            return ResponseEntity.notFound().build();
        }
        Stadium newStadium = StadiumMapper.toStadium(stadiumDto);
        newStadium.setId(id);
        stadiumService.updateStadium(newStadium);
        return ResponseEntity.ok(stadiumDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStadium(@PathVariable Long id) {
        stadiumService.deleteStadium(id);
        return ResponseEntity.noContent().build();
    }
}
