package tn.iit.dto.mapper;

import tn.iit.dto.TeamDto;
import tn.iit.entity.Team;

public class TeamMapper {

    public static TeamDto toTeamDto(Team team) {
        return TeamDto.builder().
                id(team.getId()).
                name(team.getName()).
                players(team.getPlayers().stream().map(PlayerMapper::toPlayerDto).toList()).
                coach(CoachMapper.toCoachDto(team.getCoach())).
                build();
    }
    public static Team toTeam(TeamDto dto) {
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        team.setPlayers(dto.getPlayers().stream().map(PlayerMapper::toPlayer).toList());
        team.setCoach(CoachMapper.toCoach(dto.getCoach()));
        return team;
    }
}
