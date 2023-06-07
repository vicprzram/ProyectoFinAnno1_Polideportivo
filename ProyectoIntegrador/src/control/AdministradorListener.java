package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.administrador.AdministradorWindow;

public class AdministradorListener implements ActionListener {

	private AdministradorWindow adminW;
	
	public AdministradorListener(AdministradorWindow adminW) {
		this.adminW = adminW;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals(AdministradorWindow.ITEM_EMPLEADOS)) {
				//void
			}else if(e.getActionCommand().equals(AdministradorWindow.ITEM_INSTALACIONES)) {
				//void
			}else if(e.getActionCommand().equals(AdministradorWindow.ITEM_CLASE)) {
				//void
			}
		}
	}
	
}
