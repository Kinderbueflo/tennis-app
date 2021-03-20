package fr.fgirard.tennisapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fgirard.tennisapp.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	public Player findByName(String name);
}
