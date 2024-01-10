package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.iit.entity.Match;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findAllByRoundId(Long id);
    Optional<Void> deleteByRoundId(Long id);
}
