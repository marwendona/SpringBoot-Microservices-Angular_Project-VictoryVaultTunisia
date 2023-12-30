package tn.iit.dto.mapper;

import tn.iit.dto.TeamDto;
import tn.iit.entity.Team;

public class TeamMapper {
    public static TeamDto toTeamDto(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .standings(StandingMapper.toStandingDtoList(team.getStandings()))
                .build();
    }

    public static Team toTeam(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setName(teamDto.getName());
        return team;
    }
}
