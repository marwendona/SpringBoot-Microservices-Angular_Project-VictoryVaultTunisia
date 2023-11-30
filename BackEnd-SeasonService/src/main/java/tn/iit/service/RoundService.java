package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.RoundRepository;
import tn.iit.entity.Round;

@Service
public class RoundService {
    private final RoundRepository roundRepository;

    @Autowired
    public RoundService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    public Round createRound(Round round) {
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
