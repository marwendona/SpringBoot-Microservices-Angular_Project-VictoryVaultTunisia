package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.dto.StandingDto;

@RepositoryRestResource
public interface StandingRepository extends JpaRepository<StandingDto, Long> {
}
