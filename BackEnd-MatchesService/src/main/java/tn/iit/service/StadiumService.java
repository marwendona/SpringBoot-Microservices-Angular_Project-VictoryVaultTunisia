package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.StadiumRepository;
import tn.iit.entity.Stadium;

@Service
public class StadiumService {
    private StadiumRepository stadiumRepository;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public void createStadium(Stadium stadium) {
        stadiumRepository.save(stadium);
    }

    public Stadium getStadiumById(Long stadiumId) {
        return stadiumRepository.findById(stadiumId).orElse(null);
    }

    public void updateStadium(Stadium stadium) {
        stadiumRepository.save(stadium);
    }

    public void deleteStadium(Long stadiumId) {
        stadiumRepository.deleteById(stadiumId);
    }

    public Page<Stadium> getAllStadiums(Pageable pageable) {
        return stadiumRepository.findAll(pageable);
    }
}
