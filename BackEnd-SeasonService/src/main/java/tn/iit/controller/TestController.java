package tn.iit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.iit.proxy.MatchController;

@RestController
@RequestMapping("/test")
public class TestController {
    MatchController matchController;
    public TestController(MatchController matchController) {
        this.matchController = matchController;
    }
    @GetMapping
    public void test() {
        System.out.println(matchController.getMatchByIdForSeason(2));
        System.out.println(matchController.getTeamByIdForSeason(1));
    }
}
