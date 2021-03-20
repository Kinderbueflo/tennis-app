package fr.fgirard.tennisapp.service.bo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GlobalStatisticsBO {

	private BigDecimal odds;
	private BigDecimal profitability;
	private BigDecimal winRatioAllLevel;
	private BigDecimal winRatioGrandSlamLevel;
	private BigDecimal winRatioMasterLevel;
	private BigDecimal winRatioATPLevel;
	
	public GlobalStatisticsBO() {
		throw new RuntimeException("Use the params contructor");
	}
	
	public GlobalStatisticsBO(final BigDecimal pOdds) {
		this.odds = pOdds;
		this.setProfitability();
	}

	public BigDecimal getOdds() {
		return this.odds;
	}

	public BigDecimal getProfitability() {
		return this.profitability;
	}

	public BigDecimal getWinRatioAllLevel() {
		return this.winRatioAllLevel;
	}

	public BigDecimal getWinRatioGrandSlamLevel() {
		return this.winRatioGrandSlamLevel;
	}

	public BigDecimal getWinRatioMasterLevel() {
		return this.winRatioMasterLevel;
	}

	public BigDecimal getWinRatioATPLevel() {
		return this.winRatioATPLevel;
	}

	public void setProfitability() {
		this.profitability = (BigDecimal.ONE.divide(this.odds, 4, RoundingMode.HALF_UP))
				.multiply(BigDecimal.valueOf(100))
				.setScale(2, RoundingMode.HALF_UP);
	}

	public void setWinRatioAllLevel(final ScoreBO pScore) {
		this.winRatioAllLevel = this.calculateRatio(pScore);
	}

	public void setWinRatioGrandSlamLevel(final ScoreBO pScore) {
		this.winRatioGrandSlamLevel = this.calculateRatio(pScore);
	}

	public void setWinRatioMasterLevel(final ScoreBO pScore) {
		this.winRatioMasterLevel = this.calculateRatio(pScore);
	}

	public void setWinRatioATPLevel(final ScoreBO pScore) {
		this.winRatioATPLevel = this.calculateRatio(pScore);
	}
	
	private BigDecimal calculateRatio(final ScoreBO pScore) {
		return (BigDecimal.valueOf(pScore.getVictory())
				.divide(BigDecimal.valueOf(pScore.getTotal()), 4, RoundingMode.HALF_UP))
				.multiply(BigDecimal.valueOf(100)).setScale(2);
	}
	
}
