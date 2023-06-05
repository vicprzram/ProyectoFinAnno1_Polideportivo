package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;

import db.PolideportivoPersistencia;
import view.MainWindow;
import view.PanelInicioSesion;
import utilities.OutputMessages;

public class MainListener implements ActionListener {

	private MainWindow mainWindow;
	private PanelInicioSesion panelInicioSesion;
	private PolideportivoPersistencia polideportivoPersistencia;
	
	private int counter;
	
	private static final String EXIT_CONFIRM = "¿Seguro que quieres salir?";
	private static final String EMPTY_DATA = "No se pueden dejar valores en blanco, vuelva a intentar";
	private static final String NO_EXISTS = "No existe el usuario insertado, vuelva a intentar";
	private static final String TOO_MANY_FAILURES = "Por seguridad de la aplicacion se cerrará, ha realizado 3 intentos";
	
	public MainListener(MainWindow mainWindow, PanelInicioSesion panelInicioSesion, PolideportivoPersistencia polideportivoPersistencia) {
		counter = 0;
		this.mainWindow = mainWindow;
		this.panelInicioSesion = panelInicioSesion;
		this.polideportivoPersistencia = polideportivoPersistencia;
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
				String[] values = panelInicioSesion.getValues();
				
				if(!values[0].isEmpty() && !values[1].isEmpty()) {
					boolean existe = this.polideportivoPersistencia.empleadoExists(values[0], values[1]);
					
					if(existe) {
						new OutputMessages(1, "Existe");
					}else {
						new OutputMessages(0, NO_EXISTS);
						counter++;
						
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
