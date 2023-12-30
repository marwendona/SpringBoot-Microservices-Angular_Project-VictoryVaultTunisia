package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.StadiumRepository;
import tn.iit.entity.Stadium;
import tn.iit.utils.checks.StadiumControl;

@Service
public class StadiumService {
    private StadiumRepository stadiumRepository;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public Stadium createStadium(Stadium stadium) {
        if(!StadiumControl.checkStadium(stadium).checkName().checkCapacity().finish()){
            throw new IllegalArgumentException("Invalid stadium");
        }

       return stadiumRepository.save(stadium);
    }

    public Stadium getStadiumById(Long stadiumId) {
        return stadiumRepository.findById(stadiumId).orElse(null);
    }

    public Stadium updateStadium(Stadium stadium) {
      return  stadiumRepository.save(stadium);
    }

    public void deleteStadium(Long stadiumId) {
        stadiumRepository.deleteById(stadiumId);
    }

    public Page<Stadium> getAllStadiums(Pageable pageable) {
        return stadiumRepository.findAll(pageable);
    }
}
