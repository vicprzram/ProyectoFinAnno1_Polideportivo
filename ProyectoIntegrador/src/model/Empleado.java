package model;

public class Empleado extends Persona{
	private String rol;

	public Empleado(String dni, String apenom, String pass, String direccion, String rol) {
		super(dni, apenom, pass, direccion);
		this.rol = rol;
	}
	
	
}
