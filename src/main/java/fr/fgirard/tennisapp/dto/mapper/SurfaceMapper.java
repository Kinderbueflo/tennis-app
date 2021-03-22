package fr.fgirard.tennisapp.dto.mapper;

import fr.fgirard.tennisapp.dto.SurfaceDTO;
import fr.fgirard.tennisapp.service.statistics.surface.SurfaceBO;

public final class SurfaceMapper {

	public static final SurfaceDTO mapper(final SurfaceBO surfaceBO) {
		if (surfaceBO != null && atLeastOneMatch(surfaceBO)) {
			final SurfaceDTO surfaceDTO = new SurfaceDTO();
			surfaceDTO.setNumberOfMatches(surfaceBO.getNumberOfMatches());
			surfaceDTO.setOddsAverage(surfaceBO.getOddsAverage());
			surfaceDTO.setProfitability(surfaceBO.getProfitability());
			surfaceDTO.setWinRatio(surfaceBO.getWinRatio());
			return surfaceDTO;
		}
		return null;
	}
	
	private static final boolean atLeastOneMatch(final SurfaceBO surfaceBO) {
		return surfaceBO.getNumberOfMatches() != null;
	}
}
