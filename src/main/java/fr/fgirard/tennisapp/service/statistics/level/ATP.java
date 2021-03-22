package fr.fgirard.tennisapp.service.statistics.level;

import java.util.List;
import java.util.stream.Collectors;

import fr.fgirard.tennisapp.domain.Score;

public class ATP extends LevelBO {

	public ATP(final List<Score> pScores) {
		super(pScores);
	}

	@Override
	protected List<Score> filter(final List<Score> pScores) {
		return pScores.stream()
				.filter(score -> ConstantsLevel.ATP_250.equals(score.getTournament().getLevel().getLevel())
						|| ConstantsLevel.ATP_500.equals(score.getTournament().getLevel().getLevel()))
				.collect(Collectors.toList());
	}

}
