package fr.fgirard.tennisapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.fgirard.tennisapp.dto.PlayerDTO;
import fr.fgirard.tennisapp.dto.StatisticsDTO;
import fr.fgirard.tennisapp.dto.mapper.StatisticsMapper;
import fr.fgirard.tennisapp.service.PlayerService;
import fr.fgirard.tennisapp.service.StatisticsService;
import fr.fgirard.tennisapp.service.statistics.StatisticsBO;

@RestController
@RequestMapping("tennis-app/statistics")
public class StatisticsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsController.class);
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private StatisticsService statisticsService;
	
	@GetMapping
	public List<PlayerDTO> init() {
		LOGGER.info("Init Tennis Statistic App");
		return this.playerService.getAllPlayers().stream()
				.map(player -> {return new PlayerDTO(player.getPlayerId(), player.getName());})
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public StatisticsDTO statisticsById(@PathVariable("id") final Integer id) {
		LOGGER.info("Gets the statistics by id");
		final StatisticsBO statisticsBO = this.statisticsService.getStatisticsById(id);
		return StatisticsMapper.mapper(statisticsBO);
	}
	
	@GetMapping("/{id1}/{id2}")
	public List<StatisticsDTO> statisticsByIds(
			@PathVariable("id1") final Integer id1, 
			@PathVariable("id2") final Integer id2) {
		LOGGER.info("Gets the statistics by ids");
		final StatisticsBO statisticsBOOne = this.statisticsService.getStatisticsById(id1);
		final StatisticsBO statisticsBOTwo = this.statisticsService.getStatisticsById(id2);
		final List<StatisticsDTO> statisticsDTOs = new ArrayList<>();
		statisticsDTOs.add(StatisticsMapper.mapper(statisticsBOOne));
		statisticsDTOs.add(StatisticsMapper.mapper(statisticsBOTwo));
		return statisticsDTOs;
	}
}
