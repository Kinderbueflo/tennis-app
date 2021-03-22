package fr.fgirard.tennisapp.service.statistics.surface;

import java.util.List;

import fr.fgirard.tennisapp.domain.Score;

public class AllSurface extends SurfaceBO {

	public AllSurface(final List<Score> pScores) {
		super(pScores);
	}

	@Override
	protected List<Score> filter(final List<Score> pScores) {
		return pScores;
	}




}
