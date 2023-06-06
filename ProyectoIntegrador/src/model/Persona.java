package model;

public class Persona {
	private String dni;
	private String apenom;
	private String direccion;
	private String correo;
	private String telefono;
	
	public Persona(String dni, String apenom, String direccion) {
		this.dni = dni;
		this.apenom = apenom;
		this.direccion = direccion;
	}
	

	public Persona(String dni, String apenom, String direccion, String correo, String telefono) {
		this.dni = dni;
		this.apenom = apenom;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
	}


	public String getDni() {
		return dni;
	}
	public String getApenom() {
		return apenom;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public String getTelefono() {
		return telefono;
	}
	
	
}
