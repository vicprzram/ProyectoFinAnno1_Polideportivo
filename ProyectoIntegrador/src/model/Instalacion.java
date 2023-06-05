package model;

import java.util.Date;

public class Instalacion {
	private int id;
	private String tipo;
	private Date horaA;
	private Date horaC;
	
	public Instalacion(int id, String tipo, Date horaA, Date horaC) {
		this.id = id;
		this.tipo = tipo;
		this.horaA = horaA;
		this.horaC = horaC;
	}
}
