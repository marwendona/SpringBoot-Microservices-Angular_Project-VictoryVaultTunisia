package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.dto.PlayerInPositionDto;

@RepositoryRestResource
public interface PlayerInPositionRepository extends JpaRepository<PlayerInPositionDto, Long> {
}
