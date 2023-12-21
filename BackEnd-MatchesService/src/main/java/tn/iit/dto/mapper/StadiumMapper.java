package tn.iit.dto.mapper;

import tn.iit.dto.StadiumDto;
import tn.iit.entity.Stadium;

public class StadiumMapper {
    public static Stadium toStadium(StadiumDto stadiumDto) {
        Stadium stadium = new Stadium();
        stadium.setId(stadiumDto.getId());
        stadium.setName(stadiumDto.getName());
        stadium.setCapacity(stadiumDto.getCapacity());
        //TO FIX
        //stadium.setMatches(stadiumDto.getMatches().stream().map(MatchMapper::toMatch).toList());
        return stadium;
    }

    public static StadiumDto toStadiumDto(Stadium stadium) {
        return StadiumDto.builder().
                id(stadium.getId()).
                name(stadium.getName()).
                capacity(stadium.getCapacity()).
                //matches(stadium.getMatches().stream().map(MatchMapper::toMatchDto).toList()).
                build();
    }
}
