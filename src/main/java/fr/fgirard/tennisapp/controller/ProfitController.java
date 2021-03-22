package fr.fgirard.tennisapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.fgirard.tennisapp.dto.ProfitDTO;
import fr.fgirard.tennisapp.dto.mapper.ProfitMapper;
import fr.fgirard.tennisapp.service.ProfitService;
import fr.fgirard.tennisapp.service.bo.ProfitBO;

@RestController
@RequestMapping("tennis-app/profit")
public class ProfitController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfitController.class);
	
	@Autowired
	private ProfitService profitService;
	
	@GetMapping("/{period}")
	public List<ProfitDTO> init(@PathVariable("period") final String period) {
		LOGGER.info("Init Ratio Screen");
		final List<ProfitBO> profitsBO = this.profitService.getProfits(period);
		return ProfitMapper.mapper(profitsBO);
	}
}
