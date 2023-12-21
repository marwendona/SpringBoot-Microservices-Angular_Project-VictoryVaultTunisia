package tn.iit.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import tn.iit.dto.TeamDto;
import tn.iit.entity.Team;
import tn.iit.service.CoachService;

public class TeamMapper {

    private static CoachService coachService;

    public TeamMapper(CoachService coachService) {
        TeamMapper.coachService = coachService;
    }

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
        team.setPlayers(dto.getPlayers().stream().map(PlayerMapper::toPlayer).toList());
        team.setCoach(coachService.getCoachById(dto.getCoachId()));
        return team;
    }
}
