package be.vdab.frituurfrida.web;

import javax.validation.constraints.NotNull;

public class SausRadenForm {
	@NotNull
	private Character letter;

	public Character getLetter() {
		return letter;
	}
	public void setLetter(Character letter) {
		this.letter = letter;
	}
	
}
