package fr.fgirard.tennisapp.dto.mapper;

import fr.fgirard.tennisapp.dto.LevelDTO;
import fr.fgirard.tennisapp.service.statistics.level.LevelBO;

public final class LevelMapper {

	public static final LevelDTO mapper(final LevelBO levelBO) {
		if (levelBO != null && isFilled(levelBO)) {
			final LevelDTO levelDTO = new LevelDTO();
			levelDTO.setProfit(levelBO.getProfit());
			levelDTO.setSetsPerMatch(levelBO.getSetsPerMatch());
			levelDTO.setNumberOfMatch(levelBO.getNumberOfMatch());
			levelDTO.setRanges(RangeMapper.mapper(levelBO.getRangeBOs()));
			return levelDTO;
		}
		return null;
	}
	
	private static final boolean isFilled(final LevelBO levelBO) {
		return levelBO.getRangeBOs() != null 
				&& !levelBO.getRangeBOs().isEmpty();
	}
}
