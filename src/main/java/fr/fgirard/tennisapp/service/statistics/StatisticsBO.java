package fr.fgirard.tennisapp.service.statistics;

import java.util.ArrayList;
import java.util.List;

import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.service.statistics.period.AllTime;
import fr.fgirard.tennisapp.service.statistics.period.OneYear;
import fr.fgirard.tennisapp.service.statistics.period.PeriodBO;
import fr.fgirard.tennisapp.service.statistics.period.SixMonth;
import fr.fgirard.tennisapp.service.statistics.period.TwoYear;

public class StatisticsBO {

	private final String playerName;
	private Integer defeatsInRow;
	private final PeriodBO sixMonthBO;
	private final PeriodBO oneYearBO;
	private final PeriodBO twoYearBO;
	private final PeriodBO allTimeBO;
	
	public StatisticsBO() {
		throw new RuntimeException("Use the params contructor");
	}
	
	public StatisticsBO(final List<Score> pScores) {
		this.playerName = pScores.get(0).getPlayer().getName();
		this.sixMonthBO = new SixMonth(pScores);
		this.oneYearBO = new OneYear(pScores);
		this.twoYearBO = new TwoYear(pScores);
		this.allTimeBO = new AllTime(pScores);
	}
	
	public String getPlayerName() {
		return this.playerName;
	}

	public PeriodBO getSixMonthBO() {
		return this.sixMonthBO;
	}

	public PeriodBO getOneYearBO() {
		return this.oneYearBO;
	}

	public PeriodBO getTwoYearBO() {
		return this.twoYearBO;
	}

	public PeriodBO getAllTimeBO() {
		return this.allTimeBO;
	}
	
	public Integer getDefeatsInRow() {
		return this.defeatsInRow;
	}
	
	public List<PeriodBO> getPeriods() {
		final List<PeriodBO> periods = new ArrayList<>();
		periods.add(this.allTimeBO);
		periods.add(this.oneYearBO);
		periods.add(this.sixMonthBO);
		periods.add(this.twoYearBO);
		return periods;
	}

	public void setDefeatsInRow(final List<Score> pScores) {
		pScores.sort((scoreOne, scoreTwo) -> scoreOne.getMatchDate().compareTo(scoreTwo.getMatchDate()));
		this.countDefeatsInRow(pScores);
	}
	
	public void countDefeatsInRow(final List<Score> pScores) {
		int countDefeatsInRow = 0;
		int maxDefeatsInRow = 0;
		
		for (final Score score : pScores) {
			if (score.isVictory()) {
				if (countDefeatsInRow > maxDefeatsInRow) {
					maxDefeatsInRow = countDefeatsInRow;
				}
				countDefeatsInRow = 0;
			} 
			else {
				countDefeatsInRow += 1;
			}
		}
		if (countDefeatsInRow > maxDefeatsInRow) {
			maxDefeatsInRow = countDefeatsInRow;
		}
		this.defeatsInRow = maxDefeatsInRow;
	}

}
