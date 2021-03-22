package fr.fgirard.tennisapp.dto.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.fgirard.tennisapp.dto.GlobalStatisticsDTO;
import fr.fgirard.tennisapp.service.bo.GlobalStatisticsBO;

public final class GlobalStatisticsMapper {

	public static final List<GlobalStatisticsDTO> mapper(final List<GlobalStatisticsBO> globalBO) {
		if (globalBO == null || globalBO.isEmpty()) {
			return null;
		}
		
		final List<GlobalStatisticsDTO> globals = new ArrayList<>();
		globalBO.stream().forEach(global -> {
			final GlobalStatisticsDTO globalDTO = new GlobalStatisticsDTO();
			globalDTO.setOdds(global.getOdds());
			globalDTO.setProfitability(global.getProfitability());
			globalDTO.setWinRatioAllLevel(global.getWinRatioAllLevel());
			globalDTO.setWinRatioATPLevel(global.getWinRatioATPLevel());
			globalDTO.setWinRatioGrandSlamLevel(global.getWinRatioGrandSlamLevel());
			globalDTO.setWinRatioMasterLevel(global.getWinRatioMasterLevel());
			globals.add(globalDTO);
		});
		
		Collections.sort(globals, (g1, g2) -> {
			return g2.getOdds().subtract(g1.getOdds()).intValue();
		});
		
		return globals;
	}
}
