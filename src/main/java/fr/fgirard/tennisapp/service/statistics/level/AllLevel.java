package fr.fgirard.tennisapp.service.statistics.level;

import java.util.List;

import fr.fgirard.tennisapp.domain.Score;

public class AllLevel extends LevelBO {

	public AllLevel(final List<Score> pScores) {
		super(pScores);
	}

	@Override
	protected List<Score> filter(final List<Score> pScores) {
		return pScores;
	}

}
