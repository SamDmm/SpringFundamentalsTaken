package be.vdab.frituurfrida.web;

interface SausRadenSpel {
	public void reset(String sausNaam);
	public void doeGok(char letter);
	public boolean isGewonnen();
	public boolean isVerloren();
}
