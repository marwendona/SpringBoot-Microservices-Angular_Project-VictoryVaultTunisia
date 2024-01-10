package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.entity.Standing;

@RepositoryRestResource
public interface StandingRepository extends JpaRepository<Standing, Long> {
}
