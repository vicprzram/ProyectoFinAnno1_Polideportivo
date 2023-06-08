package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Clase;
import model.Empleado;
import model.Instalacion;

public class ClaseTest {

	@Test
	public void testGetRowConsulta() {
		Clase clase = new Clase(0, "Lunes", "09:00", new Empleado("Prueba", "12345678A"), new Instalacion(0, "Piscina", "Piscina"), "Piscina");
		String[] expected = {"Piscina 0", "Piscina", "CLASE", "POLIDEPORTIVO", "Lunes", "09:00"};
		assertEquals("Fallo al ejecutar rowConsulta()", expected, clase.getRowConsulta());
	}

}
