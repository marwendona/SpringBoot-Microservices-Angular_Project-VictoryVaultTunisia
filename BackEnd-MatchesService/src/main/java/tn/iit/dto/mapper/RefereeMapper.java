package tn.iit.dto.mapper;

import tn.iit.dto.RefereeDto;
import tn.iit.entity.Referee;

public class RefereeMapper {

    public static RefereeDto toRefereeDto(Referee referee) {
        return RefereeDto.builder().
                id(referee.getId()).
                firstName(referee.getFirstName()).
                lastName(referee.getLastName()).
                nationality(referee.getNationality()).
                build();
    }

    public static Referee toReferee(RefereeDto dto) {
        Referee referee = new Referee();
        referee.setId(dto.getId());
        referee.setFirstName(dto.getFirstName());
        referee.setLastName(dto.getLastName());
        referee.setNationality(dto.getNationality());
        return referee;
    }
}
