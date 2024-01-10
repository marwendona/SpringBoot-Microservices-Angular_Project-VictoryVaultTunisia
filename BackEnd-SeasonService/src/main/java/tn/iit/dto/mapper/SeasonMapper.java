package tn.iit.dto.mapper;

import tn.iit.dto.SeasonDto;
import tn.iit.entity.Season;

public class SeasonMapper {
    public static SeasonDto toSeasonDto(Season season) {
        return SeasonDto.builder()
                .id(season.getId())
                .name(season.getName())
                .rounds(RoundMapper.toRoundDtoList(season.getRounds()))
                .generalStanding(StandingMapper.toStandingDtoList(season.getGeneralStanding()))
                .build();
    }

    public static Season toSeason(SeasonDto seasonDto) {
        Season season = new Season();
        season.setId(seasonDto.getId());
        season.setName(seasonDto.getName());
        season.setRounds(RoundMapper.toRoundList(seasonDto.getRounds()));
        season.setGeneralStanding(StandingMapper.toStandingList(seasonDto.getGeneralStanding()));
        return season;
    }
}
