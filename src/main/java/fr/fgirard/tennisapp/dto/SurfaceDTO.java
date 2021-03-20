package fr.fgirard.tennisapp.dto;

import java.math.BigDecimal;

public class SurfaceDTO {

	private Integer numberOfMatches;
	private BigDecimal oddsAverage;
	private BigDecimal profitability;
	private BigDecimal winRatio;
	
	public SurfaceDTO() {
		super();
	}
	
	public SurfaceDTO(final Integer pNumberOfMatches,
			final BigDecimal pOddsAverage,
			final BigDecimal pProfitability,
			final BigDecimal pWinRatio) {
		
		this.numberOfMatches = pNumberOfMatches;
		this.oddsAverage = pOddsAverage;
		this.profitability = pProfitability;
		this.winRatio = pWinRatio;
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

	public void setNumberOfMatches(final Integer numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}

	public void setOddsAverage(final BigDecimal oddsAverage) {
		this.oddsAverage = oddsAverage;
	}

	public void setProfitability(final BigDecimal profitability) {
		this.profitability = profitability;
	}

	public void setWinRatio(final BigDecimal winRatio) {
		this.winRatio = winRatio;
	}

	@Override
	public String toString() {
		return "SurfaceDTO [numberOfMatches=" + this.numberOfMatches 
				+ ", oddsAverage=" + this.oddsAverage 
				+ ", profitability=" + this.profitability 
				+ ", winRatio=" + this.winRatio + "]";
	}
	
	
}
