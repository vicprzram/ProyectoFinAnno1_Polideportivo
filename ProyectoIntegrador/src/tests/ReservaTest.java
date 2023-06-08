package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Instalacion;
import model.Reserva;

public class ReservaTest {

	@Test
	public void testEqualsObject() {
		Reserva reserva = new Reserva(new Instalacion(0, "Piscina", "Piscina"), "Lunes", "09:00");
		assertEquals("Fallo al comparar reservas", false, reserva.equals(new Reserva(new Instalacion(0, "Piscina", "Piscina"), null, null)));
		
	}

}
