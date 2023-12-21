package tn.iit.dto.mapper;

import tn.iit.dto.SeasonDto;
import tn.iit.entity.Season;

public class SeasonMapper {
    public static Season toSeason(SeasonDto seasonDto) {
        Season season = new Season();
        season.setId(seasonDto.getId());
        season.setName(seasonDto.getName());
        return season;
    }

    public static SeasonDto toSeasonDto(Season season) {
        return SeasonDto.builder().
                id(season.getId()).
                name(season.getName()).
                build();
    }
}
