package be.vdab.frituurfrida.web;

import java.io.Serializable;

class Deur implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean open;
	private boolean metFriet;
	Deur(boolean metFriet) {
		this.metFriet = metFriet;
	}
	void open() {
		open = true;
	}
	public boolean isOpen() {
		return open;
	}
	public boolean isMetFriet() {
		return metFriet;
	}
}