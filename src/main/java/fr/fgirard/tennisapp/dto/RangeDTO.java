package fr.fgirard.tennisapp.dto;

import java.math.BigDecimal;

public class RangeDTO {

	private BigDecimal lowOdds;
	private BigDecimal highOdds;
	private BigDecimal winRatioAllPlayer;
	private SurfaceDTO clay;
	private SurfaceDTO grass;
	private SurfaceDTO hard;
	private SurfaceDTO all;
	
	public RangeDTO() {
		super();
	}
	
	public RangeDTO(final BigDecimal lowOdds, final BigDecimal highOdds, final BigDecimal winRatioAllPlayer, final SurfaceDTO clay,
			final SurfaceDTO grass, final SurfaceDTO hard, final SurfaceDTO all) {
		super();
		this.lowOdds = lowOdds;
		this.highOdds = highOdds;
		this.winRatioAllPlayer = winRatioAllPlayer;
		this.clay = clay;
		this.grass = grass;
		this.hard = hard;
		this.all = all;
	}

	public BigDecimal getLowOdds() {
		return this.lowOdds;
	}

	public BigDecimal getHighOdds() {
		return this.highOdds;
	}

	public SurfaceDTO getClay() {
		return this.clay;
	}

	public SurfaceDTO getGrass() {
		return this.grass;
	}

	public SurfaceDTO getHard() {
		return this.hard;
	}

	public SurfaceDTO getAll() {
		return this.all;
	}
	
	public BigDecimal getWinRatioAllPlayer() {
		return this.winRatioAllPlayer;
	}

	public void setLowOdds(final BigDecimal lowOdds) {
		this.lowOdds = lowOdds;
	}

	public void setHighOdds(final BigDecimal highOdds) {
		this.highOdds = highOdds;
	}

	public void setClay(final SurfaceDTO clay) {
		this.clay = clay;
	}

	public void setGrass(final SurfaceDTO grass) {
		this.grass = grass;
	}

	public void setHard(final SurfaceDTO hard) {
		this.hard = hard;
	}

	public void setAll(final SurfaceDTO all) {
		this.all = all;
	}

	public void setWinRatioAllPlayer(final BigDecimal winRatioAllPlayer) {
		this.winRatioAllPlayer = winRatioAllPlayer;
	}

	@Override
	public String toString() {
		return "RangeDTO ["
				+ "lowOdds=" + this.lowOdds 
				+ ", highOdds=" + this.highOdds 
				+ ", winRatioAllPlayer=" + this.winRatioAllPlayer
				+ ", clay=" + this.clay 
				+ ", grass=" + this.grass 
				+ ", hard=" + this.hard 
				+ ", all=" + this.all + "]";
	}
	
}
