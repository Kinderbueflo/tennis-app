package fr.fgirard.tennisapp.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.repository.ScoreRepository;
import fr.fgirard.tennisapp.service.StatisticsService;
import fr.fgirard.tennisapp.service.bo.ScoreBO;
import fr.fgirard.tennisapp.service.statistics.StatisticsBO;
import fr.fgirard.tennisapp.service.statistics.range.RangeBO;

@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private ScoreRepository scoreRepository;
	
	private final Map<String, ScoreBO> mapScore = new HashMap<>();
	
	@Override
	public StatisticsBO getStatisticsById(final Integer id) {
		
		final List<Score> scores = this.scoreRepository.findByPlayerId(id);
		if (scores == null || scores.isEmpty() || scores.size() < 10) {
			return null;
		}
		
		final StatisticsBO statistics = new StatisticsBO(scores);
		statistics.getPeriods().stream().forEach(period -> {
			period.getLevels().stream().forEach(level -> {
				if (level != null && !level.getRangeBOs().isEmpty()) {
					level.getRangeBOs().stream().forEach(range -> {
						this.calculateWinRatioForAllPlayers(range);
					});
				}
			});
		});
		
		statistics.setDefeatsInRow(scores);
		return statistics;
	}

	private void calculateWinRatioForAllPlayers(final RangeBO range) {
		final String oddsOne = String.valueOf(range.getLowOdds());
		final String oddsTwo = String.valueOf(range.getHighOdds());
		final String odds = oddsOne + oddsTwo;
		if (this.mapScore.containsKey(odds)) {
			this.scoreAlreadyCount(range, odds);	
			return;
		}
		final Map<String, BigInteger> map = this.scoreRepository.countVictory(
				range.getLowOdds(), range.getHighOdds());
		
		final Integer total =  map.get("total").intValue();
		final Integer victory = map.get("victory").intValue();
		
		final ScoreBO scoreBO = new ScoreBO(total, victory);
		this.mapScore.put(odds, scoreBO);
		
		this.calculateRatio(range, scoreBO);
	}
	
	private void scoreAlreadyCount(final RangeBO range, final String odds) {
		final ScoreBO scoreBO = this.mapScore.get(odds);
		this.calculateRatio(range, scoreBO);
	}
	
	private void calculateRatio(final RangeBO range, final ScoreBO scoreBO) {
		final BigDecimal ratio = (BigDecimal.valueOf(scoreBO.getVictory())
				.divide(BigDecimal.valueOf(scoreBO.getTotal()), 4, RoundingMode.HALF_UP))
				.multiply(BigDecimal.valueOf(100)).setScale(2);
		
		range.setWinRatioAllPlayer(ratio);
	}
}
