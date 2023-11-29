package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.entity.Round;

@RepositoryRestResource
public interface RoundRepository extends JpaRepository<Round, Long> {
}
