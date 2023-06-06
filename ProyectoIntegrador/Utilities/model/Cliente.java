package model;

public class Cliente extends Persona{
	private int numCuenta;

	public Cliente(String dni, String apenom, String direccion, int numCuenta) {
		super(dni, apenom, null, direccion);
		this.numCuenta = numCuenta;
	}
	
	
}
