package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.ReplacementRepository;
import tn.iit.entity.Replacement;

@Service
public class ReplacementService {
    private ReplacementRepository replacementRepository;

    @Autowired
    public ReplacementService(ReplacementRepository replacementRepository) {
        this.replacementRepository = replacementRepository;
    }

    public void createReplacement(Replacement replacement) {
        replacementRepository.save(replacement);
    }

    public Replacement getReplacementById(Long replacementId) {
        return replacementRepository.findById(replacementId).orElse(null);
    }

    public void updateReplacement(Replacement replacement) {
        replacementRepository.save(replacement);
    }

    public void deleteReplacement(Long replacementId) {
        replacementRepository.deleteById(replacementId);
    }

    public Page<Replacement> getAllReplacements(Pageable pageable) {
        return replacementRepository.findAll(pageable);
    }
}
