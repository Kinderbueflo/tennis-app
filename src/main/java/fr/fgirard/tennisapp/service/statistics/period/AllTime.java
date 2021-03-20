package fr.fgirard.tennisapp.service.statistics.period;

import java.util.List;

import fr.fgirard.tennisapp.domain.Score;

public class AllTime extends PeriodBO {

	public AllTime(final List<Score> pScores) {
		super(pScores);
	}

	@Override
	protected List<Score> filter(final List<Score> pScores) {
		return pScores;
	}


}
