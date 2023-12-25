package tn.iit.dto.mapper;

import tn.iit.dto.StandingDto;
import tn.iit.entity.Standing;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StandingMapper {
    public static StandingDto toStandingDto(Standing standing) {
        return StandingDto.builder()
                .id(standing.getId())
                .rank(standing.getRank())
                .score(standing.getScore())
                .build();
    }

    public static Standing toStanding(StandingDto standingDto) {
        Standing standing = new Standing();
        standing.setId(standingDto.getId());
        standing.setRank(standingDto.getRank());
        standing.setScore(standingDto.getScore());
        return standing;
    }

    public static List<StandingDto> toStandingDtoList(List<Standing> standings) {
        return standings.stream()
                .map(StandingMapper::toStandingDto)
                .collect(Collectors.toList());
    }

    public static List<Standing> toStandingList(List<StandingDto> standingDtos) {
        if (standingDtos == null) {
            return Collections.emptyList();
        }
        return standingDtos.stream()
                .map(StandingMapper::toStanding)
                .collect(Collectors.toList());
    }
}
