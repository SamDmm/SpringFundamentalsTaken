package be.vdab.frituurfrida.repositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import be.vdab.frituurfrida.entities.Saus;
import be.vdab.frituurfrida.exceptions.SausRepositoryException;

@Component
public class CSVSausRepository implements SausRepository {
	public static final Path PAD = Paths.get("/data/sauzen.csv");
	public static final Logger LOGGER = LoggerFactory.getLogger(CSVSausRepository.class);
	@Override
	public List<Saus> findAll() {
		List<Saus> sausList = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(PAD)) {
			for (String regel; (regel = reader.readLine()) != null;) {
				if (!regel.isEmpty()) {
					sausList.add(maakSaus(regel));
				}
			}
		} catch (IOException ex) {
			String fout = "Fout bij lezen" + PAD;
			LOGGER.error(fout, ex);
			throw new SausRepositoryException(fout);
		}
		return sausList;
	}
	
	public Saus maakSaus(String regel) {
		String[] regelArray = regel.split(",");
		Long nummer = Long.valueOf(regelArray[0]);
		String naam = regelArray[1];
		List<String> ingredienten = new ArrayList<>();
		for (int i = 2; i < regelArray.length; i++) {
			ingredienten.add(regelArray[i]);
		}
		return new Saus(nummer, naam, ingredienten);
	}
}
