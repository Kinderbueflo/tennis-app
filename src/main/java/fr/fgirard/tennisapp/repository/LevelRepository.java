package fr.fgirard.tennisapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fgirard.tennisapp.domain.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

	public Level findByLevel(final String level);
}
