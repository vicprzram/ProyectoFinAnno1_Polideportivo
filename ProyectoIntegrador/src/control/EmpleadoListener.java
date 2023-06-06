package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JMenuItem;

import db.PolideportivoPersistencia;
import view.empleado.EmpleadoWindow;
import view.empleado.PConsulta;
import view.empleado.PanelInicioEmpleado;

public class EmpleadoListener implements ActionListener {
	
	private EmpleadoWindow ventana;
	private PConsulta pConsulta;
	private PolideportivoPersistencia poliPersistencia;
	private PanelInicioEmpleado panelInicioEmpleado;
	
	public EmpleadoListener(EmpleadoWindow ventana, PConsulta pConsulta, PolideportivoPersistencia poliPersistencia,PanelInicioEmpleado panelInicioEmpleado) {
		this.ventana = ventana;
		this.pConsulta = pConsulta;
		this.poliPersistencia = poliPersistencia;
		this.panelInicioEmpleado = panelInicioEmpleado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(EmpleadoWindow.ITEM_CONSULTA)) {
				ventana.cargarPanel(pConsulta);
				pConsulta.cargarDeportes(poliPersistencia.getDeportes());
				pConsulta.cargarFechas(poliPersistencia.getFechas());
			}else if(e.getActionCommand().equals(EmpleadoWindow.ITEM_INICIO)) {
				ventana.cargarPanel(panelInicioEmpleado);
			}
		}else if(e.getSource() instanceof JCheckBox) {
			if(e.getActionCommand().equals(PanelInicioEmpleado.CHECK_CONTRASENA)) {
				if(panelInicioEmpleado.getSelection()) {
					panelInicioEmpleado.ofuscarContrasena(false);
				}else {
					panelInicioEmpleado.ofuscarContrasena(true);
				}
			}
		}
		
		
		
		if(e.getSource() == pConsulta.getBtnConsultar()) {
			pConsulta.recargarTabla(poliPersistencia.getRegistros(pConsulta.getFecha(), null, null, null));
		}
	}

}
