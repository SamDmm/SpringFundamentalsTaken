package be.vdab.frituurfrida.web;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

class DefaultZoekDeFrietSpel implements Serializable, ZoekDeFrietSpel {
	private static final long serialVersionUID = 1L;
	private static final int AANTAL_DEUREN = 7;
	private final Deur[] deuren = new Deur[AANTAL_DEUREN];
	
	DefaultZoekDeFrietSpel() {
		resetDeuren();
	}
	
	@Override
	public void openDeur(int index) {
		deuren[index].open();
	}

	@Override
	public Deur[] getDeuren() {
		return deuren;
	}

	@Override
	public void resetDeuren() {
		int indexMetFriet = ThreadLocalRandom.current().nextInt(AANTAL_DEUREN);
		for (int index = 0; index != AANTAL_DEUREN; index++) {
			deuren[index] = new Deur(index == indexMetFriet);
		}
	}
}
