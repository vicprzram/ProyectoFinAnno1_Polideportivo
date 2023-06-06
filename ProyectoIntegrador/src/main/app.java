package main;

import view.*;
import view.empleado.EmpleadoWindow;
import view.empleado.PConsulta;
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
				
				
				
				// Pantalla empleado
				PanelRegistroUsuario panelRegistroUsuario = new PanelRegistroUsuario();
				PConsulta panelConsulta = new PConsulta();
				EmpleadoWindow empleadoWindow = new EmpleadoWindow();
				PanelInicioEmpleado panelIncioEmpleado = new PanelInicioEmpleado();
				
				EmpleadoListener empleadoListener = new EmpleadoListener(empleadoWindow, panelConsulta, polideportivoPersistencia, panelIncioEmpleado); 
				
				empleadoWindow.setListener(empleadoListener);
				panelRegistroUsuario.addListener(empleadoListener);
				panelIncioEmpleado.addListener(empleadoListener);
				
				
				
				//Pantalla inicio sesion
				MainWindow mainWindow = new MainWindow();
				PanelInicioSesion panelInicioSesion = new PanelInicioSesion();
				
				MainListener mainListener = new MainListener(mainWindow, panelInicioSesion, polideportivoPersistencia, empleadoWindow, panelIncioEmpleado);
				
				panelInicioSesion.addListener(mainListener);
				mainWindow.addListener(mainListener);
				mainWindow.setVisible(true);
				mainWindow.cargarPanel(panelInicioSesion);
			}
			
		});
	}
}
