package be.vdab.frituurfrida.web;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

public class BeginNaamFormTest {
	private Validator validator;
	@Before
	public void before() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	@Test
	public void beginnaamOk() {
		assertTrue(validator.validateValue(BeginNaamForm.class, "beginnaam", "a").isEmpty());
	}
	@Test
	public void beginnaamMoetIngevuldZijn() {
		assertFalse(validator.validateValue(BeginNaamForm.class, "beginnaam", "").isEmpty());
	}
	@Test
	public void beginnaamMagNietNullZijn() {
		assertFalse(validator.validateValue(BeginNaamForm.class, "beginnaam", null).isEmpty());
	}
}
