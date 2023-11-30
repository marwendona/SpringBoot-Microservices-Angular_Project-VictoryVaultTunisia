package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.ScorerRepository;
import tn.iit.entity.Scorer;

@Service
public class ScorerService {
    private ScorerRepository scorerRepository;

    @Autowired
    public ScorerService(ScorerRepository scorerRepository) {
        this.scorerRepository = scorerRepository;
    }

    public Scorer createScorer(Scorer scorer) {
        return scorerRepository.save(scorer);
    }

    public Scorer getScorerById(Long scorerId) {
        return scorerRepository.findById(scorerId).orElse(null);
    }

    public Scorer updateScorer(Scorer scorer) {
        return scorerRepository.save(scorer);
    }

    public void deleteScorer(Long scorerId) {
        scorerRepository.deleteById(scorerId);
    }

    public Page<Scorer> getAllScorers(Pageable pageable) {
        return scorerRepository.findAll(pageable);
    }
}
