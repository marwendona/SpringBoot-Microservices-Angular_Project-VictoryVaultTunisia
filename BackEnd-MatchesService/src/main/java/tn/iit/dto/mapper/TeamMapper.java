package tn.iit.dto.mapper;

import tn.iit.dto.TeamDto;
import tn.iit.entity.Team;
import tn.iit.service.CoachService;

public class TeamMapper {

    public static TeamDto toTeamDto(Team team) {
        return TeamDto.builder().
                id(team.getId()).
                name(team.getName()).
                players(team.getPlayers().stream().map(PlayerMapper::toPlayerDto).toList()).
                coachId(team.getCoach().getId()).
                build();
    }
    public static Team toTeam(TeamDto dto) {
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        return team;
    }
}
