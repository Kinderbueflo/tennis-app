package fr.fgirard.tennisapp.dto;

import java.math.BigDecimal;

public class GlobalStatisticsDTO {

	private BigDecimal odds;
	private BigDecimal profitability;
	private BigDecimal winRatioAllLevel;
	private BigDecimal winRatioGrandSlamLevel;
	private BigDecimal winRatioMasterLevel;
	private BigDecimal winRatioATPLevel;
	
	public GlobalStatisticsDTO() {
		super();
	}
	
	public GlobalStatisticsDTO(final BigDecimal odds,
			final BigDecimal profitability,
			final BigDecimal winRatioAllLevel,
			final BigDecimal winRatioGrandSlamLevel,
			final BigDecimal winRatioMasterLevel,
			final BigDecimal winRatioATPLevel) {
		super();
		this.odds = odds;
		this.profitability = profitability;
		this.winRatioAllLevel = winRatioAllLevel;
		this.winRatioGrandSlamLevel = winRatioGrandSlamLevel;
		this.winRatioMasterLevel = winRatioMasterLevel;
		this.winRatioATPLevel = winRatioATPLevel;
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

	public void setOdds(final BigDecimal odds) {
		this.odds = odds;
	}

	public void setProfitability(final BigDecimal profitability) {
		this.profitability = profitability;
	}

	public void setWinRatioAllLevel(final BigDecimal winRatioAllLevel) {
		this.winRatioAllLevel = winRatioAllLevel;
	}

	public void setWinRatioGrandSlamLevel(final BigDecimal winRatioGrandSlamLevel) {
		this.winRatioGrandSlamLevel = winRatioGrandSlamLevel;
	}

	public void setWinRatioMasterLevel(final BigDecimal winRatioMasterLevel) {
		this.winRatioMasterLevel = winRatioMasterLevel;
	}

	public void setWinRatioATPLevel(final BigDecimal winRatioATPLevel) {
		this.winRatioATPLevel = winRatioATPLevel;
	}

	@Override
	public String toString() {
		return "GlobalStatisticsDTO "
				+ "[odds=" + this.odds 
				+ ", profitability=" + this.profitability 
				+ ", winRatioAllLevel="	+ this.winRatioAllLevel 
				+ ", winRatioGrandSlamLevel=" + this.winRatioGrandSlamLevel 
				+ ", winRatioMasterLevel=" + this.winRatioMasterLevel 
				+ ", winRatioATPLevel=" + this.winRatioATPLevel + "]";
	}
	
	
}
