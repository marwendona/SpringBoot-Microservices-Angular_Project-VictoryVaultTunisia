package tn.iit.dto.mapper;

import tn.iit.dto.CoachDto;
import tn.iit.entity.Coach;

public class CoachMapper {
    public static Coach toCoach(CoachDto coachDto) {
        Coach coach = new Coach();
        coach.setId(coach.getId());
        coach.setFirstName(coachDto.getFirstName());
        coach.setLastName(coachDto.getLastName());
        coach.setNationality(coachDto.getNationality());
        return coach;
    }

    public static CoachDto toCoachDto(Coach coach) {
        return CoachDto.builder().
                id(coach.getId()).
                firstName(coach.getFirstName()).
                lastName(coach.getLastName()).
                nationality(coach.getNationality()).
                build();

    }
}
