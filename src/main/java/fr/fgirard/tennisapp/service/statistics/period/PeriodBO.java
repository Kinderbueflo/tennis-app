package fr.fgirard.tennisapp.service.statistics.period;

import java.util.ArrayList;
import java.util.List;

import fr.fgirard.tennisapp.domain.Score;
import fr.fgirard.tennisapp.service.statistics.level.ATP;
import fr.fgirard.tennisapp.service.statistics.level.AllLevel;
import fr.fgirard.tennisapp.service.statistics.level.GrandSlam;
import fr.fgirard.tennisapp.service.statistics.level.LevelBO;
import fr.fgirard.tennisapp.service.statistics.level.Masters;

public abstract class PeriodBO {

	protected LevelBO grandSlamBO;
	protected LevelBO mastersBO;
	protected LevelBO atpBO;
	protected LevelBO allLevelBO;
	
	public PeriodBO(final List<Score> pScores) {
		final List<Score> scores = this.filter(pScores);
		if (scores.size() > 5) {
			this.grandSlamBO = new GrandSlam(scores);
			this.mastersBO = new Masters(scores);
			this.atpBO = new ATP(scores);
			this.allLevelBO = new AllLevel(scores);
		}
	}
	
	protected abstract List<Score> filter(final List<Score> pScores);

	public LevelBO getGrandSlamBO() {
		return this.grandSlamBO;
	}

	public LevelBO getMastersBO() {
		return this.mastersBO;
	}

	public LevelBO getAtpBO() {
		return this.atpBO;
	}

	public LevelBO getAllLevelBO() {
		return this.allLevelBO;
	}
	
	public List<LevelBO> getLevels() {
		final List<LevelBO> levels = new ArrayList<>();
		levels.add(this.allLevelBO);
		levels.add(this.atpBO);
		levels.add(this.grandSlamBO);
		levels.add(this.mastersBO);
		return levels;
	}
	
}
