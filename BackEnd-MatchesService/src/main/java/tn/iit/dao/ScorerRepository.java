package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.entity.Scorer;

@RepositoryRestResource
public interface ScorerRepository extends JpaRepository<Scorer, Long> {
}
