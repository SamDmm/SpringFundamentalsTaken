package be.vdab.frituurfrida.repositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import be.vdab.frituurfrida.entities.Saus;
import be.vdab.frituurfrida.exceptions.SausRepositoryException;


@Component
@Order(1)
public class PropertiesSausRepository implements SausRepository {
	public final Path pad;
	public static final Logger LOGGER = LoggerFactory.getLogger(CSVSausRepository.class);
	
	public PropertiesSausRepository(@Value("${sauzenPropertiesPath}") Path pad) {
		this.pad = pad;
	}
	
	@Override
	public List<Saus> findAll() {
		List<Saus> sausList = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(pad)) {
			for (String regel; (regel = reader.readLine()) != null;) {
				if (!regel.isEmpty()) {
					sausList.add(maakSaus(regel));
				}
			}
		} catch (IOException ex) {
			String fout = "Fout bij lezen" + pad;
			LOGGER.error(fout, ex);
			throw new SausRepositoryException(fout);
		}
		LOGGER.info("Sauzen gelezen via PropertiesSausRepository");
		return sausList;
	}
	
	public Saus maakSaus(String regel) {
		String[] regelArray = regel.split(":");
		if (regelArray.length < 2) {
			String fout = pad + ": " + regel + " bevat minder dan 2 onderdelen";
			LOGGER.error(fout);
			throw new SausRepositoryException(fout);
		}
		try {
			Saus saus = new Saus(Long.parseLong(regelArray[0]), regelArray[1].split(",")[0]);
			for (int i = 1; i < regelArray[1].split(",").length; i++) {
				saus.addIngredient(regelArray[1].split(",")[i]);
			}
			return saus;
		} catch (NumberFormatException ex) {
			String fout = pad + ": " + regel + "bevat verkeerde id";
			LOGGER.error(fout, ex);
			throw new SausRepositoryException(fout);
		}
	}
}
