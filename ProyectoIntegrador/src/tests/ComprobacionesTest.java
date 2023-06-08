package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.Comprobaciones;

public class ComprobacionesTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Iniciando test de Comprobaciones");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Finalizando test de Comprobaciones");
	}
	
	@Test
	public void testDni() {
		assertEquals("Fallo al comprobar DNI", true, Comprobaciones.dni("12345678A"));
	}

	@Test
	public void testCorreo() {
		assertEquals("Fallo al comprobar correo", true, Comprobaciones.correo("raulcarrizomartin@gmail.com"));
	}

	@Test
	public void testDireccion() {
		assertEquals("Fallo al comprobar direccion", true, Comprobaciones.direccion("Av/ de Fernando Alonso"));
	}

	@Test
	public void testNombre() {
		assertEquals("Fallo al comprobar nombre", true, Comprobaciones.nombre("Raúl"));
	}

	@Test
	public void testTelefono() {
		assertEquals("Fallo al comprobar telefono", true, Comprobaciones.telefono("+34 123456789"));
	}

}
