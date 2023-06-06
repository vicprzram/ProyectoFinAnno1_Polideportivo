package model;

public class Reserva {
	private Cliente cliente;
	private Instalacion instalacion;
	private int id;
	private String dia;
	private String hora;
	private int duracion;
	private boolean pago;
	
	public Reserva(Cliente cliente, Instalacion instalacion, int id, String dia, String hora, int duracion, boolean pago) {
		this.cliente = cliente;
		this.instalacion = instalacion;
		this.id = id;
		this.dia = dia;
		this.hora = hora;
		this.duracion = duracion;
		this.pago = pago;
	}
	
	public String[] getRowConsulta() {
		String[] data = new String[6];
		data[0] = instalacion.getTipo() + " " + instalacion.getId();
		data[1] = instalacion.getDeporte();
		data[2] = "RESERVADO";
		data[3] = cliente.getApenom();
		data[4] = dia;
		data[5] = hora;
		return data;
	}
	
}
