package model;

public class Instalacion {
	private int id;
	private String deporte;
	private String tipo;
	
	public Instalacion(int id, String deporte, String tipo) {
		this.id = id;
		this.tipo = tipo;
		this.deporte = deporte;
	}

	public int getId() {
		return id;
	}

	public String getDeporte() {
		return deporte;
	}

	public String getTipo() {
		return tipo;
	}

	
	
}
