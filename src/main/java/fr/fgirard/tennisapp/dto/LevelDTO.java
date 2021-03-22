package fr.fgirard.tennisapp.dto;

import java.math.BigDecimal;
import java.util.List;

public class LevelDTO {

	private BigDecimal profit;
	private BigDecimal setsPerMatch;
	private Integer numberOfMatch;
	private List<RangeDTO> ranges;
	
	public LevelDTO() {
		super();
	}
	
	public LevelDTO(final BigDecimal profit, 
			final BigDecimal setsPerMatch, 
			final Integer numberOfMatch, 
			final List<RangeDTO> ranges) {
		super();
		this.profit = profit;
		this.setsPerMatch = setsPerMatch;
		this.numberOfMatch = numberOfMatch;
		this.ranges = ranges;
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

	public List<RangeDTO> getRanges() {
		return this.ranges;
	}

	public void setProfit(final BigDecimal profit) {
		this.profit = profit;
	}

	public void setSetsPerMatch(final BigDecimal setsPerMatch) {
		this.setsPerMatch = setsPerMatch;
	}

	public void setNumberOfMatch(final Integer numberOfMatch) {
		this.numberOfMatch = numberOfMatch;
	}

	public void setRanges(final List<RangeDTO> ranges) {
		this.ranges = ranges;
	}

	@Override
	public String toString() {
		return "LevelDTO ["
				+ "profit=" + this.profit 
				+ ", setsPerMatch=" + this.setsPerMatch 
				+ ", numberOfMatch=" + this.numberOfMatch
				+ ", ranges=" + this.ranges + "]";
	}
	
}
