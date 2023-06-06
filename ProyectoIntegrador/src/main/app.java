package main;

import view.*;
import control.*;
import db.PolideportivoPersistencia;

public class app {
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainWindow mainWindow = new MainWindow();
				PanelInicioSesion panelInicioSesion = new PanelInicioSesion();
				
				EmpleadoWindow empleadoWindow = new EmpleadoWindow();
				PanelRegistroUsuario panelRegistroUsuario = new PanelRegistroUsuario();
				PConsulta panelConsulta = new PConsulta();
				PReserva panelReserva = new PReserva();
				
				PolideportivoPersistencia polideportivoPersistencia = new PolideportivoPersistencia();
				
				MainListener mainListener = new MainListener(mainWindow, panelInicioSesion, polideportivoPersistencia, empleadoWindow);
				EmpleadoListener empleadoListener = new EmpleadoListener(mainWindow,empleadoWindow, panelConsulta, panelReserva); 
				
				empleadoWindow.setListener(empleadoListener);
				panelConsulta.setListener(empleadoListener);
				panelReserva.setListener(empleadoListener);
				panelRegistroUsuario.addListener(empleadoListener);
				
				panelInicioSesion.addListener(mainListener);
				mainWindow.addListener(mainListener);
				mainWindow.setVisible(true);
				mainWindow.cargarPanel(panelInicioSesion);
			}
			
		});
	}
}
