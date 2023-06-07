package model;

public class Cliente extends Persona{
	private int numCuenta;

	public Cliente(String dni, String apenom, String direccion, int numCuenta) {
		super(dni, apenom, direccion);
		this.numCuenta = numCuenta;
	}

	public Cliente(String dni, String apenom, String direccion, String correo, String telefono, int numCuenta) {
		super(dni, apenom, direccion, correo, telefono);
		this.numCuenta = numCuenta;
	}
	
	public Cliente(String dni, String apenom) {
		super(dni, apenom, null, null, null);
		this.numCuenta = 0;
	}

	public int getNumCuenta() {
		return this.numCuenta;
	}
	
	
}
