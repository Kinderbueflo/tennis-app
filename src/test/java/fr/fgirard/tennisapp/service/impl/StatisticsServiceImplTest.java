package fr.fgirard.tennisapp.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.repository.ScoreRepository;
import fr.fgirard.tennisapp.service.StatisticsService;
import fr.fgirard.tennisapp.service.statistics.StatisticsBO;
import fr.fgirard.tennisapp.service.statistics.TestUtils;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StatisticsServiceImplTest {

	@InjectMocks
	StatisticsService statisticsService = new StatisticsServiceImpl();
	
	@Mock
	ScoreRepository scoreRepository;
	
	@Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
	
	@Test
	public void testRatioAllDefeats() {
		
		Mockito.when(this.scoreRepository.findByPlayerId(Mockito.anyInt()))
			.thenReturn(this.createScores());
		Mockito.when(this.scoreRepository.countVictory(Mockito.any(), Mockito.any()))
			.thenReturn(this.createMap(BigInteger.valueOf(15), BigInteger.valueOf(10)));
		
		final StatisticsBO statistics = this.statisticsService.getStatisticsById(1);
		
		Assertions.assertEquals(
				BigDecimal.valueOf(66.67).setScale(2), 
				statistics.getAllTimeBO().getAllLevelBO().getRangeBOs().get(0).getWinRatioAllPlayer());
	}

	public List<Score> createScores() {
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
		return scores;
	}
	
	public Map<String, BigInteger> createMap(final BigInteger valueOne, final BigInteger valueTwo) {
		final Map<String, BigInteger> map = new HashMap<>();
		map.put("total", valueOne);
		map.put("victory", valueTwo);
		return map;
	}

}
