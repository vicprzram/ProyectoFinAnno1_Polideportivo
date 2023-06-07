package model;

public class Empleado extends Persona{

	private String pass;
	private String rol;
	
	public Empleado(String dni, String apenom, String pass, String direccion, String rol) {
		super(dni, apenom, direccion);
		this.pass = pass;
		this.rol = rol;
	}
	public Empleado(String apenom) {
		super(null, apenom, null);
	}
	
	public String getRol() {
		return this.rol;
	}
	
	public String getPass() {
		return this.pass;
	}
}
