package fr.fgirard.tennisapp.service.statistics.level;

import java.util.List;
import java.util.stream.Collectors;

import fr.fgirard.tennisapp.domain.Score;

public class Masters extends LevelBO {

	public Masters(final List<Score> pScores) {
		super(pScores);
	}

	@Override
	protected List<Score> filter(final List<Score> pScores) {
		return pScores.stream()
				.filter(score -> ConstantsLevel.MASTERS.equals(score.getTournament().getLevel().getLevel()))
				.collect(Collectors.toList());
	}

}
