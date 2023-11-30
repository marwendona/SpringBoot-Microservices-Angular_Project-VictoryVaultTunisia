package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.StandingRepository;
import tn.iit.entity.Standing;

@Service
public class StandingService {
    private final StandingRepository standingRepository;

    @Autowired
    public StandingService(StandingRepository standingRepository) {
        this.standingRepository = standingRepository;
    }

    public Standing createStanding(Standing standing) {
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
