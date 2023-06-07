package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import db.PolideportivoPersistencia;
import model.Cliente;
import utilities.OutputMessages;
import view.empleado.PanelManejoUsuarios;
import view.empleado.VentanaConsultaCliente;

public class ManejoClientesListener implements ActionListener, MouseListener {

	private PanelManejoUsuarios panelManejoUsuarios;
	private PolideportivoPersistencia polideportivoPersistencia;
	private VentanaConsultaCliente vCCliente;
	
	private static final String EMPTY_FIELDS = "Los campos no pueden dejarse vacios, intente de nuevo";
	private static final String BAD_INSERTION = "No insertaron los datos, intente de nuevo";
	private static final String INSERTION_SUCCESSFULL = "Se insertaron correctamente los datos";
	private static final String BAD_INTEGER = "Solo se admiten numeros en el campo numeroCuenta";
	
	public ManejoClientesListener(PanelManejoUsuarios panelManejoUsuarios, PolideportivoPersistencia polideportivoPersistencia,
			VentanaConsultaCliente vCCliente) {
		this.panelManejoUsuarios = panelManejoUsuarios;
		this.polideportivoPersistencia = polideportivoPersistencia;
		this.vCCliente = vCCliente;
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
			}else if(e.getActionCommand().equals(VentanaConsultaCliente.BUTTON_RECARGAR)) {
				vCCliente.removeData();
				ArrayList<Cliente> values = polideportivoPersistencia.getAllClientes();
				
				vCCliente.setVisible(true);
				
				for(Cliente i : values) {
					vCCliente.insertData(i);
				}
				
				vCCliente.deshabilitar(false);
			}else if(e.getActionCommand().equals(VentanaConsultaCliente.BUTTON_SALIR)) {
				vCCliente.dispose();
				
			}
			
			
			
			else if(e.getSource().equals(panelManejoUsuarios.getLimpiarAnnadir())) {
				panelManejoUsuarios.clearAllAnnadir();
			}
			
		}else if(e.getSource() instanceof JLabel) {
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		vCCliente.setVisible(true);
		vCCliente.deshabilitar(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
}
