package fr.fgirard.tennisapp.dto;

public class StatisticsDTO {

	private String playerName;
	private Integer defeatsInRow;
	private PeriodDTO sixMonth;
	private PeriodDTO oneYear;
	private PeriodDTO twoYear;
	private PeriodDTO all;
	
	public StatisticsDTO() {
		super();
	}
	
	public StatisticsDTO(final String pPlayerName,
			final Integer pDefeatsInRow,
			final PeriodDTO pSixMonth,
			final PeriodDTO pOneYear,
			final PeriodDTO pTwoYear,
			final PeriodDTO pAll) {
		
		this.playerName = pPlayerName;
		this.defeatsInRow = pDefeatsInRow;
		this.sixMonth = pSixMonth;
		this.oneYear = pOneYear;
		this.twoYear = pTwoYear;
		this.all = pAll;		
	}

	public String getPlayerName() {
		return this.playerName;
	}
	
	public Integer getDefeatsInRow() {
		return this.defeatsInRow;
	}

	public PeriodDTO getSixMonth() {
		return this.sixMonth;
	}

	public PeriodDTO getOneYear() {
		return this.oneYear;
	}

	public PeriodDTO getTwoYear() {
		return this.twoYear;
	}

	public PeriodDTO getAll() {
		return this.all;
	}

	public void setSixMonth(final PeriodDTO sixMonth) {
		this.sixMonth = sixMonth;
	}

	public void setOneYear(final PeriodDTO oneYear) {
		this.oneYear = oneYear;
	}

	public void setTwoYear(final PeriodDTO twoYear) {
		this.twoYear = twoYear;
	}

	public void setAll(final PeriodDTO all) {
		this.all = all;
	}
	
	public void setPlayerName(final String playerName) {
		this.playerName = playerName;
	}
	
	public void setDefeatsInRow(final Integer defeatsInRow) {
		this.defeatsInRow = defeatsInRow;
	}

	@Override
	public String toString() {
		return "StatisticsDTO ["
				+ "playerName=" + this.playerName 
				+ ", defeatsInRow=" + this.defeatsInRow 
				+ ", sixMonth=" + this.sixMonth
				+ ", oneYear=" + this.oneYear 
				+ ", twoYear=" + this.twoYear 
				+ ", all=" + this.all + "]";
	}


}
