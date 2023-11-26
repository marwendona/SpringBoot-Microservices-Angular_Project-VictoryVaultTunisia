package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.dto.LineupDto;

@RepositoryRestResource
public interface LineupRepository extends JpaRepository<LineupDto, Long> {
}
