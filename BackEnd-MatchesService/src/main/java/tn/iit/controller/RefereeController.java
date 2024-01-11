package tn.iit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.RefereeDto;
import tn.iit.dto.mapper.RefereeMapper;
import tn.iit.entity.Referee;
import tn.iit.service.RefereeService;

@RestController
@RequestMapping("/referees")
public class RefereeController {
    private final RefereeService refereeService;

    public RefereeController(RefereeService refereeService) {
        this.refereeService = refereeService;
    }

    @GetMapping
    public ResponseEntity<Page<RefereeDto>> getAllReferees(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<RefereeDto> referees = refereeService.
                getAllReferees(PageRequest.of(page,size)).
                map(RefereeMapper::toRefereeDto);
        return ResponseEntity.ok(referees);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RefereeDto> getRefereeById(@PathVariable Long id) {
        Referee referee = refereeService.getRefereeById(id);
        if (referee != null) {
            RefereeDto refereeDto = RefereeMapper.toRefereeDto(referee);
            return ResponseEntity.ok(refereeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RefereeDto> createReferee(@RequestBody RefereeDto refereeDto) {
        Referee referee = RefereeMapper.toReferee(refereeDto);
        Referee createdReferee = refereeService.createReferee(referee);
        RefereeDto createdRefereeDto = RefereeMapper.toRefereeDto(createdReferee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRefereeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RefereeDto> updateReferee(@PathVariable Long id, @RequestBody RefereeDto refereeDto) {
        Referee existingReferee = refereeService.getRefereeById(id);
        if (existingReferee != null) {
            Referee referee = RefereeMapper.toReferee(refereeDto);
            referee.setId(id);
            Referee updatedReferee = refereeService.updateReferee(referee);
            RefereeDto updatedRefereeDto = RefereeMapper.toRefereeDto(updatedReferee);
            return ResponseEntity.ok(updatedRefereeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReferee(@PathVariable Long id) {
        Referee existingReferee = refereeService.getRefereeById(id);
        if (existingReferee != null) {
            refereeService.deleteReferee(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
