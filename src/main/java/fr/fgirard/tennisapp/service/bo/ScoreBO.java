package fr.fgirard.tennisapp.service.bo;

public class ScoreBO {

	public Integer victory;
	public Integer total;
	
	public ScoreBO(final Integer total, final Integer victory) {
		this.victory = victory;
		this.total = total;
	}

	public Integer getVictory() {
		return this.victory;
	}

	public Integer getTotal() {
		return this.total;
	}
	
	@Override
	public String toString() {
		return "ScoreBO [victory=" + this.victory + ", total=" + this.total + "]";
	}	
	
}
