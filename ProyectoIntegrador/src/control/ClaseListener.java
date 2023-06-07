package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import db.PolideportivoPersistencia;
import model.Clase;
import utilities.OutputMessages;
import view.administrador.PClases;
import view.administrador.WindowClases;

public class ClaseListener implements ActionListener {
	private WindowClases wClase;
	private PClases pClase;
	private PolideportivoPersistencia poliP;
	
	public ClaseListener(WindowClases wClase, PolideportivoPersistencia poliP, PClases pClase) {
		this.wClase = wClase;
		this.poliP = poliP;
		this.pClase = pClase;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == wClase.getBtnCancelar()) {
			if(OutputMessages.confirm("¿Quiere cancelar la operación?") == 0) {
				wClase.dispose();
			}
		}else if(e.getSource() == wClase.getBtnGuardar()) {
			Clase clase = wClase.getClase();
			if(clase.getId() != 0) {
				int res = poliP.addClase(clase);
				if(res != -1) {
					finalizarOperacion();
				}
			}else {
				int res = poliP.modClase(clase);
				if(res != -1) {
					finalizarOperacion();
				}
			}
			
		}
	}
	private void finalizarOperacion() {
		new OutputMessages(1, "Operación realizada con éxito");
		wClase.dispose();
		ArrayList<Clase> listaClases = poliP.getListaClases(pClase.getDeporte());
		pClase.cargarClases(listaClases);
	}

}
