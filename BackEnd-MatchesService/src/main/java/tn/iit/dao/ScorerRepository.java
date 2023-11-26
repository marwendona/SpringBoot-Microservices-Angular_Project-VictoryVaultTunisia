package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.dto.ScorerDto;

@RepositoryRestResource
public interface ScorerRepository extends JpaRepository<ScorerDto, Long> {
}
