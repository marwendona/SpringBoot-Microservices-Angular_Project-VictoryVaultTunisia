package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.entity.Coach;

@RepositoryRestResource
public interface CoachRepository extends JpaRepository<Coach, Long> {
}
