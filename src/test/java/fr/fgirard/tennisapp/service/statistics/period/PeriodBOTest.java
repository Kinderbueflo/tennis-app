package fr.fgirard.tennisapp.service.statistics.period;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.service.statistics.StatisticsBO;
import fr.fgirard.tennisapp.service.statistics.TestUtils;

public class PeriodBOTest {

	@Test
	public void testPeriodFilter() {
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
		scores.add(TestUtils.createScore(LocalDate.of(2020, 12, 5), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 12, 3), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2018, 1, 1), false, 1));
		
		final StatisticsBO statistics = new StatisticsBO(scores);
		System.out.println(statistics);
	}

}
