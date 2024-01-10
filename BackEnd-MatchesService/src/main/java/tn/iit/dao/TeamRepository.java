package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.entity.Team;

@RepositoryRestResource
public interface TeamRepository extends JpaRepository<Team, Long> {
}