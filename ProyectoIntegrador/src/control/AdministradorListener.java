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
import model.Cliente;
import model.Empleado;

import view.administrador.AdministradorWindow;

import view.administrador.PClases;
import view.administrador.WindowClases;
import view.principal.MainWindow;
import view.administrador.ManejoEmpleadosPanel;
import view.administrador.VentanaConsultaEmpleados;
import view.empleado.PanelManejoUsuarios;


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
			}else if(e.getActionCommand().equals(AdministradorWindow.ITEM_INSTALACIONES)) {
				//void
			}else if(e.getActionCommand().equals(AdministradorWindow.ITEM_CLASE)) {
				//void
				adminW.cargarPanel(pClase);
				pClase.cargarDeportes(poliP.getDeportes());
			}else if(e.getActionCommand().equals(AdministradorWindow.ITEM_SESION)) {
				if(OutputMessages.confirm("Se va a cerrar la sesión, ¿quiere continuar?") == 0) {
					adminW.dispose();
					mWin.setVisible(true);
				}
				
			}
		}else if(e.getSource() instanceof JButton) {
			if(e.getSource() == pClase.getBtnConsultar()) {
				ArrayList<Clase> listaClases = poliP.getListaClases(pClase.getDeporte());
				pClase.cargarClases(listaClases);
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
