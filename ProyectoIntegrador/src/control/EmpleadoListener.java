package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JMenuItem;

import db.PolideportivoPersistencia;

import view.empleado.EmpleadoWindow;
import view.empleado.PConsulta;
import view.empleado.PanelInicioEmpleado;
import view.empleado.PanelManejoUsuarios;
import model.Reserva;
import utilities.OutputMessages;

import view.principal.MainWindow;
import view.empleado.PReserva;


public class EmpleadoListener implements ActionListener {
	
	private MainWindow mainWindow;
	
	private EmpleadoWindow empleWindow;
	private PConsulta pConsulta;
	private PReserva pReserva;
	private PolideportivoPersistencia poliPersistencia;
	private PanelInicioEmpleado panelInicioEmpleado;
	private PanelManejoUsuarios panelManejoUsuarios;
	

	public EmpleadoListener(MainWindow mainWindow, EmpleadoWindow empleWindow, PConsulta pConsulta, 
			PolideportivoPersistencia poliPersistencia,PanelInicioEmpleado panelInicioEmpleado, PReserva pReserva,
			PanelManejoUsuarios panelManejoUsuarios) {
		
		this.mainWindow = mainWindow;
		this.empleWindow = empleWindow;
		this.pConsulta = pConsulta;
		this.poliPersistencia = poliPersistencia;
		this.panelInicioEmpleado = panelInicioEmpleado;
		this.pReserva = pReserva;
		this.panelManejoUsuarios = panelManejoUsuarios;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(EmpleadoWindow.ITEM_CONSULTA)) {
				empleWindow.cargarPanel(pConsulta);
				pConsulta.cargarDeportes(poliPersistencia.getDeportes());
				pConsulta.cargarFechas(poliPersistencia.getFechas());

			}else if(e.getActionCommand().equals(EmpleadoWindow.ITEM_INICIO)) {
				empleWindow.cargarPanel(panelInicioEmpleado);
				
			}else if(e.getActionCommand().equals(EmpleadoWindow.ITEM_SESION)) {
				if(OutputMessages.confirm("Se va a cerrar la sesión, ¿quiere continuar?") == 0) {
					empleWindow.dispose();
					mainWindow.setVisible(true);	
				}
				
			}else if(e.getActionCommand().equals(EmpleadoWindow.ITEM_RESERVA)) {
				empleWindow.cargarPanel(pReserva);
				pReserva.cargarDeportes(poliPersistencia.getDeportes());
			}else if(e.getActionCommand().equals(EmpleadoWindow.ITEM_MANEJO)) {
				empleWindow.cargarPanel(panelManejoUsuarios);
			}
			
		}else if(e.getSource() instanceof JCheckBox) {
			if(e.getActionCommand().equals(PanelInicioEmpleado.CHECK_CONTRASENA)) {
				if(panelInicioEmpleado.getSelection()) {
					panelInicioEmpleado.ofuscarContrasena(false);
				}else {
					panelInicioEmpleado.ofuscarContrasena(true);
				}
			}
			
		}else if(e.getSource() == pConsulta.getBtnConsultar()) {
			ArrayList<Reserva> registros = poliPersistencia.getRegistros(pConsulta.getFecha(), pConsulta.getHora(), pConsulta.getDeporte(), pConsulta.getUso());
			if(registros.isEmpty()) {
				new OutputMessages(1, "No se han encontrado registros");
				pConsulta.visibilidadTabla(false);
			}else {
				pConsulta.recargarTabla(registros);
			}
		}
	}

}
