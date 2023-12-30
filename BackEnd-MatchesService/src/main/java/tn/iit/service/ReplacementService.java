package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.ReplacementRepository;
import tn.iit.entity.Replacement;
import tn.iit.utils.checks.ReplacementControl;

@Service
public class ReplacementService {
    private ReplacementRepository replacementRepository;

    @Autowired
    public ReplacementService(ReplacementRepository replacementRepository) {
        this.replacementRepository = replacementRepository;
    }

    public Replacement createReplacement(Replacement replacement) {
        if (!ReplacementControl.checkReplacement(replacement).checkReplacementTime().finish()) {
            throw new IllegalArgumentException("Invalid replacement");
        }
        return replacementRepository.save(replacement);
    }

    public Replacement getReplacementById(Long replacementId) {
        return replacementRepository.findById(replacementId).orElse(null);
    }

    public Replacement updateReplacement(Replacement replacement) {
        return replacementRepository.save(replacement);
    }

    public void deleteReplacement(Long replacementId) {
        replacementRepository.deleteById(replacementId);
    }

    public Page<Replacement> getAllReplacements(Pageable pageable) {
        return replacementRepository.findAll(pageable);
    }
}
