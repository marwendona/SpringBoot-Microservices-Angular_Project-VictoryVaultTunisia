package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.StandingRepository;
import tn.iit.entity.Season;
import tn.iit.entity.Standing;
import tn.iit.utils.checks.StandingControl;

@Service
public class StandingService {
    private final StandingRepository standingRepository;
    private final SeasonService seasonService;

    @Autowired
    public StandingService(StandingRepository standingRepository, SeasonService seasonService) {
        this.standingRepository = standingRepository;
        this.seasonService = seasonService;
    }

    public Standing createStanding(Standing standing, Long seasonId) {
        if (!StandingControl.checkStanding(standing).checkRank().checkScore().finish()) {
            throw new IllegalArgumentException("Invalid standing");
        }

        Season season = seasonService.getSeasonById(seasonId);
        standing.setSeason(season);

        return standingRepository.save(standing);
    }

    public Standing getStandingById(Long id) {
        return standingRepository.findById(id).orElse(null);
    }

    public Standing updateStanding(Standing standing) {
        return standingRepository.save(standing);
    }

    public void deleteStanding(Long id) {
        standingRepository.deleteById(id);
    }
    public Page<Standing> getAllStandings(Pageable pageable) {
        return standingRepository.findAll(pageable);
    }
}
