package fr.fgirard.tennisapp.service.statistics.range;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.service.statistics.TestUtils;
import fr.fgirard.tennisapp.service.statistics.range.RangeBO;

public class RangeBOTest {

	@Test
	public void testRangeFilter() {
		final List<Score> scores = new ArrayList<>();
		scores.add(TestUtils.createScore(LocalDate.of(2030, 1, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 2, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 3, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 4, 1), true, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 5, 1), false, 1));
		scores.add(TestUtils.createScore(LocalDate.of(2030, 12, 1), false, 1));
		
		final RangeBO rangeOne = new RangeBO(BigDecimal.ONE, BigDecimal.valueOf(1.30), scores);
		final RangeBO rangeTwo = new RangeBO(BigDecimal.valueOf(1.30), BigDecimal.valueOf(1.60), scores);
		final RangeBO rangeThree = new RangeBO(BigDecimal.valueOf(1.60), BigDecimal.valueOf(2.00), scores);
		final RangeBO rangeFour = new RangeBO(BigDecimal.valueOf(3.00), BigDecimal.valueOf(5.00), scores);
		final RangeBO rangeFive = new RangeBO(BigDecimal.valueOf(1.5), BigDecimal.valueOf(1.6), scores);
		final RangeBO rangeSix = new RangeBO(BigDecimal.valueOf(1.4), BigDecimal.valueOf(1.5), scores);
		
		Assertions.assertNull(rangeOne.getAll());
		Assertions.assertEquals(6, rangeTwo.getAll().getNumberOfMatches());
		Assertions.assertNull(rangeThree.getAll());
		Assertions.assertNull(rangeFour.getAll());
		Assertions.assertEquals(6, rangeFive.getAll().getNumberOfMatches());
		Assertions.assertEquals(6, rangeSix.getAll().getNumberOfMatches());
	}

}
