package fr.fgirard.tennisapp.dto.mapper;

import fr.fgirard.tennisapp.dto.StatisticsDTO;
import fr.fgirard.tennisapp.service.statistics.StatisticsBO;

public final class StatisticsMapper {

	public static final StatisticsDTO mapper(final StatisticsBO statisticsBO) {
		if (statisticsBO == null) {
			return null;
		}
		final StatisticsDTO statisticsDTO = new StatisticsDTO();
		statisticsDTO.setPlayerName(statisticsBO.getPlayerName());
		statisticsDTO.setDefeatsInRow(statisticsBO.getDefeatsInRow());
		statisticsDTO.setAll(PeriodMapper.mapper(statisticsBO.getAllTimeBO()));
		statisticsDTO.setTwoYear(PeriodMapper.mapper(statisticsBO.getTwoYearBO()));
		statisticsDTO.setOneYear(PeriodMapper.mapper(statisticsBO.getOneYearBO()));
		statisticsDTO.setSixMonth(PeriodMapper.mapper(statisticsBO.getSixMonthBO()));
		return statisticsDTO;
	}
}
