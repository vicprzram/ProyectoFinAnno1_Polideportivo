package main;

import view.empleado.*;
import view.principal.*;
import control.*;
import db.PolideportivoPersistencia;

public class app {
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				PolideportivoPersistencia polideportivoPersistencia = new PolideportivoPersistencia();
				
				//Pantalla principal
				MainWindow mainWindow = new MainWindow();
				PanelInicioSesion panelInicioSesion = new PanelInicioSesion();
				
				//Pantalla empleado
				EmpleadoWindow empleadoWindow = new EmpleadoWindow();
				PanelRegistroUsuario panelRegistroUsuario = new PanelRegistroUsuario();
				PConsulta panelConsulta = new PConsulta();
				PReserva panelReserva = new PReserva();
				PanelInicioEmpleado panelInicioEmpleado = new PanelInicioEmpleado();
				PanelManejoUsuarios panelManejoUsuarios = new PanelManejoUsuarios();
				
				//Listeners
				MainListener mainListener = new MainListener(mainWindow, panelInicioSesion, polideportivoPersistencia, 
						empleadoWindow, panelInicioEmpleado);
				EmpleadoListener empleadoListener = new EmpleadoListener(mainWindow, empleadoWindow, panelConsulta, 
						polideportivoPersistencia, panelInicioEmpleado, panelReserva, panelManejoUsuarios); 
				ManejoClientesListener clientesListener = new ManejoClientesListener(panelManejoUsuarios, polideportivoPersistencia);

				//Configuracion pantallas empleado
				empleadoWindow.setListener(empleadoListener);
				panelConsulta.setListener(empleadoListener);
				panelReserva.setListener(empleadoListener);
				panelRegistroUsuario.addListener(empleadoListener);
				panelInicioEmpleado.addListener(empleadoListener);
				panelManejoUsuarios.addListener(clientesListener);
				
				//Configuracion pantalla principal
				panelInicioSesion.addListener(mainListener);
				mainWindow.addListener(mainListener);
				mainWindow.setVisible(true);
				mainWindow.cargarPanel(panelInicioSesion);
			}
			
		});
	}
}
