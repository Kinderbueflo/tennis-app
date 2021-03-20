package fr.fgirard.tennisapp.service.statistics.surface;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import fr.fgirard.tennisapp.domain.Score;

public abstract class SurfaceBO {

	private Integer numberOfMatches;
	private BigDecimal oddsAverage;
	private BigDecimal profitability;
	private BigDecimal winRatio;
	
	public SurfaceBO(final List<Score> pScores) {
		final List<Score> score = this.filter(pScores);
		if (score != null && !score.isEmpty()) {
			this.calculateNumberOfMatch(score);
			this.calculateOddsAverage(score);
			this.calculateProfitability(score);
			this.calculateWinRatio(score);
		}
	}

	protected abstract List<Score> filter(final List<Score> pScores);
	
	private void calculateNumberOfMatch(final List<Score> pScores) {
		this.numberOfMatches = pScores.size();
	}
	
	private void calculateOddsAverage(final List<Score> pScores) {
		BigDecimal sumOdds = BigDecimal.ZERO;
		for (final Score score : pScores) {
			sumOdds = sumOdds.add(score.getOdds());
		}
		this.oddsAverage = sumOdds.divide(BigDecimal.valueOf(this.numberOfMatches), 2 , RoundingMode.HALF_UP);
	}
	
	private void calculateProfitability(final List<Score> pScores) {
		this.profitability = (BigDecimal.ONE.divide(this.oddsAverage, 4, RoundingMode.HALF_UP))
				.multiply(BigDecimal.valueOf(100))
				.setScale(2, RoundingMode.HALF_UP);
	}

	private void calculateWinRatio(final List<Score> pScores) {
		BigDecimal sumVictory = BigDecimal.ZERO;
		for (final Score score : pScores) {
			if (score.isVictory()) {
				sumVictory = sumVictory.add(BigDecimal.ONE);
			}
		}
		this.winRatio = (sumVictory.divide(BigDecimal.valueOf(this.numberOfMatches), 4, RoundingMode.HALF_UP))
				.multiply(BigDecimal.valueOf(100))
				.setScale(2, RoundingMode.HALF_UP);
	}

	public Integer getNumberOfMatches() {
		return this.numberOfMatches;
	}

	public BigDecimal getOddsAverage() {
		return this.oddsAverage;
	}

	public BigDecimal getProfitability() {
		return this.profitability;
	}

	public BigDecimal getWinRatio() {
		return this.winRatio;
	}
	
}
