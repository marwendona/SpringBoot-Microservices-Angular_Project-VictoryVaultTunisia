package tn.iit.dto.mapper;

import tn.iit.dto.TeamDto;
import tn.iit.entity.Lineup;
import tn.iit.entity.Player;
import tn.iit.entity.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamMapper {

    public static TeamDto toTeamDto(Team team) {
        List<Lineup> lineups = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        if (Optional.ofNullable(team.getLineups()).isPresent()) {
            lineups = team.getLineups();
        }
        if (Optional.ofNullable(team.getPlayers()).isPresent()) {
            players = team.getPlayers();
        }
        return TeamDto.builder().
                id(team.getId()).
                name(team.getName()).
                coachId(team.getCoach().getId()).
                coachFirstName(team.getCoach().getFirstName()).
                coachLastName(team.getCoach().getLastName()).
                coachNationality(team.getCoach().getNationality()).
                lineups(lineups.stream().map(LineupMapper::toLineupDto).toList()).
                players(players.stream().map(PlayerMapper::toPlayerDto).toList()).
                build();
    }

    public static Team toTeam(TeamDto dto) {
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        return team;
    }
}
