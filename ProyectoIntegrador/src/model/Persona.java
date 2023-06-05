package model;

public class Persona {
	private String dni;
	private String apenom;
	private String pass;
	private String direccion;
	
	public Persona(String dni, String apenom, String pass, String direccion) {
		this.dni = dni;
		this.apenom = apenom;
		this.pass = pass;
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public String getApenom() {
		return apenom;
	}

	public String getPass() {
		return pass;
	}

	public String getDireccion() {
		return direccion;
	}
	
	
}
