package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import db.PolideportivoPersistencia;
import view.EmpleadoWindow;
import view.PConsulta;

public class EmpleadoListener implements ActionListener {
	
	private EmpleadoWindow ventana;
	private PConsulta pConsulta;
	private PolideportivoPersistencia poliPersistencia;
	
	public EmpleadoListener(EmpleadoWindow ventana, PConsulta pConsulta) {
		this.ventana = ventana;
		this.pConsulta = pConsulta;
		poliPersistencia = new PolideportivoPersistencia();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(ventana.ITEM_CONSULTA)) {
				ventana.cargarPanel(pConsulta);
				pConsulta.cargarDeportes(poliPersistencia.getDeportes());
				pConsulta.cargarFechas(poliPersistencia.getFechas());
			}
		}
		if(e.getSource() == pConsulta.getBtnConsultar()) {
			pConsulta.recargarTabla(poliPersistencia.getRegistros(pConsulta.getFecha(), null, null, null));
		}
	}

}
