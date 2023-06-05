import java.awt.EventQueue;

import view.PReserva;
import view.EmpleadoWindow;

public class Inicio {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				EmpleadoWindow vCliente = new EmpleadoWindow();
				PReserva pReserva = new PReserva();
				vCliente.cargarPanel(pReserva);
				vCliente.setVisible(true);
			}
		});
	}
}
