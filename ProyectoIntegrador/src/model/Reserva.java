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
	
	public Reserva(Instalacion instalacion, String dia, String hora) {
		this.instalacion = instalacion;
		this.dia = dia;
		this.hora = hora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}
	
	public boolean isPago() {
		return pago;
	}

	public boolean equals(Object comp) {
		boolean res = false;
		if(comp instanceof Reserva) {
			Reserva rComp = (Reserva) comp;
			if(rComp.getInstalacion().getId() == this.instalacion.getId()) {
				if(rComp.getDia().equals(this.dia)) {
					if(rComp.getHora().equals(this.hora)) {
						res = true;
					}
				}
			}	
		}
		return res;
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
	
	public String[] getRowReserva() {
		String[] data = new String[3];
		data[0] = instalacion.getTipo() + " " + instalacion.getId();
		data[1] = dia;
		data[2] = hora;
		return data;
	}
		
}
