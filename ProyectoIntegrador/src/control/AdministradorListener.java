package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import db.PolideportivoPersistencia;
import utilities.*;
import model.Cliente;
import model.Empleado;
import view.administrador.AdministradorWindow;
import view.administrador.ManejoEmpleadosPanel;
import view.administrador.VentanaConsultaEmpleados;
import view.empleado.PanelManejoUsuarios;

public class AdministradorListener implements ActionListener, MouseListener {

	private AdministradorWindow adminW;
	private ManejoEmpleadosPanel manejoEmpleadoPanel;
	private PolideportivoPersistencia poliP;
	private VentanaConsultaEmpleados vCE; 
	
	private static final String EMPTY_DNI = "El campo dni no puede dejarse vacio, intente de nuevo";
	private static final String NO_INSERTION = "No se ha podido insertar, intente de nuevo";
	private static final String INSERTION_SUCCESSFULL = "Se inserto correctamnete los datos";
	private static final String BAD_INSERTION = "No insertaron los datos, intente de nuevo";
	private static final String ASK_DELETE = "¿Seguro que quiere eliminar lo seleccionado?";
	private static final String BAD_DELETE = "No se pudo eliminar, intente de nuevo";
	private static final String DELETE_SUCCESSFULL = "Se elimino satisfatoriamente el cliente seleccionado";

	
	public AdministradorListener(AdministradorWindow adminW, ManejoEmpleadosPanel manejoEmpleadoPanel, 
			PolideportivoPersistencia poliP, VentanaConsultaEmpleados vCE) {
		this.adminW = adminW;
		this.manejoEmpleadoPanel = manejoEmpleadoPanel;
		this.poliP = poliP;
		this.vCE = vCE;
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
			}else if(e.getActionCommand().equals(ManejoEmpleadosPanel.BUTTON_BUSCAR)) {
				String dni = manejoEmpleadoPanel.getDniModificar();
				Empleado values;
				
				if(dni.isEmpty()) {
					new OutputMessages(1, EMPTY_DNI);

				}else {
					values = poliP.getAllValuesEmpleado(dni);
					manejoEmpleadoPanel.deshabilitarModificar(false);
					
					manejoEmpleadoPanel.setTextModificar(values);
				}
			}else if(e.getActionCommand().equals(ManejoEmpleadosPanel.BUTTON_MODIFICAR)) {
				Empleado values = manejoEmpleadoPanel.getValues(false);
				
				if(!Comprobaciones.direccion(values.getDireccion())) {
					new OutputMessages(0, Comprobaciones.ERROR_DIRECCION);
				}else if(!Comprobaciones.nombre(values.getApenom())){
					new OutputMessages(0, Comprobaciones.ERROR_NOMBRE);
				}else if(!Comprobaciones.correo(values.getCorreo())){
					new OutputMessages(0, Comprobaciones.ERROR_CORREO);
				}else if(!Comprobaciones.telefono(values.getTelefono())){
					new OutputMessages(0, Comprobaciones.ERROR_TELEFONO);
				}else if(values.getPass().isEmpty()) {
					new OutputMessages(0, Comprobaciones.ERROR_PASS);	
				}else{
					boolean modified = poliP.modifyEmpleado(values);
					
					if(!modified) {
						new OutputMessages(0, BAD_INSERTION);
					}else {
						new OutputMessages(1, INSERTION_SUCCESSFULL);
						manejoEmpleadoPanel.clearAnnadir();
						manejoEmpleadoPanel.clearModificar();
						manejoEmpleadoPanel.deshabilitarModificar(true);
					}
				}
			}else if(e.getActionCommand().equals(ManejoEmpleadosPanel.BUTTON_ELIMINAR)) {
				String dni = manejoEmpleadoPanel.getDniEliminar();
				
				if(!dni.isEmpty()) {
					if(OutputMessages.confirm(ASK_DELETE) == 0) {
						boolean eliminated = poliP.deleteEmpleado(dni);
						
						if(!eliminated) {
							new OutputMessages(0, BAD_DELETE);
						}else {
							new OutputMessages(1, DELETE_SUCCESSFULL);
							manejoEmpleadoPanel.clearEliminar();
						}
					}
				}
			}else if(e.getActionCommand().equals(ManejoEmpleadosPanel.BUTTON_ELIMINAR_ALL)) {
				if(OutputMessages.confirm(ASK_DELETE) == 0) {
					boolean eliminated = poliP.deleteAllEmpleado();
					
					if(!eliminated) {
						new OutputMessages(0, BAD_DELETE);
					}else {
						new OutputMessages(1, DELETE_SUCCESSFULL);
						manejoEmpleadoPanel.clearEliminar();
					}
				}
			}
			else if(e.getActionCommand().equals(VentanaConsultaEmpleados.BUTTON_RECARGAR)) {
				vCE.removeData();
				ArrayList<Empleado> values = poliP.getAllEmpleado();
				
				if(!values.isEmpty()) {
					vCE.setVisible(true);
					
					for(Empleado i : values) {
						vCE.insertData(i);
					}
					
					vCE.deshabilitar(false);
				}else {
					vCE.deshabilitar(true);
				}
			}else if(e.getActionCommand().equals(VentanaConsultaEmpleados.BUTTON_SALIR)) {
				vCE.dispose();
			}
			
			
			else if(e.getSource().equals(manejoEmpleadoPanel.getLimpiarAnnadir())) {
				manejoEmpleadoPanel.clearAnnadir();
			}else if(e.getSource().equals(manejoEmpleadoPanel.getLimpiarModificar())) {
				manejoEmpleadoPanel.clearModificar();
				manejoEmpleadoPanel.deshabilitarModificar(true);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		vCE.setVisible(true);
		vCE.deshabilitar(true);
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
