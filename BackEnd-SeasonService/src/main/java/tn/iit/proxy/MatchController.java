package tn.iit.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.iit.dto.MatchDto;
import tn.iit.dto.TeamDto;

import java.util.List;

@FeignClient(name = "matches-service", path = "/")
public interface MatchController {

    @GetMapping("/matches/matches/season-service/{id}")
    ResponseEntity<List<MatchDto>> getMatchesByRoundId(@PathVariable long id);
    @DeleteMapping("/matches/matches/season-service/{id}")
    ResponseEntity<Void> deleteMatchesByRoundId(@PathVariable long id);
    @GetMapping("/teams/teams/season-service/{id}")
    ResponseEntity<TeamDto> getTeamByID(@PathVariable long id);

}
