package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.dto.MatchDto;

@RepositoryRestResource
public interface MatchRepository extends JpaRepository<MatchDto, Long> {
}
