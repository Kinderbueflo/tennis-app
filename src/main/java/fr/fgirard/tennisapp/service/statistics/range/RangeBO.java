package fr.fgirard.tennisapp.service.statistics.range;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.service.statistics.surface.AllSurface;
import fr.fgirard.tennisapp.service.statistics.surface.Clay;
import fr.fgirard.tennisapp.service.statistics.surface.Grass;
import fr.fgirard.tennisapp.service.statistics.surface.Hard;
import fr.fgirard.tennisapp.service.statistics.surface.SurfaceBO;

public class RangeBO {

	private final BigDecimal lowOdds;
	private final BigDecimal highOdds;
	private SurfaceBO clay;
	private SurfaceBO grass;
	private SurfaceBO hard;
	private SurfaceBO all;
	private BigDecimal winRatioAllPlayer;
	
	public RangeBO(final BigDecimal pLowOdds, final BigDecimal pHighOdds, final List<Score> pScores) {
		this.lowOdds = pLowOdds;
		this.highOdds = pHighOdds;
		final List<Score> scores = this.filter(pScores);
		if (scores.size() > 5) {
			this.clay = new Clay(scores);
			this.grass = new Grass(scores);
			this.hard = new Hard(scores);
			this.all = new AllSurface(scores);
		}
	}
	
	private List<Score> filter(final List<Score> pScores) {
		return pScores.stream()
				.filter(score -> this.filterOdds(score.getOdds()))
				.collect(Collectors.toList());
	}
	
	private boolean filterOdds(final BigDecimal value) {
		return (this.lowOdds.compareTo(value) == 0 || this.highOdds.compareTo(value) == 0)
				|| (this.lowOdds.compareTo(value) == -1 && this.highOdds.compareTo(value) == 1);
	}

	public BigDecimal getLowOdds() {
		return this.lowOdds;
	}

	public BigDecimal getHighOdds() {
		return this.highOdds;
	}

	public SurfaceBO getClay() {
		return this.clay;
	}

	public SurfaceBO getGrass() {
		return this.grass;
	}

	public SurfaceBO getHard() {
		return this.hard;
	}

	public SurfaceBO getAll() {
		return this.all;
	}

	public BigDecimal getWinRatioAllPlayer() {
		return this.winRatioAllPlayer;
	}

	public void setWinRatioAllPlayer(final BigDecimal winRatioAllPlayer) {
		this.winRatioAllPlayer = winRatioAllPlayer;
	}
	
	
}
