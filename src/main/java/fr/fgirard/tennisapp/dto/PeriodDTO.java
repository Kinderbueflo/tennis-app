package fr.fgirard.tennisapp.dto;

public class PeriodDTO {

	private LevelDTO grandSlam;
	private LevelDTO masters;
	private LevelDTO atp;
	private LevelDTO all;
	
	public PeriodDTO() {
		super();
	}
	
	public PeriodDTO(final LevelDTO pGrandSlam,
			final LevelDTO pMasters,
			final LevelDTO pAtp,
			final LevelDTO pAll) {
		
		this.grandSlam = pGrandSlam;
		this.masters = pMasters;
		this.atp = pAtp;
		this.all = pAll;
	}

	public LevelDTO getGrandSlam() {
		return this.grandSlam;
	}

	public LevelDTO getMasters() {
		return this.masters;
	}

	public LevelDTO getAtp() {
		return this.atp;
	}

	public LevelDTO getAll() {
		return this.all;
	}
	
	public void setGrandSlam(final LevelDTO grandSlam) {
		this.grandSlam = grandSlam;
	}

	public void setMasters(final LevelDTO masters) {
		this.masters = masters;
	}

	public void setAtp(final LevelDTO atp) {
		this.atp = atp;
	}

	public void setAll(final LevelDTO all) {
		this.all = all;
	}

	@Override
	public String toString() {
		return "PeriodDTO ["
				+ "grandSlam=" + this.grandSlam 
				+ ", masters=" + this.masters 
				+ ", atp=" + this.atp 
				+ ", all=" + this.all + "]";
	}
	
}
