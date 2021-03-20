package fr.fgirard.tennisapp.service;

import java.util.List;

import fr.fgirard.tennisapp.service.bo.GlobalStatisticsBO;

public interface GlobalStatisticsService {

	public List<GlobalStatisticsBO> getGlobalStatistics();
}
