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
				PanelRegistroUsuario panelRegistroUsuario = new PanelRegistroUsuario();
				EmpleadoWindow empleadoWindow = new EmpleadoWindow();
				
				PolideportivoPersistencia polideportivoPersistencia = new PolideportivoPersistencia();
				
				MainListener mainListener = new MainListener(mainWindow, panelInicioSesion, polideportivoPersistencia);
				EmpleadoListener empleadoListener = new EmpleadoListener(empleadoWindow, panelRegistroUsuario);
				
				empleadoWindow.addListener(empleadoListener);
				panelRegistroUsuario.addListener(empleadoListener);
				
				panelInicioSesion.addListener(mainListener);
				mainWindow.addListener(mainListener);
				mainWindow.setVisible(true);
				mainWindow.cargarPanel(panelInicioSesion);
			}
			
		});
	}
}
