package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.iit.dto.StadiumDto;
import tn.iit.dto.mapper.StadiumMapper;
import tn.iit.entity.Stadium;
import tn.iit.service.StadiumService;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;

@RestController
@RequestMapping("stadiums")
public class StadiumController {
    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping
    public ResponseEntity<Page<StadiumDto>> getStadiums(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(
                stadiumService.getAllStadiums(
                        PageRequest.of(page, size)
                ).map(StadiumMapper::toStadiumDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<StadiumDto> getStadiumById(@PathVariable Long id) {
        return ResponseEntity.ok(
                StadiumMapper.toStadiumDto(stadiumService.getStadiumById(id)));
    }
    @PostMapping
    public ResponseEntity<StadiumDto> createStadium(@RequestParam("name") String name,
                                                    @RequestParam("capacity") BigInteger capacity ,
                                                    @RequestParam(name = "imageFile",required = false) MultipartFile imageFile) throws IOException {

        StadiumDto stadiumDto = StadiumDto.builder().
                name(name).
                capacity(capacity).
                build();

        if (imageFile != null) {
            String photo = StadiumService.saveImage(imageFile);
            stadiumDto.setPhoto(photo);
        }
        Stadium stadium = stadiumService.createStadium(StadiumMapper.toStadium(stadiumDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(StadiumMapper.toStadiumDto(stadium));
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
