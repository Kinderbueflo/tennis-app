package fr.fgirard.tennisapp.dto.mapper;

import fr.fgirard.tennisapp.dto.PeriodDTO;
import fr.fgirard.tennisapp.service.statistics.period.PeriodBO;

public final class PeriodMapper {

	public static final PeriodDTO mapper(final PeriodBO periodBO) {
		PeriodDTO periodDTO = null;
		if (periodBO != null && allLevelPresent(periodBO)) {
			periodDTO = new PeriodDTO();
			periodDTO.setAll(LevelMapper.mapper(periodBO.getAllLevelBO()));
			periodDTO.setAtp(LevelMapper.mapper(periodBO.getAtpBO()));
			periodDTO.setGrandSlam(LevelMapper.mapper(periodBO.getGrandSlamBO()));
			periodDTO.setMasters(LevelMapper.mapper(periodBO.getMastersBO()));
			if (allLevelNull(periodDTO)) {
				periodDTO = null;
			}
		}
		return periodDTO;
	}
		
	private static final boolean allLevelPresent(final PeriodBO periodBO) {
		return periodBO.getAllLevelBO() != null;
	}
	
	private static final boolean allLevelNull(final PeriodDTO periodDTO) {
		return periodDTO.getAll() == null;
	}
}
