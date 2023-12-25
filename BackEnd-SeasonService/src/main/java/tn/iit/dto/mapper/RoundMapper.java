package tn.iit.dto.mapper;

import tn.iit.dto.RoundDto;
import tn.iit.entity.Round;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RoundMapper {
    public static RoundDto toRoundDto(Round round) {
        return RoundDto.builder()
                .id(round.getId())
                .name(round.getName())
                .roundNumber(round.getRoundNumber())
                .build();
    }

    public static Round toRound(RoundDto roundDto) {
        Round round = new Round();
        round.setId(roundDto.getId());
        round.setName(roundDto.getName());
        round.setRoundNumber(roundDto.getRoundNumber());
        return round;
    }

    public static List<RoundDto> toRoundDtoList(List<Round> rounds) {
        return rounds.stream()
                .map(RoundMapper::toRoundDto)
                .collect(Collectors.toList());
    }

    public static List<Round> toRoundList(List<RoundDto> roundDtos) {
        if (roundDtos == null) {
            return Collections.emptyList();
        }
        return roundDtos.stream()
                .map(RoundMapper::toRound)
                .collect(Collectors.toList());
    }
}
