package fr.fgirard.tennisapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fgirard.tennisapp.domain.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

}
