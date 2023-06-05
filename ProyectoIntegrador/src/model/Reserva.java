package model;

import java.sql.Date;

public class Reserva {
	private Cliente cliente;
	private Instalacion instalacion;
	private int id;
	private Date fecha;
	private int duracion;
	private boolean pago;
	
	public Reserva(Cliente cliente, Instalacion instalacion, int id, Date fecha, int duracion, boolean pago) {
		this.cliente = cliente;
		this.instalacion = instalacion;
		this.id = id;
		this.fecha = fecha;
		this.duracion = duracion;
		this.pago = pago;
	}
	
	
}
