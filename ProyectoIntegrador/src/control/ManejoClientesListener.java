package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import db.PolideportivoPersistencia;
import model.Cliente;
import utilities.OutputMessages;
import view.empleado.PanelManejoUsuarios;

public class ManejoClientesListener implements ActionListener {

	private PanelManejoUsuarios panelManejoUsuarios;
	private PolideportivoPersistencia polideportivoPersistencia;
	
	private static final String EMPTY_FIELDS = "Los campos no pueden dejarse vacios, intente de nuevo";
	private static final String BAD_INSERTION = "No insertaron los datos, intente de nuevo";
	private static final String INSERTION_SUCCESSFULL = "Se insertaron correctamente los datos";
	private static final String BAD_INTEGER = "Solo se admiten numeros en el campo numeroCuenta";
	
	public ManejoClientesListener(PanelManejoUsuarios panelManejoUsuarios, PolideportivoPersistencia polideportivoPersistencia) {
		this.panelManejoUsuarios = panelManejoUsuarios;
		this.polideportivoPersistencia = polideportivoPersistencia;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals(PanelManejoUsuarios.BUTTON_ANNADIR)) {
				Cliente values = this.panelManejoUsuarios.getValuesAnnadir();
				
				if(values.getNumCuenta() != -1) {
					if(values.getDni().isEmpty() || values.getApenom().isEmpty() || values.getDireccion().isEmpty() || 
							values.getCorreo().isEmpty() || values.getTelefono().isEmpty() || values.getNumCuenta() == 0) {
						new OutputMessages(1, EMPTY_FIELDS);
					}else {
						boolean insertado = polideportivoPersistencia.addCliente(values);
						
						if(!insertado) {
							new OutputMessages(0, BAD_INSERTION);
						}else {
							new OutputMessages(1, INSERTION_SUCCESSFULL);
							panelManejoUsuarios.clearAllAnnadir();
						}
					}
				}else {
					new OutputMessages(0, BAD_INTEGER);
				}
			}else if(e.getSource().equals(panelManejoUsuarios.getLimpiarAnnadir())) {
				panelManejoUsuarios.clearAllAnnadir();
			}
			
		}else if(e.getSource() instanceof JLabel) {
			
		}
	}
	
}
