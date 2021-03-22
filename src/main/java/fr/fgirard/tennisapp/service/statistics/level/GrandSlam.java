package fr.fgirard.tennisapp.service.statistics.level;

import java.util.List;
import java.util.stream.Collectors;

import fr.fgirard.tennisapp.domain.Score;

public class GrandSlam extends LevelBO {

	public GrandSlam(final List<Score> pScores) {
		super(pScores);
	}

	@Override
	protected List<Score> filter(final List<Score> pScores) {
		return pScores.stream()
				.filter(score -> ConstantsLevel.GRAND_SLAM.equals(score.getTournament().getLevel().getLevel())
						|| ConstantsLevel.TOUR_FINALS.equals(score.getTournament().getLevel().getLevel()))
				.collect(Collectors.toList());
	}

}
