package tn.iit.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.iit.dto.MatchDto;
import tn.iit.dto.TeamDto;

@FeignClient(name = "matches-service", path = "/")
public interface MatchController {
    @GetMapping("/matches/season-service/{id}")
    ResponseEntity<MatchDto> getMatchByIdForSeason(@PathVariable long id);
    @GetMapping("/teams/season-service/{id}")
    public ResponseEntity<TeamDto> getTeamByIdForSeason(@PathVariable long id);
}
