package be.vdab.frituurfrida.web;

import java.io.Serializable;

class Deur implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean open;
	private boolean metFriet;
	Deur(boolean metFriet) {
		this.metFriet = metFriet;
	}
	public boolean isOpen() {
		return open;
	}
	public void open() {
		this.open = true;
	}
	public boolean isMetFriet() {
		return metFriet;
	}
}
