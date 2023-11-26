package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.dto.PlayerDto;

@RepositoryRestResource
public interface PlayerRepository extends JpaRepository<PlayerDto, Long> {
}
