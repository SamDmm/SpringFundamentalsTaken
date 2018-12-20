package be.vdab.frituurfrida.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.frituurfrida.entities.GastenboekEntry;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcGastenboekRepository.class)
@Sql("/insertGastenboekEntry.sql")
public class JdbcGastenboekRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final String GASTENBOEK = "gastenboek";
	@Autowired
	private JdbcGastenboekRepository repository;
	@Test
	public void findAll() {
		List<GastenboekEntry> gastenboekEntries = repository.findAll();
		assertEquals(super.countRowsInTable(GASTENBOEK), gastenboekEntries.size());
		LocalDateTime vorigeDatum = LocalDateTime.MAX;
		for (GastenboekEntry entry : gastenboekEntries) {
			assertTrue(entry.getDatum().compareTo(vorigeDatum) <= 0);
			vorigeDatum = entry.getDatum();
		}
	}
	@Test
	public void create() {
		int aantalEntries = super.countRowsInTable(GASTENBOEK);
		GastenboekEntry entry = new GastenboekEntry("Leen", "Zalige burgers. Top!");
		repository.create(entry);
		assertNotEquals(0, entry.getId());
		assertEquals(aantalEntries + 1, super.countRowsInTable(GASTENBOEK));
		assertEquals(1, super.countRowsInTableWhere(GASTENBOEK, "id=" + entry.getId()));
	}
	private long idVanTestEntry() {
		return super.jdbcTemplate.queryForObject("select id from gastenboek where naam ='test'", Long.class);
	}
	@Test
	public void delete() {
		long id = idVanTestEntry();
		int aantalEntries = super.countRowsInTable(GASTENBOEK);
		repository.delete(id);
		assertEquals(aantalEntries - 1, super.countRowsInTable(GASTENBOEK));
		assertEquals(0, super.countRowsInTableWhere(GASTENBOEK, "id=" + id));
	}
}
