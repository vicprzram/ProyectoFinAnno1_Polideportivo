package model;

import java.util.ArrayList;
import java.util.Date;

public class Clase {
	private int id;
	private String fecha;
	private String hora;
	private Empleado profesor;
	private ArrayList<Cliente> listaAlumnos;
	private Instalacion instalacion;
	private String deporte;


	public Clase(int id, String fecha, String hora, Empleado profesor, Instalacion instalacion, String deporte, ArrayList<Cliente> listaAlumnos) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.profesor = profesor;
		this.listaAlumnos = listaAlumnos;
		this.instalacion = instalacion;
		this.deporte = deporte;
	}


	public int getId() {
		return id;
	}


	public String getFecha() {
		return fecha;
	}


	public String getHora() {
		return hora;
	}


	public Empleado getProfesor() {
		return profesor;
	}


	public ArrayList<Cliente> getListaAlumnos() {
		return listaAlumnos;
	}


	public Instalacion getInstalacion() {
		return instalacion;
	}


	public String getDeporte() {
		return deporte;
	}
	
	
	
	
	
}
