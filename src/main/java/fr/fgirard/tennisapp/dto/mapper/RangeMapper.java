package fr.fgirard.tennisapp.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.fgirard.tennisapp.dto.RangeDTO;
import fr.fgirard.tennisapp.service.statistics.range.RangeBO;

public final class RangeMapper {

	public static final List<RangeDTO> mapper(final List<RangeBO> rangeBOs) {
		final List<RangeDTO> rangeDTOs = new ArrayList<>();
		if (rangeBOs != null && !rangeBOs.isEmpty()) {
			rangeBOs.stream().forEach(rangeBO -> {
				if (allSurfacePresent(rangeBO)) {
					final RangeDTO rangeDTO = new RangeDTO();
					rangeDTO.setLowOdds(rangeBO.getLowOdds());
					rangeDTO.setHighOdds(rangeBO.getHighOdds());
					rangeDTO.setAll(SurfaceMapper.mapper(rangeBO.getAll()));
					rangeDTO.setClay(SurfaceMapper.mapper(rangeBO.getClay()));
					rangeDTO.setGrass(SurfaceMapper.mapper(rangeBO.getGrass()));
					rangeDTO.setHard(SurfaceMapper.mapper(rangeBO.getHard()));
					rangeDTO.setWinRatioAllPlayer(rangeBO.getWinRatioAllPlayer());
					rangeDTOs.add(rangeDTO);
				}
			});
		}
		return rangeDTOs.isEmpty() ? null : rangeDTOs;
	}
	
	private static final boolean allSurfacePresent(final RangeBO rangeBO) {
		return rangeBO != null && rangeBO.getAll() != null;
	}
}
