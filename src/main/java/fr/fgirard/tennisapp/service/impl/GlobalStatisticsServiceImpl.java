package fr.fgirard.tennisapp.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fgirard.tennisapp.repository.ScoreRepository;
import fr.fgirard.tennisapp.service.GlobalStatisticsService;
import fr.fgirard.tennisapp.service.bo.GlobalStatisticsBO;
import fr.fgirard.tennisapp.service.bo.ScoreBO;
import fr.fgirard.tennisapp.service.statistics.level.ConstantsLevel;

@Service("globalStatisticsService")
public class GlobalStatisticsServiceImpl implements GlobalStatisticsService{

	@Autowired
	private ScoreRepository scoreRepository;
	
	@Override
	public List<GlobalStatisticsBO> getGlobalStatistics() {

		final List<GlobalStatisticsBO> globalStatistics = new ArrayList<>();
		
		BigDecimal lowOdds = BigDecimal.valueOf(1.10);
		BigDecimal highOdds = BigDecimal.valueOf(1.30);
		
		for (int i = 0; i < 15; i++) {
			final ScoreBO masters = this.ratioByLevel(lowOdds, highOdds, ConstantsLevel.MASTERS);
			final ScoreBO grandSlam = this.ratioByTwoLevel(lowOdds, highOdds, ConstantsLevel.GRAND_SLAM, ConstantsLevel.TOUR_FINALS);
			final ScoreBO atp = this.ratioByTwoLevel(lowOdds, highOdds, ConstantsLevel.ATP_250, ConstantsLevel.ATP_500);
			final ScoreBO all = this.ratioAllLevel(masters, grandSlam, atp);
			final BigDecimal odds = (lowOdds.add(highOdds)).divide(BigDecimal.valueOf(2).setScale(2));
			final GlobalStatisticsBO global = new GlobalStatisticsBO(odds);
			global.setWinRatioAllLevel(all);
			global.setWinRatioGrandSlamLevel(grandSlam);
			global.setWinRatioMasterLevel(masters);
			global.setWinRatioATPLevel(atp);
			globalStatistics.add(global);
			
			lowOdds = lowOdds.add(BigDecimal.valueOf(0.20));
			highOdds = highOdds.add(BigDecimal.valueOf(0.20));
		}
		return globalStatistics;
	}
	
	private ScoreBO ratioAllLevel(final ScoreBO masters, final ScoreBO grandSlam, final ScoreBO atp) {
		final Integer total =  masters.getTotal() + grandSlam.getTotal() + atp.getTotal();
		final Integer victory = masters.getVictory() + grandSlam.getVictory() + atp.getVictory();
		return new ScoreBO(total, victory);
	}
	
	private ScoreBO ratioByLevel(final BigDecimal lowOdds, final BigDecimal highOdds, final String level) {
		final Map<String, BigInteger> map = this.scoreRepository.countVictoryByLevel(lowOdds, highOdds, level);
		final Integer total =  map.get("total").intValue();
		final Integer victory = map.get("victory").intValue();
		return new ScoreBO(total, victory);
	}
	
	private ScoreBO ratioByTwoLevel(final BigDecimal lowOdds, final BigDecimal highOdds, final String levelOne, final String levelTwo) {
		final Map<String, BigInteger> map = this.scoreRepository.countVictoryWithTwoLevel(lowOdds, highOdds, levelOne, levelTwo);
		final Integer total =  map.get("total").intValue();
		final Integer victory = map.get("victory").intValue();
		return new ScoreBO(total, victory);
	}
	
}
