package main;


import view.administrador.*;
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
				VentanaConsultaCliente vCCliente = new VentanaConsultaCliente();
				
				//Pantalla administrador
				AdministradorWindow administradorWindow = new AdministradorWindow();
				ManejoEmpleadosPanel manejoEmpleadoPanel = new ManejoEmpleadosPanel();
				PClases panelClases = new PClases();
				WindowClases wClase =  new WindowClases();

				VentanaConsultaEmpleados vCEmpleados = new VentanaConsultaEmpleados();
				
				//Listeners
				MainListener mainListener = new MainListener(mainWindow, panelInicioSesion, polideportivoPersistencia, 
						empleadoWindow, panelInicioEmpleado, administradorWindow);
				EmpleadoListener empleadoListener = new EmpleadoListener(mainWindow, empleadoWindow, panelConsulta, 
						polideportivoPersistencia, panelInicioEmpleado, panelReserva, panelManejoUsuarios); 
				ManejoClientesListener clientesListener = new ManejoClientesListener(panelManejoUsuarios, polideportivoPersistencia, vCCliente);

				AdministradorListener adminListener = new AdministradorListener(administradorWindow, manejoEmpleadoPanel, polideportivoPersistencia, panelClases, wClase, mainWindow, vCEmpleados);
				ClaseListener claseListener = new ClaseListener(wClase, polideportivoPersistencia, panelClases);

				
				//Configuracion pantalla administrador
				administradorWindow.setListener(adminListener);
				panelClases.setListener(adminListener);
				manejoEmpleadoPanel.addListener(adminListener);
				wClase.setListener(claseListener);

				vCEmpleados.addListener(adminListener);
				
				//Configuracion pantallas empleado
				empleadoWindow.setListener(empleadoListener);
				panelConsulta.setListener(empleadoListener);
				panelReserva.setListener(empleadoListener);
				panelRegistroUsuario.addListener(empleadoListener);
				panelInicioEmpleado.addListener(empleadoListener);
				panelManejoUsuarios.addListener(clientesListener);
				vCCliente.addListener(clientesListener);
				
				//Configuracion pantalla principal
				panelInicioSesion.addListener(mainListener);
				mainWindow.addListener(mainListener);
				mainWindow.setVisible(true);
				mainWindow.cargarPanel(panelInicioSesion);
			}
			
		});
	}
}
