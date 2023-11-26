package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.dto.TeamDto;

@RepositoryRestResource
public interface TeamRepository extends JpaRepository<TeamDto, Long> {
}
