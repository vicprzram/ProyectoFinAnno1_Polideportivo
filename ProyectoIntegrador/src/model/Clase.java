package model;

import java.util.ArrayList;
import java.util.Date;

public class Clase {
	private int id;
	private Date fecha;
	private int duracion;
	private Empleado profesor;
	private ArrayList<Cliente> listaAlumnos;
	private Instalacion instalacion;
	private Deporte deporte;


	public Clase(int id, Date fecha, int duracion, Empleado profesor, Instalacion instalacion, Deporte deporte) {
		this.id = id;
		this.fecha = fecha;
		this.duracion = duracion;
		this.profesor = profesor;
		listaAlumnos = new ArrayList<>();
		this.instalacion = instalacion;
		this.deporte = deporte;
	}
	
	
	
	
}
