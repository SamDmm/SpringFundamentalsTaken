package be.vdab.frituurfrida.web;

import javax.validation.constraints.NotNull;

public class SausRadenForm {
	@NotNull
	private char letter;

	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
}
