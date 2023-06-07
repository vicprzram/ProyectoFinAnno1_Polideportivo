package control;
//----------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
//----------------------------------
import db.PolideportivoPersistencia;
import model.Empleado;
import view.administrador.AdministradorWindow;
import view.empleado.EmpleadoWindow;
import view.empleado.PanelInicioEmpleado;
import view.principal.MainWindow;
import view.principal.PanelInicioSesion;
import utilities.OutputMessages;
//----------------------------------

public class MainListener implements ActionListener {

	private MainWindow mainWindow;
	private PanelInicioSesion panelInicioSesion;
	private PolideportivoPersistencia polideportivoPersistencia;
	private EmpleadoWindow empleWindow;
	private PanelInicioEmpleado panelInicioEmpleado;
	private AdministradorWindow adminW;
	
	private int counter;
	
	private static final String EXIT_CONFIRM = "¿Seguro que quieres salir?";
	private static final String EMPTY_DATA = "No se pueden dejar valores en blanco, vuelva a intentar";
	private static final String NO_EXISTS = "No existe el usuario insertado, vuelva a intentar";
	private static final String TOO_MANY_FAILURES = "Por seguridad de la aplicacion se cerrará, ha realizado 3 intentos";
	private static final String FOUND = "Se ha encontrado el usuario";
	private static final String ADMINISTRADOR = "⛔😈 Bienvenido administrador 😈⛔";
	
	public MainListener(MainWindow mainWindow, PanelInicioSesion panelInicioSesion, 
			PolideportivoPersistencia polideportivoPersistencia, EmpleadoWindow empleWindow,
			PanelInicioEmpleado panelInicioEmpleado, AdministradorWindow adminW) {
		
		counter = 0;
		
		this.mainWindow = mainWindow;
		this.panelInicioSesion = panelInicioSesion;
		this.polideportivoPersistencia = polideportivoPersistencia;
		this.empleWindow = empleWindow;
		this.panelInicioEmpleado = panelInicioEmpleado;
		this.adminW = adminW;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(MainWindow.ITEM_INICIO)) {
				//void
			}else if(e.getActionCommand().equals(MainWindow.ITEM_HORARIO)) {
				//void
			}else if(e.getActionCommand().equals(MainWindow.ITEM_RANKING)) {
				//void
			}else if(e.getActionCommand().equals(MainWindow.ITEM_SALIR)) {
		
				if(OutputMessages.confirm(EXIT_CONFIRM) == 0) {
					System.exit(0);
				}
			}
		}else if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals(PanelInicioSesion.BUTTON_INICIAR_SESION)) {

				Empleado values = panelInicioSesion.getValues();
				
				if(!values.getDni().isEmpty() && !values.getPass().isEmpty()) {
					String existe = this.polideportivoPersistencia.empleadoExists(values);
					
					if(existe.equals("Administrativo")) {
						new OutputMessages(1, FOUND);
						mainWindow.dispose();
						empleWindow.setVisible(true);
						
						values = this.polideportivoPersistencia.getAllValuesEmpleado(values.getDni());
						panelInicioEmpleado.cambiarTexto(values);
						empleWindow.cargarPanel(panelInicioEmpleado);
					}else if(existe.equals("Administrador")) {
						new OutputMessages(1, ADMINISTRADOR);
						this.adminW.setVisible(true);
						mainWindow.dispose();
					}else {
						new OutputMessages(0, NO_EXISTS);
						counter++;
						//TODO: estaría guay mostrarle al usuario cuantos intentos le quedan
						if(counter == 3) {
							new OutputMessages(1, TOO_MANY_FAILURES);
							System.exit(0);
						}
					}
				}else {
					new OutputMessages(0, EMPTY_DATA);
				}
			}
		}else if(e.getSource() instanceof JCheckBox) {
			if(e.getActionCommand().equals(PanelInicioSesion.CHECK_CONTRASENA)) {
				if(panelInicioSesion.getCheckValue()) {
					panelInicioSesion.showContrasena(0);
				}else {
					panelInicioSesion.showContrasena(1);
				}
			}
		}
	}

}
