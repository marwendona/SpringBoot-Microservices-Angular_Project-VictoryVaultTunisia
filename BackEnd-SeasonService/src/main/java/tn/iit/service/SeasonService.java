package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.SeasonRepository;
import tn.iit.entity.Season;
import tn.iit.utils.checks.SeasonControl;

@Service
public class SeasonService {
    private final SeasonRepository seasonRepository;

    @Autowired
    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    public Season createSeason(Season season) {
        if(!SeasonControl.checkSeason(season).checkName().finish()){
            throw new IllegalArgumentException("Invalid season");
        }
        return seasonRepository.save(season);
    }

    public Season getSeasonById(Long id) {
        return seasonRepository.findById(id).orElse(null);
    }

    public Season updateSeason(Season season) {
        return seasonRepository.save(season);
    }

    public void deleteSeason(Long id) {
        seasonRepository.deleteById(id);
    }
    public Page<Season> getAllSeasons(Pageable pageable) {
        return seasonRepository.findAll(pageable);
    }
}
