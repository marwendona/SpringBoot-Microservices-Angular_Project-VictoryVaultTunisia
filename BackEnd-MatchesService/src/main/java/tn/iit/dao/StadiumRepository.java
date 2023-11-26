package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.dto.StadiumDto;

@RepositoryRestResource
public interface StadiumRepository extends JpaRepository<StadiumDto, Long> {
}
