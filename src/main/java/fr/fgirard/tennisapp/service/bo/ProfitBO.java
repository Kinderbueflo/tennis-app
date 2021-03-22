package fr.fgirard.tennisapp.service.bo;

import java.math.BigDecimal;

public class ProfitBO {

	private BigDecimal oddsAverage;
	private BigDecimal profitability;
	private BigDecimal ratio;
	private BigDecimal difference;
	private BigDecimal profit;
	private Integer ranking;
	private Integer numberOfMatchs;
	private String player;
	
	public ProfitBO() {
		super();
	}
	
	public BigDecimal getOddsAverage() {
		return this.oddsAverage;
	}
	
	public BigDecimal getProfitability() {
		return this.profitability;
	}

	public BigDecimal getRatio() {
		return this.ratio;
	}
	
	public BigDecimal getDifference() {
		return this.difference;
	}
	
	public BigDecimal getProfit() {
		return this.profit;
	}

	public Integer getRanking() {
		return this.ranking;
	}
	
	public Integer getNumberOfMatchs() {
		return this.numberOfMatchs;
	}

	public String getPlayer() {
		return this.player;
	}

	public void setOddsAverage(final BigDecimal oddsAverage) {
		this.oddsAverage = oddsAverage;
	}
	
	public void setProfitability(final BigDecimal profitability) {
		this.profitability = profitability;
	}

	public void setRatio(final BigDecimal ratio) {
		this.ratio = ratio;
	}

	public void setDifference(final BigDecimal difference) {
		this.difference = difference;
	}
	
	public void setProfit(final BigDecimal profit) {
		this.profit = profit;
	}

	public void setRanking(final Integer ranking) {
		this.ranking = ranking;
	}

	public void setPlayer(final String player) {
		this.player = player;
	}
	
	public void setNumberOfMatchs(final Integer numberOfMatchs) {
		this.numberOfMatchs = numberOfMatchs;
	}

	@Override
	public String toString() {
		return "RatioDTO [oddsAverage=" + this.oddsAverage 
				+ ", profitability=" + this.profitability
				+ ", ratio=" + this.ratio 
				+ ", difference=" + this.difference
				+ ", profit=" + this.profit
				+ ", ranking=" + this.ranking 
				+ ", numberOfMatchs=" + this.numberOfMatchs
				+ ", player=" + this.player + "]";
	}
	
}
