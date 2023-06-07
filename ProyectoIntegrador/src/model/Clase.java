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
	
	public String[] getRowConsulta() {
		String[] data = new String[6];
		data[0] = instalacion.getTipo() + " " + instalacion.getId();
		data[1] = instalacion.getDeporte();
		data[2] = "CLASE";
		data[3] = "POLIDEPORTIVO";
		data[4] = fecha;
		data[5] = hora;
		return data;
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
