package model;

import java.util.ArrayList;
import java.util.Date;

public class Torneo {
	private int id;
	private Date fecha;
	private Deporte deporte;
	private ArrayList<Cliente> listaParticipantes;
	private Empleado organizador;
	
	public Torneo(int id, Date fecha) {
		this.id = id;
		this.fecha = fecha;
	}
	
	
}
