package fr.fgirard.tennisapp.service.statistics;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

import fr.fgirard.tennisapp.domain.Level;
import fr.fgirard.tennisapp.domain.Player;
import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.domain.Surface;
import fr.fgirard.tennisapp.domain.Tournament;
import fr.fgirard.tennisapp.service.statistics.level.ConstantsLevel;
import fr.fgirard.tennisapp.service.statistics.surface.ConstantsSurface;

public final class TestUtils {

	public static final Score createScore(final LocalDate date, final boolean victory, final int value) {
		final Score score = new Score();
		score.setMatchDate(date);
		score.setVictory(victory);
		score.setPlayer(createPlayer(value));
		score.setTournament(createTournament());
		score.setOdds(BigDecimal.valueOf(1.5));
		score.setSetWon(new Random().nextInt(3));
		return score;
	}
	
	public static final Player createPlayer(final int value) {
		final Player player = new Player();
		if (value == 1) {
			player.setName("Djokovic N.");
		}
		return player;
	}
	
	public static final Tournament createTournament() {
		final Tournament tournament = new Tournament();
		tournament.setLevel(createLevel());
		tournament.setSurface(createSurface());
		return tournament;
	}
	
	public static final Level createLevel() {
		final Level level = new Level();
		level.setLevel(ConstantsLevel.GRAND_SLAM);
		return level;
	}
	
	public static final Surface createSurface() {
		final Surface surface = new Surface();
		surface.setSurface(ConstantsSurface.GRASS);
		return surface;
	}
}
