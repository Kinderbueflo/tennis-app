package fr.fgirard.tennisapp.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.fgirard.tennisapp.domain.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

	@Query("SELECT s FROM Score s "
			+ "LEFT JOIN FETCH Player p ON p.playerId = s.player "
			+ "LEFT JOIN FETCH Tournament t ON t.tournamentId = s.tournament "
			+ "LEFT JOIN FETCH Surface su ON su.surfaceId = t.surface "
			+ "WHERE p.playerId = :id")
	public List<Score> findByPlayerId(@Param("id") final Integer id);
	
	@Query("SELECT s FROM Score s "
			+ "LEFT JOIN FETCH Player p ON p.playerId = s.player "
			+ "LEFT JOIN FETCH Tournament t ON t.tournamentId = s.tournament "
			+ "LEFT JOIN FETCH Surface su ON su.surfaceId = t.surface "
			+ "WHERE p.playerId = :id "
			+ "AND s.matchDate >= :date")
	public List<Score> findByPlayerIdAndDate(
			@Param("id") final Integer id,
			@Param("date") final LocalDate date);
	
	// Native query because no UNION in JPQL
	// Alphabetics order matters
	@Query(value = "SELECT COUNT(*) AS total, "
			+ "(SELECT COUNT(*) FROM tennis_score "
			+ "WHERE tennis_score.odds BETWEEN :lowodds AND :highodds AND tennis_score.victory IS TRUE) AS victory "
			+ "FROM tennis_score "
			+ "WHERE tennis_score.odds BETWEEN :lowodds AND :highodds", 
			nativeQuery = true)
	public Map<String, BigInteger> countVictory(
			@Param("lowodds") final BigDecimal lowOdds,
			@Param("highodds") final BigDecimal highOdds);
	
	// No BETWEEN in this one
	@Query(value = "SELECT COUNT(*) AS total, "
			+ "(SELECT COUNT(*) FROM tennis_score "
			+ "LEFT JOIN tennis_tournament ON tennis_tournament.tournament_id = tennis_score.tournament "
			+ "LEFT JOIN tennis_level ON tennis_level.level_id = tennis_tournament.level "
			+ "WHERE tennis_score.odds >= :lowodds AND tennis_score.odds < :highodds "
			+ "AND tennis_score.victory IS TRUE "
			+ "AND tennis_level.level = :level) AS victory "
			+ "FROM tennis_score "
			+ "LEFT JOIN tennis_tournament ON tennis_tournament.tournament_id = tennis_score.tournament "
			+ "LEFT JOIN tennis_level ON tennis_level.level_id = tennis_tournament.level "
			+ "WHERE tennis_score.odds >= :lowodds AND tennis_score.odds < :highodds "
			+ "AND tennis_level.level = :level", 
			nativeQuery = true)
	public Map<String, BigInteger> countVictoryByLevel(
			@Param("lowodds") final BigDecimal lowOdds,
			@Param("highodds") final BigDecimal highOdds,
			@Param("level") final String level);
	
	// No BETWEEN in this one
	@Query(value = "SELECT COUNT(*) AS total, "
			+ "(SELECT COUNT(*) FROM tennis_score "
			+ "LEFT JOIN tennis_tournament ON tennis_tournament.tournament_id = tennis_score.tournament "
			+ "LEFT JOIN tennis_level ON tennis_level.level_id = tennis_tournament.level "
			+ "WHERE tennis_score.odds >= :lowodds AND tennis_score.odds < :highodds "
			+ "AND tennis_score.victory IS TRUE "
			+ "AND (tennis_level.level = :levelone OR tennis_level.level= :leveltwo)) AS victory "
			+ "FROM tennis_score "
			+ "LEFT JOIN tennis_tournament ON tennis_tournament.tournament_id = tennis_score.tournament "
			+ "LEFT JOIN tennis_level ON tennis_level.level_id = tennis_tournament.level "
			+ "WHERE tennis_score.odds >= :lowodds AND tennis_score.odds < :highodds "
			+ "AND (tennis_level.level = :levelone OR tennis_level.level= :leveltwo)", 
			nativeQuery = true)
	public Map<String, BigInteger> countVictoryWithTwoLevel(
			@Param("lowodds") final BigDecimal lowOdds,
			@Param("highodds") final BigDecimal highOdds,
			@Param("levelone") final String levelOne,
			@Param("leveltwo") final String levelTwo);
}
