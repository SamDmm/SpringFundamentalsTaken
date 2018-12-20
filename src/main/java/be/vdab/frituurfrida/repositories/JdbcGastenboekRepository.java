package be.vdab.frituurfrida.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import be.vdab.frituurfrida.entities.GastenboekEntry;

@Component
class JdbcGastenboekRepository implements GastenboekRepository {
	private JdbcTemplate template;
	private SimpleJdbcInsert insert;
	
	public JdbcGastenboekRepository(JdbcTemplate template) {
		this.template = template;
		this.insert = new SimpleJdbcInsert(template);
		insert.withTableName("gastenboek");
		insert.usingGeneratedKeyColumns("id");
	}
	@Override
	public void create(GastenboekEntry entry) {
		Map<String, Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("naam", entry.getNaam());
		kolomWaarden.put("datumTijd", entry.getDatum());
		kolomWaarden.put("bericht", entry.getBericht());
		Number id = insert.executeAndReturnKey(kolomWaarden);
		entry.setId(id.longValue());
	}
	private final RowMapper<GastenboekEntry> gastenboekEntryRowMapper = 
			(resultSet, RowNum) -> new GastenboekEntry(resultSet.getLong("id"), resultSet.getString("naam"),
					resultSet.getTimestamp("datumTijd").toLocalDateTime(), resultSet.getString("bericht"));
	private static final String SELECT_ALL = "select id, naam, datumTijd, bericht from gastenboek order by datumTijd desc";
	@Override
	public List<GastenboekEntry> findAll() {
		return template.query(SELECT_ALL, gastenboekEntryRowMapper);
	}

}
