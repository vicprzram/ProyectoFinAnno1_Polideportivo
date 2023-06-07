package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import db.PolideportivoPersistencia;
import utilities.*;
import model.Empleado;
import view.administrador.AdministradorWindow;
import view.administrador.ManejoEmpleadosPanel;
import view.empleado.PanelManejoUsuarios;

public class AdministradorListener implements ActionListener {

	private AdministradorWindow adminW;
	private ManejoEmpleadosPanel manejoEmpleadoPanel;
	private PolideportivoPersistencia poliP;
	
	
	private static final String NO_INSERTION = "No se ha podido insertar, intente de nuevo";
	private static final String INSERTION_SUCCESSFULL = "Se inserto correctamnete los datos";
	
	public AdministradorListener(AdministradorWindow adminW, ManejoEmpleadosPanel manejoEmpleadoPanel, 
			PolideportivoPersistencia poliP) {
		this.adminW = adminW;
		this.manejoEmpleadoPanel = manejoEmpleadoPanel;
		this.poliP = poliP;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(AdministradorWindow.ITEM_EMPLEADOS)) {
				adminW.cargarPanel(manejoEmpleadoPanel);
				

			}else if(e.getActionCommand().equals(AdministradorWindow.ITEM_INSTALACIONES)) {
				//void
			}else if(e.getActionCommand().equals(AdministradorWindow.ITEM_CLASE)) {
				//void
			}
		}else if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals(ManejoEmpleadosPanel.BUTTON_ANNADIR)) {
				Empleado values = manejoEmpleadoPanel.getValuesAnnadir();
				
				if(!Comprobaciones.dni(values.getDni())){
					new OutputMessages(0, Comprobaciones.ERROR_DNI);
				}else if(!Comprobaciones.direccion(values.getDireccion())) {
					new OutputMessages(0, Comprobaciones.ERROR_DIRECCION);
				}else if(!Comprobaciones.nombre(values.getApenom())){
					new OutputMessages(0, Comprobaciones.ERROR_NOMBRE);
				}else if(!Comprobaciones.correo(values.getCorreo())){
					new OutputMessages(0, Comprobaciones.ERROR_CORREO);
				}else if(!Comprobaciones.telefono(values.getTelefono())){
					new OutputMessages(0, Comprobaciones.ERROR_TELEFONO);
				}else if(values.getPass().isEmpty()) {
					new OutputMessages(0, Comprobaciones.ERROR_PASS);	
				}else if(poliP.empleadoExists(values) != null) {
					new OutputMessages(0, Comprobaciones.ERROR_DNI_EXIST);
				}else{
					boolean insertado = poliP.addEmpleado(values);
					
					if(!insertado) {
						new OutputMessages(0, NO_INSERTION);
					}else {
						new OutputMessages(1, INSERTION_SUCCESSFULL);
						manejoEmpleadoPanel.clearAnnadir();
					}
				}
			}
			
			
			else if(e.getSource().equals(manejoEmpleadoPanel.getLimpiarAnnadir())) {
				manejoEmpleadoPanel.clearAnnadir();
			}
		}
	}
	
}
