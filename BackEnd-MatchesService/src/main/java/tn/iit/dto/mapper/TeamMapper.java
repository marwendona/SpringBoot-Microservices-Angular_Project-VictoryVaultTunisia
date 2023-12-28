package tn.iit.dto.mapper;

import tn.iit.dto.TeamDto;
import tn.iit.entity.Team;

public class TeamMapper {

    public static TeamDto toTeamDto(Team team) {
        return TeamDto.builder().
                id(team.getId()).
                name(team.getName()).
                coachId(team.getCoach().getId()).
                lineups(team.getLineups().stream().map(LineupMapper::toLineupDto).toList()).
                players(team.getPlayers().stream().map(PlayerMapper::toPlayerDto).toList()).
                build();
    }
    public static Team toTeam(TeamDto dto) {
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        team.setPlayers(dto.getPlayers().stream().map(PlayerMapper::toPlayer).toList());
        team.setLineups(dto.getLineups().stream().map(LineupMapper::toLineup).toList());
        return team;
    }
}
