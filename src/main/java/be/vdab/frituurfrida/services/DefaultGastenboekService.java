package be.vdab.frituurfrida.services;

import java.util.List;

import org.springframework.stereotype.Service;

import be.vdab.frituurfrida.entities.GastenboekEntry;
import be.vdab.frituurfrida.repositories.GastenboekRepository;

@Service
class DefaultGastenboekService implements GastenboekService {
	private GastenboekRepository gastenboekRepository;
	
	public DefaultGastenboekService(GastenboekRepository gastenboekRepository) {
		this.gastenboekRepository = gastenboekRepository;
	}
	
	@Override
	public void create(GastenboekEntry entry) {
		gastenboekRepository.create(entry);
	}
	@Override
	public List<GastenboekEntry> findAll() {
		return gastenboekRepository.findAll();
	}
}
