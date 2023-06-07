package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import db.PolideportivoPersistencia;
import model.Clase;
import utilities.OutputMessages;
import view.administrador.AdministradorWindow;
import view.administrador.PClases;

public class AdministradorListener implements ActionListener{

	private PolideportivoPersistencia poliPers;
	private AdministradorWindow adminW;
	private PClases pClase;
	
	public AdministradorListener(PolideportivoPersistencia poliPers,AdministradorWindow adminW, PClases pClase) {
		this.poliPers = poliPers;
		this.adminW = adminW;
		this.pClase = pClase;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(AdministradorWindow.ITEM_EMPLEADOS)) {
				//void
			}else if(e.getActionCommand().equals(AdministradorWindow.ITEM_INSTALACIONES)) {
				//void
			}else if(e.getActionCommand().equals(AdministradorWindow.ITEM_CLASE)) {
				//void
				adminW.cargarPanel(pClase);
				pClase.cargarDeportes(poliPers.getDeportes());
			}
		}else if(e.getSource() instanceof JButton) {
			if(e.getSource() == pClase.getBtnConsultar()) {
				ArrayList<Clase> listaClases = poliPers.getListaClases(pClase.getDeporte());
				pClase.cargarClases(listaClases);
			}else if(e.getSource() == pClase.getBtnEditar()) {
				Clase clase = pClase.getSelectedClase();
				if(clase != null) {
					
				}else {
					new OutputMessages(0, "Debes seleccionar una celda");
				}
			}
		}
	}
	
}
