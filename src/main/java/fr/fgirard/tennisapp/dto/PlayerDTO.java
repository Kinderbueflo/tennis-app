package fr.fgirard.tennisapp.dto;

public class PlayerDTO {

	private int id;
	private String name;
	
	public PlayerDTO(final int id, final String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}
	
}
