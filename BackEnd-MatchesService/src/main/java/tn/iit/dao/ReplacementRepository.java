package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.entity.Replacement;

@RepositoryRestResource
public interface ReplacementRepository extends JpaRepository<Replacement, Long> {
}
