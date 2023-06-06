package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import db.PolideportivoPersistencia;
import model.Reserva;
import utilities.OutputMessages;
import view.EmpleadoWindow;
import view.MainWindow;
import view.PConsulta;

public class EmpleadoListener implements ActionListener {
	
	private MainWindow mainWindow;
	private EmpleadoWindow empleWindow;
	private PConsulta pConsulta;
	private PolideportivoPersistencia poliPersistencia;
	
	public EmpleadoListener(MainWindow mainWindow, EmpleadoWindow empleWindow, PConsulta pConsulta) {
		this.mainWindow = mainWindow;
		this.empleWindow = empleWindow;
		this.pConsulta = pConsulta;
		poliPersistencia = new PolideportivoPersistencia();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(empleWindow.ITEM_CONSULTA)) {
				empleWindow.cargarPanel(pConsulta);
				pConsulta.cargarDeportes(poliPersistencia.getDeportes());
				pConsulta.cargarFechas(poliPersistencia.getFechas());
			}else if(e.getActionCommand().equals(empleWindow.ITEM_SESION)) {
				if(OutputMessages.confirm("Se va a cerrar la sesión, ¿quiere continuar?") == 0) {
					empleWindow.dispose();
					mainWindow.setVisible(true);	
				}
				
			}
		}
		if(e.getSource() == pConsulta.getBtnConsultar()) {
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
