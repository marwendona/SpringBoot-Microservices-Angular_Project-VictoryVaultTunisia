package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.RoundRepository;
import tn.iit.entity.Round;
import tn.iit.entity.Season;
import tn.iit.utils.checks.RoundControl;

@Service
public class RoundService {
    private final RoundRepository roundRepository;
    private final SeasonService seasonService;

    @Autowired
    public RoundService(RoundRepository roundRepository, SeasonService seasonService) {
        this.roundRepository = roundRepository;
        this.seasonService = seasonService;
    }

    public Round createRound(Round round, Long seasonId) {
        if (!RoundControl.checkRound(round).checkName().checkRoundNumber().finish()) {
            throw new IllegalArgumentException("Invalid round");
        }

        Season season = seasonService.getSeasonById(seasonId);
        round.setSeason(season);

        return roundRepository.save(round);
    }

    public Round getRoundById(Long id) {
        return roundRepository.findById(id).orElse(null);
    }

    public Round updateRound(Round round) {
        return roundRepository.save(round);
    }

    public void deleteRound(Long id) {
        roundRepository.deleteById(id);
    }
    public Page<Round> getAllRounds(Pageable pageable) {
        return roundRepository.findAll(pageable);
    }
}
