package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.MatchRepository;
import tn.iit.entity.Match;
import tn.iit.utils.checks.MatchControl;

@Service
public class MatchService {
    private MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match createMatch(Match match) {
        if(!MatchControl.checkMatch(match).checkDate().checkSpectatorNumber().finish()){
            throw new IllegalArgumentException("Invalid match");
        }

        return matchRepository.save(match);
    }

    public Match getMatchById(Long matchId) {
        return matchRepository.findById(matchId).orElse(null);
    }
    public Page<Match> getAllMatches(Pageable pageable) {
        return matchRepository.findAll(pageable);
    }

    public Match updateMatch(Match match) {
        return matchRepository.save(match);
    }

    public void deleteMatch(Long matchId) {
        matchRepository.deleteById(matchId);
    }
}
