package fr.fgirard.tennisapp.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fgirard.tennisapp.domain.Player;
import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.repository.PlayerRepository;
import fr.fgirard.tennisapp.repository.ScoreRepository;
import fr.fgirard.tennisapp.service.ProfitService;
import fr.fgirard.tennisapp.service.bo.ProfitBO;
import fr.fgirard.tennisapp.service.statistics.period.ConstantsPeriod;

@Service("ratioService")
public class ProfitServiceImpl implements ProfitService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Override
	public List<ProfitBO> getProfits(final String period) {
		
		final Integer month = this.getMonth(period);
		final List<Player> players = this.playerRepository.findAll();
		final List<ProfitBO> profits = new ArrayList<>();
		
		for (final Player player : players) {
			final List<Score> scores = this.getScores(player, month);
			if (scores != null && !scores.isEmpty()) {
				profits.add(this.createProfit(player, scores));
			}
		}
		Collections.sort(profits, (p1, p2) -> {
			return p2.getProfit().compareTo(p1.getProfit());
		});
		
		for (final ProfitBO profit : profits) {
			profit.setRanking(profits.indexOf(profit) + 1);
		}
		return profits;
	}


	private Integer getMonth(final String period) {
		switch (period) {
		case ConstantsPeriod.SIX_MONTH:
			return 6;
		case ConstantsPeriod.ONE_YEAR:
			return 12;
		case ConstantsPeriod.TWO_YEAR:
			return 24;
		case ConstantsPeriod.ALL_PERIOD:
			return 0;	
		default:
			return 0;
		}
	}
	
	private List<Score> getScores(final Player player, final Integer month) {
		List<Score> scores = this.scoreRepository.findByPlayerId(player.getPlayerId());
		if (scores != null && !scores.isEmpty() && month != 0) {
			final LocalDate date = LocalDate.now().minusMonths(month);
			scores = scores.stream()
					.filter(score -> score.getMatchDate().isAfter(date))
					.collect(Collectors.toList());
		}
		
		return scores;
	}
	
	private ProfitBO createProfit(final Player player, final List<Score> scores) {
		final ProfitBO profit = new ProfitBO();
		profit.setPlayer(player.getName());
		profit.setNumberOfMatchs(scores.size());
		profit.setOddsAverage(this.calculateOddsAverage(scores));
		profit.setProfitability(this.calculateProfitability(profit.getOddsAverage()));
		profit.setRatio(this.calculateWinRatio(scores));
		profit.setDifference(this.calculateDifference(profit));
		profit.setProfit(this.calculateProfit(scores));
		return profit;
	}
	
	private BigDecimal calculateOddsAverage(final List<Score> scores) {
		BigDecimal sumOdds = BigDecimal.ZERO;
		for (final Score score : scores) {
			sumOdds = sumOdds.add(score.getOdds());
		}
		return sumOdds.divide(BigDecimal.valueOf(scores.size()), 2 , RoundingMode.HALF_UP);
	}
	
	private BigDecimal calculateWinRatio(final List<Score> scores) {
		BigDecimal sumVictory = BigDecimal.ZERO;
		for (final Score score : scores) {
			if (score.isVictory()) {
				sumVictory = sumVictory.add(BigDecimal.ONE);
			}
		}
		return (sumVictory.divide(BigDecimal.valueOf(scores.size()), 4, RoundingMode.HALF_UP))
				.multiply(BigDecimal.valueOf(100))
				.setScale(2, RoundingMode.HALF_UP);
	}
	
	private BigDecimal calculateProfitability(final BigDecimal oddsAverage) {
		return (BigDecimal.ONE.divide(oddsAverage, 4, RoundingMode.HALF_UP))
				.multiply(BigDecimal.valueOf(100))
				.setScale(2, RoundingMode.HALF_UP);
	}
	
	private BigDecimal calculateDifference(final ProfitBO profit) {
		return profit.getRatio().subtract(profit.getProfitability());
	}
	
	private BigDecimal calculateProfit(final List<Score> scores) {
		BigDecimal profit = BigDecimal.ZERO;
		for (final Score score : scores) {
			if (score.isVictory()) {
				profit = profit
						.add(score.getOdds().multiply(BigDecimal.TEN))
						.subtract(BigDecimal.TEN)
						.setScale(2);
			} else {
				profit = profit
						.subtract(BigDecimal.TEN)
						.setScale(2);
			}
		}
		return profit;
	}

}
