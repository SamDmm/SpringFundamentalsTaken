package be.vdab.frituurfrida.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import be.vdab.frituurfrida.entities.Snack;
import be.vdab.frituurfrida.exceptions.SnackNietGevondenException;

@Repository
public class JdbcSnackRepository implements SnackRepository {
	private final JdbcTemplate template;
	private final RowMapper<Snack> rowMapper = (resultSet, rowNum) -> new Snack(resultSet.getLong("id"), resultSet.getString("naam"), resultSet.getBigDecimal("prijs"));
	private static final String SELECT_BY_ID = "select id, naam, prijs from snacks where id = ?";
	private static final String UPDATE_SNACK = "update snacks set naam, prijs where id = ?";
	private static final String SELECT_BY_NAAM = "select id, naam, prijs from snacks where naam = ?";
	
	JdbcSnackRepository(JdbcTemplate template) {
		this.template = template;
	}
	@Override
	public Optional<Snack> read(long id) {
		try {
			return Optional.of(template.queryForObject(SELECT_BY_ID, rowMapper, id));
		} catch (IncorrectResultSizeDataAccessException ex) {
			return Optional.empty();
		}
	}
	@Override
	public void update(Snack snack) {
		if (template.update(UPDATE_SNACK, snack.getNaam(), snack.getPrijs(), snack.getId()) == 0) {
			throw new SnackNietGevondenException();
		}
	}
	@Override
	public List<Snack> findByBeginNaam(String beginNaam) {
		return template.query(SELECT_BY_NAAM, rowMapper);
	}
	

}
