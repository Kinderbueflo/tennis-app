package fr.fgirard.tennisapp.service.statistics.surface;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.service.statistics.TestUtils;

public class SurfaceBOTest {

	@Test
	public void testSurface() {
		final List<Score> scores = new ArrayList<>();
		scores.add(TestUtils.createScore(LocalDate.of(2020, 1, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 2, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 3, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 4, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2020, 5, 1), false, 1));
		
		final Grass grass = new Grass(scores);
		final Clay clay = new Clay(scores);
		
		Assertions.assertEquals(5, grass.getNumberOfMatches());
		Assertions.assertEquals(BigDecimal.valueOf(1.5).setScale(2), grass.getOddsAverage());
		Assertions.assertEquals(BigDecimal.valueOf(66.67).setScale(2), grass.getProfitability());
		Assertions.assertEquals(BigDecimal.valueOf(60.00).setScale(2), grass.getWinRatio());
		Assertions.assertNull(clay.getNumberOfMatches());
	}

}
