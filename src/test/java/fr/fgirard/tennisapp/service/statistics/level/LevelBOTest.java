package fr.fgirard.tennisapp.service.statistics.level;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.service.statistics.TestUtils;

public class LevelBOTest {

	@Test
	public void testProfitAndSetsOK() {
		final List<Score> scores = new ArrayList<>();
		scores.add(TestUtils.createScore(LocalDate.of(2030, 1, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 2, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 3, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 4, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 5, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 12, 1), false, 1));
		
		final LevelBO levels = new AllLevel(scores);
		final LevelBO slams = new GrandSlam(scores);
		final LevelBO atp = new ATP(scores);
		
		Assertions.assertEquals(BigDecimal.valueOf(-15).setScale(2), levels.getProfit());
		Assertions.assertEquals(BigDecimal.valueOf(-15).setScale(2), slams.getProfit());
		Assertions.assertEquals(BigDecimal.ZERO, atp.getProfit());
		Assertions.assertEquals(BigDecimal.ZERO, atp.getSetsPerMatch());
	}
	
	@Test
	public void testProfitAllFalse() {
		final List<Score> scores = new ArrayList<>();
		scores.add(TestUtils.createScore(LocalDate.of(2030, 1, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 2, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 3, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 4, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 5, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 12, 1), false, 1));
		
		final LevelBO levels = new AllLevel(scores);
		final LevelBO slams = new GrandSlam(scores);
		final LevelBO atp = new ATP(scores);
		
		Assertions.assertEquals(BigDecimal.valueOf(-60).setScale(2), levels.getProfit());
		Assertions.assertEquals(BigDecimal.valueOf(-60).setScale(2), slams.getProfit());
		Assertions.assertEquals(BigDecimal.ZERO, atp.getProfit());
		Assertions.assertEquals(BigDecimal.ZERO, atp.getSetsPerMatch());
	}

	@Test
	public void testProfitAllTrue() {
		final List<Score> scores = new ArrayList<>();
		scores.add(TestUtils.createScore(LocalDate.of(2030, 1, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 2, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 3, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 4, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 5, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 12, 1), true, 1));
		
		final LevelBO levels = new AllLevel(scores);
		final LevelBO slams = new GrandSlam(scores);
		final LevelBO atp = new ATP(scores);
		
		Assertions.assertEquals(BigDecimal.valueOf(30).setScale(2), levels.getProfit());
		Assertions.assertEquals(BigDecimal.valueOf(30).setScale(2), slams.getProfit());
		Assertions.assertEquals(BigDecimal.ZERO, atp.getProfit());
		Assertions.assertEquals(BigDecimal.ZERO, atp.getSetsPerMatch());
	}


}
