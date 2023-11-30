package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.CoachRepository;
import tn.iit.entity.Coach;


@Service
public class CoachService {
    private CoachRepository coachRepository;

    @Autowired
    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public Coach createCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public Coach getCoachById(Long coachId) {
        return coachRepository.findById(coachId).orElse(null);
    }
    public Page<Coach> getAllCoaches(Pageable pageable) {
        return coachRepository.findAll(pageable);
    }

    public Coach updateCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public void deleteCoach(Long coachId) {
        coachRepository.deleteById(coachId);
    }
}
