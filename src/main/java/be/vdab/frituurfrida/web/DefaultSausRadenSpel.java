package be.vdab.frituurfrida.web;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class DefaultSausRadenSpel implements SausRadenSpel, Serializable {
	private static final long serialVersionUID = 1L;
	private String sausNaam;
	private StringBuilder sausNaamMetPuntjes;
	private int verkeerdeBeurten;
	private static final int MAX_BEURTEN = 10;
	
	public String getSausNaam() {
		return sausNaam;
	}
	public int getVerkeerdeBeurten() {
		return verkeerdeBeurten;
	}
	public void setVerkeerdeBeurten(int verkeerdeBeurten) {
		this.verkeerdeBeurten = verkeerdeBeurten;
	}
	public String getSausNaamMetPuntjes() {
		return sausNaamMetPuntjes.toString();
	}
	public boolean isGewonnen() {
		return sausNaamMetPuntjes.indexOf(".") == -1;
	}
	public boolean isVerloren() {
		return verkeerdeBeurten == MAX_BEURTEN;
	}
	public static int getMAX_BEURTEN() {
		return MAX_BEURTEN;
	}
	public void reset(String sausNaam) {
		this.sausNaam = sausNaam;
		verkeerdeBeurten = 0;
		sausNaamMetPuntjes = new StringBuilder();
		for (int i = 0; i<sausNaam.length(); i++) {
			sausNaamMetPuntjes.append(".");
		}
	}
	public void doeGok(char letter) {
		if (sausNaam.contains(String.valueOf(letter))) {
			int letterIndex = sausNaam.indexOf(letter);
			do {
				sausNaamMetPuntjes.setCharAt(letterIndex, letter);
				letterIndex = sausNaam.indexOf(String.valueOf(letter), letterIndex + 1);
			} while(letterIndex != -1);
			
		} else {
			verkeerdeBeurten++;
		}
	}
}
