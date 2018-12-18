package be.vdab.frituurfrida.entities;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class GastenboekEntry {
	private long id;
	private String naam;
	@DateTimeFormat(style = "S-")
	private LocalDateTime datum = LocalDateTime.now();
	private String bericht;
	
	public GastenboekEntry(long id, String naam, LocalDateTime datum, String bericht) {
		this.id = id;
		this.naam = naam;
		this.datum = datum;
		this.bericht = bericht;
	}
	public GastenboekEntry(String naam, String bericht) {
		this.naam = naam;
		this.bericht = bericht;
	}
	public GastenboekEntry() {
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public LocalDateTime getDatum() {
		return datum;
	}
	public String getBericht() {
		return bericht;
	}
}
