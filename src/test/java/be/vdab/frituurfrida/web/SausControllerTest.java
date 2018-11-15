package be.vdab.frituurfrida.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
<<<<<<< HEAD
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

import be.vdab.frituurfrida.services.SausService;

@RunWith(MockitoJUnitRunner.class)
public class SausControllerTest {
	private SausController controller;
	@Mock
	private SausService sausService;
	@Before
	public void before() {
		controller = new SausController(sausService);
	}
	@Test
	public void sauzenWerktSamenMetDeJspSauzen() {
		assertEquals("sauzen", controller.sauzen().getViewName());
	}
	@Test
	public void sauzenGeeftSauzenDoor() {
		assertTrue(controller.sauzen().getModel().get("sauzen") instanceof List);
	}
	@Test
	public void sauzenGeeftJuisteDataAanJSP() {
		assertTrue(controller.sauzen().getModel().containsKey("sauzen"));
		verify(sausService).findAll();
=======

public class SausControllerTest {
	private SausController controller;
	@Before
	public void before() {
		controller = new SausController();
	}
	@Test
	public void sauzenWerktSamenMetDeJspSauzen() {
		assertEquals("sauzen", controller.sauzen().getViewName());
	}
	@Test
	public void sauzenGeeftSauzenDoor() {
		assertTrue(controller.sauzen().getModel().get("sauzen") instanceof List);
>>>>>>> refs/remotes/origin/master
	}
}
