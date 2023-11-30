package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.LineupRepository;
import tn.iit.entity.Lineup;

@Service
public class LineupService {
    private LineupRepository lineupRepository;

    @Autowired
    public LineupService(LineupRepository lineupRepository) {
        this.lineupRepository = lineupRepository;
    }

    public void createLineup(Lineup lineup) {
        lineupRepository.save(lineup);
    }

    public Lineup getLineupById(long lineupId) {
        return lineupRepository.findById(lineupId).orElse(null);
    }

    public void updateLineup(Lineup lineup) {
        lineupRepository.save(lineup);
    }

    public void deleteLineup(long lineupId) {
        lineupRepository.deleteById(lineupId);
    }

    public Page<Lineup> getAllLineups(Pageable pageable) {
        return lineupRepository.findAll(pageable);
    }
}
