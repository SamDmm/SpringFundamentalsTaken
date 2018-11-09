package be.vdab.frituurfrida.valueobjects;

public class Gemeente {
	private String postCode;
	private String naam;
	
	public Gemeente(String postCode, String naam) {
		this.naam = naam;
		this.postCode = postCode;
	}
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	
}
