package model;

public class Instalacion {
	private int id;
	private String deporte;
	private String tipo;
	private String horaA;
	private String horaC;
	
	public Instalacion(int id, String deporte, String tipo, String horaA, String horaC) {
		this.id = id;
		this.tipo = tipo;
		this.deporte = deporte;
		this.horaA = horaA;
		this.horaC = horaC;
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

	public String getHoraA() {
		return horaA;
	}

	public String getHoraC() {
		return horaC;
	}
	
	
}
