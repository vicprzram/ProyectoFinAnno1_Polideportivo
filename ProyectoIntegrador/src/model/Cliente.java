package model;

public class Cliente extends Persona{
	private int numCuenta;

	public Cliente(String dni, String apenom, String pass, String direccion, int numCuenta) {
		super(dni, apenom, pass, direccion);
		this.numCuenta = numCuenta;
	}
	
	
}
