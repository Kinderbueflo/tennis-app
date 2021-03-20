package fr.fgirard.tennisapp.service.statistics.period;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import fr.fgirard.tennisapp.domain.Score;

public class OneYear extends PeriodBO {

	public OneYear(final List<Score> pScores) {
		super(pScores);
	}

	@Override
	protected List<Score> filter(final List<Score> pScores) {
		final LocalDate date = LocalDate.now().minusYears(1);
		return pScores.stream()
				.filter(score -> score.getMatchDate().isAfter(date))
				.collect(Collectors.toList());
	}

}
