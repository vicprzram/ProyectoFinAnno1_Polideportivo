package model;

public class Clase {
	private int id;
	private String fecha;
	private String hora;
	private Empleado profesor;
	private Instalacion instalacion;
	private String deporte;


	public Clase(int id, String fecha, String hora, Empleado profesor, Instalacion instalacion, String deporte) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.profesor = profesor;
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


	public Instalacion getInstalacion() {
		return instalacion;
	}


	public String getDeporte() {
		return deporte;
	}
	
	public String toString() {
		return instalacion.getTipo() + " " + instalacion.getId() + " - " + profesor.getApenom().toUpperCase().charAt(0);
	}
}
