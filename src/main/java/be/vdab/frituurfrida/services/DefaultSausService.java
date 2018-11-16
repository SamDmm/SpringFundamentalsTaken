package be.vdab.frituurfrida.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import be.vdab.frituurfrida.entities.Saus;
import be.vdab.frituurfrida.exceptions.SausRepositoryException;
import be.vdab.frituurfrida.repositories.SausRepository;

@Service
public class DefaultSausService implements SausService {
	SausRepository[] sausRepositories;
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSausService.class);
	
	public DefaultSausService(SausRepository[] sausRepositories) {
		this.sausRepositories = sausRepositories;
	}
	
	@Override
	public List<Saus> findAll() {
		for (SausRepository sausRepository : sausRepositories) {
			try {
				return sausRepository.findAll();
			} catch (SausRepositoryException ex) {
				LOGGER.error("Kan sausRepository niet lezen", ex);
			}
		}
		LOGGER.error("Kan geen enkele sausRepository lezen");
		return null;
	}
}
