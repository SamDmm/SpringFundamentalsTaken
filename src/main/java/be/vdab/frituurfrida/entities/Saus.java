package be.vdab.frituurfrida.entities;

import java.util.ArrayList;
import java.util.List;

public class Saus {
	private long nummer;
	private String naam;
	private List<String> ingredienten = new ArrayList<>();
	
	
	public Saus(long nummer, String naam) {
		this.nummer = nummer;
		this.naam = naam;
	}
	public Saus(long nummer, String naam, List<String> ingredienten) {
		this.nummer = nummer;
		this.naam = naam;
		this.ingredienten = ingredienten;
	}
	
	public long getNummer() {
		return nummer;
	}
	public String getNaam() {
		return naam;
	}
	public List<String> getIngredienten() {
		return ingredienten;
	}
	public void addIngredient(String ingredient) {
		ingredienten.add(ingredient);
	}
}
