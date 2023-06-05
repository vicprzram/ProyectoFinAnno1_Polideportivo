package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import view.EmpleadoWindow;
import view.PanelRegistroUsuario;

public class EmpleadoListener implements ActionListener {
	
	private EmpleadoWindow empleadoWindow;
	
	public EmpleadoListener(EmpleadoWindow empleadoWindow, PanelRegistroUsuario panelRegistroUsuario) {
		this.empleadoWindow = empleadoWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			//Items del menu
		}else if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals(PanelRegistroUsuario.BUTTON_ANNADIR)) {
				System.out.println("a");
			}
		}
	}
}
