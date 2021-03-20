package fr.fgirard.tennisapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.fgirard.tennisapp.dto.GlobalStatisticsDTO;
import fr.fgirard.tennisapp.dto.mapper.GlobalStatisticsMapper;
import fr.fgirard.tennisapp.service.GlobalStatisticsService;
import fr.fgirard.tennisapp.service.bo.GlobalStatisticsBO;

@RestController
@RequestMapping("tennis-app/global")
public class GlobalStatisticsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalStatisticsController.class);
	
	@Autowired
	private GlobalStatisticsService globalStatisticsService;
	
	@GetMapping
	public List<GlobalStatisticsDTO> init() {
		LOGGER.info("Init Global Statistics Screen");
		final List<GlobalStatisticsBO> globals = this.globalStatisticsService.getGlobalStatistics();
		return GlobalStatisticsMapper.mapper(globals);
	}
}
