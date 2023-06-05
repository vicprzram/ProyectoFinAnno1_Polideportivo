package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainWindow;
import utilities.OutputMessages;

public class MainListener implements ActionListener {

	private MainWindow mainWindow;
	private static final String EXIT_CONFIRM = "¿Seguro que quieres salir?";
	
	public MainListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
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
	}

}
