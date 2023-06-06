package main;

import view.empleado.EmpleadoWindow;
import view.empleado.PConsulta;
import view.empleado.PReserva;
import view.empleado.PanelInicioEmpleado;
import view.empleado.PanelRegistroUsuario;
import view.principal.MainWindow;
import view.principal.PanelInicioSesion;
import control.*;
import db.PolideportivoPersistencia;

public class app {
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				PolideportivoPersistencia polideportivoPersistencia = new PolideportivoPersistencia();
				
				MainWindow mainWindow = new MainWindow();
				PanelInicioSesion panelInicioSesion = new PanelInicioSesion();
				EmpleadoWindow empleadoWindow = new EmpleadoWindow();
				PanelRegistroUsuario panelRegistroUsuario = new PanelRegistroUsuario();
				PConsulta panelConsulta = new PConsulta();
				PReserva panelReserva = new PReserva();
				PanelInicioEmpleado panelIncioEmpleado = new PanelInicioEmpleado();
				
				MainListener mainListener = new MainListener(mainWindow, panelInicioSesion, polideportivoPersistencia, empleadoWindow, panelIncioEmpleado);
				EmpleadoListener empleadoListener = new EmpleadoListener(mainWindow, empleadoWindow, panelConsulta, polideportivoPersistencia, panelIncioEmpleado, panelReserva); 

				
				empleadoWindow.setListener(empleadoListener);
				panelConsulta.setListener(empleadoListener);
				panelReserva.setListener(empleadoListener);
				panelRegistroUsuario.addListener(empleadoListener);
				panelIncioEmpleado.addListener(empleadoListener);
				
				
				
				//Pantalla inicio sesion
				panelInicioSesion.addListener(mainListener);
				mainWindow.addListener(mainListener);
				mainWindow.setVisible(true);
				mainWindow.cargarPanel(panelInicioSesion);
			}
			
		});
	}
}
