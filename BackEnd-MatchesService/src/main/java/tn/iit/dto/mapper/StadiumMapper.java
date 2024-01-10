package tn.iit.dto.mapper;

import tn.iit.dto.MatchDto;
import tn.iit.dto.StadiumDto;
import tn.iit.entity.Match;
import tn.iit.entity.Stadium;

import java.util.List;
import java.util.Optional;

public class StadiumMapper {
    public static Stadium toStadium(StadiumDto stadiumDto) {
        Stadium stadium = new Stadium();
        stadium.setId(stadiumDto.getId());
        stadium.setName(stadiumDto.getName());
        stadium.setCapacity(stadiumDto.getCapacity());
        stadium.setPhoto(stadiumDto.getPhoto());
        return stadium;
    }

    public static StadiumDto toStadiumDto(Stadium stadium) {
        Optional<List<Match>>  matches = Optional.ofNullable(stadium.getMatches());
        List<MatchDto> matchDtos = matches.map(m -> m.stream().map(MatchMapper::toMatchDto).toList()).orElse(List.of());
        return StadiumDto.builder().
                id(stadium.getId()).
                name(stadium.getName()).
                capacity(stadium.getCapacity()).
                matches(matchDtos).
                photo(stadium.getPhoto()).
                build();
    }
}
