package fr.fgirard.tennisapp.service.statistics.level;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.service.statistics.range.RangeBO;

public abstract class LevelBO {

	protected List<RangeBO> rangeBOs = new ArrayList<>();
	protected BigDecimal profit = BigDecimal.ZERO;
	protected BigDecimal setsPerMatch = BigDecimal.ZERO;
	protected Integer numberOfMatch;
	private Integer numberOfSets = 0;
	
	public LevelBO(final List<Score> pScores) {
		final List<Score> scores = this.filter(pScores);
		if (scores.size() > 5) {
			this.initializeProperties(scores);
			this.addRange(scores);
		}
	}
	
	protected abstract List<Score> filter(final List<Score> pScores);
	
	private void initializeProperties(final List<Score> pScores) {
		pScores.stream().forEach(score -> {
			this.calculateProfit(score);
			this.numberOfSets += score.getSetWon();
		});
		this.numberOfMatch = pScores.size();
		this.setsPerMatch = BigDecimal.valueOf(this.numberOfSets)
				.divide(BigDecimal.valueOf(this.numberOfMatch), 2, RoundingMode.HALF_UP)
				.setScale(2);
	}
	
	private void calculateProfit(final Score score) {
		if (score.isVictory()) {
			this.profit = this.profit
					.add(score.getOdds().multiply(BigDecimal.TEN))
					.subtract(BigDecimal.TEN)
					.setScale(2);
		} else {
			this.profit = this.profit
					.subtract(BigDecimal.TEN)
					.setScale(2);
		}
	}
	
	private void addRange(final List<Score> scores) {
		this.rangeBOs.add(new RangeBO(BigDecimal.ONE, BigDecimal.valueOf(1.30), scores));
		this.rangeBOs.add(new RangeBO(BigDecimal.valueOf(1.30), BigDecimal.valueOf(1.60), scores));
		this.rangeBOs.add(new RangeBO(BigDecimal.valueOf(1.60), BigDecimal.valueOf(2.00), scores));
		this.rangeBOs.add(new RangeBO(BigDecimal.valueOf(1.60), BigDecimal.valueOf(2.40), scores));
		this.rangeBOs.add(new RangeBO(BigDecimal.valueOf(2.00), BigDecimal.valueOf(2.40), scores));
		this.rangeBOs.add(new RangeBO(BigDecimal.valueOf(2.00), BigDecimal.valueOf(3.00), scores));
		this.rangeBOs.add(new RangeBO(BigDecimal.valueOf(3.00), BigDecimal.valueOf(5.00), scores));
		this.rangeBOs.add(new RangeBO(BigDecimal.valueOf(3.00), BigDecimal.valueOf(1000), scores));
		this.rangeBOs.add(new RangeBO(BigDecimal.valueOf(5.00), BigDecimal.valueOf(1000), scores));
	}

	public List<RangeBO> getRangeBOs() {
		return this.rangeBOs;
	}

	public BigDecimal getProfit() {
		return this.profit;
	}

	public BigDecimal getSetsPerMatch() {
		return this.setsPerMatch;
	}

	public Integer getNumberOfMatch() {
		return this.numberOfMatch;
	}
			
}
