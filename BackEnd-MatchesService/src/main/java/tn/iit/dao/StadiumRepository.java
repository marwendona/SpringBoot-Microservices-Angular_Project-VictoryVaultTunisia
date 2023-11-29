package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.entity.Stadium;

@RepositoryRestResource
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
