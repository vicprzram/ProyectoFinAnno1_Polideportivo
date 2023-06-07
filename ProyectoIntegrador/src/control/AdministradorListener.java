package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import db.PolideportivoPersistencia;
import model.Clase;
import utilities.OutputMessages;

import utilities.*;
import model.Empleado;

import view.administrador.AdministradorWindow;

import view.administrador.PClases;
import view.administrador.WindowClases;
import view.principal.MainWindow;
import view.administrador.ManejoEmpleadosPanel;
import view.administrador.VentanaConsultaEmpleados;



public class AdministradorListener implements ActionListener, MouseListener {

	private AdministradorWindow adminW;
	private ManejoEmpleadosPanel manejoEmpleadoPanel;
	private PolideportivoPersistencia poliP;
	private VentanaConsultaEmpleados vCE;
	private PClases pClase;
	private WindowClases wClase;
	private MainWindow mWin;
	
	private static final String EMPTY_DNI = "El campo dni no puede dejarse vacio, intente de nuevo";
	private static final String NO_INSERTION = "No se ha podido insertar, intente de nuevo";
	private static final String INSERTION_SUCCESSFULL = "Se inserto correctamnete los datos";
	private static final String BAD_INSERTION = "No insertaron los datos, intente de nuevo";
	private static final String ASK_DELETE = "¿Seguro que quiere eliminar lo seleccionado?";
	private static final String BAD_DELETE = "No se pudo eliminar, intente de nuevo";
	private static final String DELETE_SUCCESSFULL = "Se elimino satisfatoriamente el cliente seleccionado";
	private static final String EMPTY_FIELDS = "Los campos no pueden dejarse vacios, intente de nuevo";

	
	
	

	public AdministradorListener(AdministradorWindow adminW, ManejoEmpleadosPanel manejoEmpleadoPanel,
			PolideportivoPersistencia poliP, PClases pClase, WindowClases wClase, MainWindow mWin, VentanaConsultaEmpleados vCE) {

		this.adminW = adminW;
		this.pClase = pClase;
		this.manejoEmpleadoPanel = manejoEmpleadoPanel;
		this.poliP = poliP;
		this.wClase = wClase;
		this.mWin = mWin;

		this.vCE = vCE;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(AdministradorWindow.ITEM_EMPLEADOS)) {
				adminW.cargarPanel(manejoEmpleadoPanel);
			}else if(e.getActionCommand().equals(AdministradorWindow.ITEM_CLASE)) {
				adminW.cargarPanel(pClase);
				pClase.cargarDeportes(poliP.getDeportes());
				cargarTareas();
			}else if(e.getActionCommand().equals(AdministradorWindow.ITEM_SESION)) {
				if(OutputMessages.confirm("Se va a cerrar la sesión, ¿quiere continuar?") == 0) {
					adminW.dispose();
					mWin.setVisible(true);
				}
				
			}
		}else if(e.getSource() instanceof JButton) {
			if(e.getSource() == pClase.getBtnConsultar()) {
				cargarTareas();
			}else if(e.getSource() == pClase.getBtnEditar()) {
				Clase clase = pClase.getSelectedClase();
				if(clase != null) {
					wClase.setVisible(true);
					wClase.cargarInstalaciones(poliP.getInstalaciones(clase.getDeporte()));
					wClase.cargarMonitores(poliP.getMonitores());
					wClase.cargarDatos(clase);
				}else {
					new OutputMessages(0, "Debes seleccionar una celda");
				}
			}else if(e.getActionCommand().equals(ManejoEmpleadosPanel.BUTTON_ANNADIR)) {
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
				}else {
					new OutputMessages(0, EMPTY_FIELDS);
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
					new OutputMessages(1, "Ni hay datos, agrege para continuar");
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

	private void cargarTareas() {
		ArrayList<Clase> listaClases = poliP.getListaClases(pClase.getDeporte(), "TODAS");
		pClase.cargarClases(listaClases);
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
