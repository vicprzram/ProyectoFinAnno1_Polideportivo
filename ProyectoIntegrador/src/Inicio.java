import java.awt.EventQueue;

import control.EmpleadoListener;
import view.PReserva;
import view.EmpleadoWindow;
import view.PConsulta;

public class Inicio {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				EmpleadoWindow vEmpleado = new EmpleadoWindow();
				PConsulta pConsulta = new PConsulta();
				EmpleadoListener empleWListener = new EmpleadoListener(vEmpleado, pConsulta);
				vEmpleado.setListener(empleWListener);
				pConsulta.setListener(empleWListener);
				vEmpleado.setVisible(true);
			}
		});
	}
}
