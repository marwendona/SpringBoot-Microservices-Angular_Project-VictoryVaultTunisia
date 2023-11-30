package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.RefereeRepository;
import tn.iit.entity.Referee;

@Service
public class RefereeService {
    private RefereeRepository refereeRepository;

    @Autowired
    public RefereeService(RefereeRepository refereeRepository) {
        this.refereeRepository = refereeRepository;
    }

    public Referee createReferee(Referee referee) {
        return refereeRepository.save(referee);
    }

    public Referee getRefereeById(Long refereeId) {
        return refereeRepository.findById(refereeId).orElse(null);
    }

    public Referee updateReferee(Referee referee) {
        return refereeRepository.save(referee);
    }

    public void deleteReferee(Long refereeId) {
        refereeRepository.deleteById(refereeId);
    }

    public Page<Referee> getAllReferees(Pageable pageable) {
        return refereeRepository.findAll(pageable);
    }
}
