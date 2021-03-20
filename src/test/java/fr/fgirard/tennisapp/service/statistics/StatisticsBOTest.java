package fr.fgirard.tennisapp.service.statistics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.fgirard.tennisapp.domain.Score;

public class StatisticsBOTest {

	
	@Test
	public void testDefeatsInRowAllFalse() {
		final List<Score> scores = new ArrayList<>();
		scores.add(TestUtils.createScore(LocalDate.of(2020, 1, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 2, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 3, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 4, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 5, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2019, 12, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 2, 15), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2019, 11, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 6, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 7, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 8, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 9, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 10, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 11, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 12, 1), false, 1));
		
		final StatisticsBO statistics = new StatisticsBO(scores);
		statistics.setDefeatsInRow(scores);
		
		Assertions.assertEquals(15, statistics.getDefeatsInRow());
	}
	
	@Test
	public void testDefeatsInRowAllTrue() {
		final List<Score> scores = new ArrayList<>();
		scores.add(TestUtils.createScore(LocalDate.of(2020, 1, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 2, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 3, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 4, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 5, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2019, 12, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 2, 15), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2019, 11, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 6, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 7, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 8, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 9, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 10, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 11, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 12, 1), true, 1));
		
		final StatisticsBO statistics = new StatisticsBO(scores);
		statistics.setDefeatsInRow(scores);
		
		Assertions.assertEquals(0, statistics.getDefeatsInRow());
	}

	@Test
	public void testDefeatsInRowEndFalse() {
		final List<Score> scores = new ArrayList<>();
		scores.add(TestUtils.createScore(LocalDate.of(2020, 1, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 2, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 3, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 4, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 5, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2019, 12, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 2, 15), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2019, 11, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 6, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 7, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 8, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 9, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 10, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 11, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 12, 1), false, 1));
		
		final StatisticsBO statistics = new StatisticsBO(scores);
		statistics.setDefeatsInRow(scores);
		
		Assertions.assertEquals(5, statistics.getDefeatsInRow());
	}

	@Test
	public void testDefeatsInRowBeginFalse() {
		final List<Score> scores = new ArrayList<>();
		scores.add(TestUtils.createScore(LocalDate.of(2020, 1, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 2, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 3, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 4, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 5, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2019, 12, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 2, 15), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2019, 11, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 6, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 7, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 8, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 9, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 10, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 11, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 12, 1), true, 1));
		
		final StatisticsBO statistics = new StatisticsBO(scores);
		statistics.setDefeatsInRow(scores);
		
		Assertions.assertEquals(7, statistics.getDefeatsInRow());
	}
	
}
