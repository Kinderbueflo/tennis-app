package fr.fgirard.tennisapp.dto.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.fgirard.tennisapp.dto.ProfitDTO;
import fr.fgirard.tennisapp.service.bo.ProfitBO;

public final class ProfitMapper {

	public static final List<ProfitDTO> mapper(final List<ProfitBO> profitsBO) {
		if (profitsBO == null || profitsBO.isEmpty()) {
			return null;
		}
		
		final List<ProfitDTO> profits = new ArrayList<>();
		profitsBO.stream().forEach(profitBO -> {
			final ProfitDTO profitDTO = new ProfitDTO();
			profitDTO.setOddsAverage(profitBO.getOddsAverage());
			profitDTO.setProfitability(profitBO.getProfitability());
			profitDTO.setRatio(profitBO.getRatio());
			profitDTO.setProfit(profitBO.getProfit());
			profitDTO.setRanking(profitBO.getRanking());
			profitDTO.setNumberOfMatchs(profitBO.getNumberOfMatchs());
			profitDTO.setPlayer(profitBO.getPlayer());
			profits.add(profitDTO);
		});
		
		Collections.sort(profits, (p1, p2) -> {
			return p2.getProfit().subtract(p1.getProfit()).intValue();
		});
		
		return profits;
	}
}
