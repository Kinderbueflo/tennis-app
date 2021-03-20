package fr.fgirard.tennisapp.service;

import fr.fgirard.tennisapp.service.statistics.StatisticsBO;

public interface StatisticsService {

	public StatisticsBO getStatisticsById(final Integer id);
}
