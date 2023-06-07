package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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


public class AdministradorListener implements ActionListener{

	private static final String NO_INSERTION = "No se ha podido insertar, intente de nuevo";
	private static final String INSERTION_SUCCESSFULL = "Se inserto correctamnete los datos";
	
	private AdministradorWindow adminW;
	private PClases pClase;
	private ManejoEmpleadosPanel manejoEmpleadoPanel;
	private PolideportivoPersistencia poliP;
	private WindowClases wClase;
	private MainWindow mWin;

	public AdministradorListener(AdministradorWindow adminW, ManejoEmpleadosPanel manejoEmpleadoPanel, 
			PolideportivoPersistencia poliP, PClases pClase, WindowClases wClase, MainWindow mWin) {
		this.adminW = adminW;
		this.pClase = pClase;
		this.manejoEmpleadoPanel = manejoEmpleadoPanel;
		this.poliP = poliP;
		this.wClase = wClase;
		this.mWin = mWin;
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
				}else if(!Comprobaciones.nombre(values.getTelefono())){
					new OutputMessages(0, Comprobaciones.ERROR_TELEFONO);
				}else{
					boolean insertado = poliP.addEmpleado(values);
					
					if(!insertado) {
						new OutputMessages(0, NO_INSERTION);
					}else {
						new OutputMessages(1, INSERTION_SUCCESSFULL);
					}
				}
			}
		}
	}
	
}
