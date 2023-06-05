package main;

import view.MainWindow;
import control.MainListener;

public class app {
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainWindow mainWindow = new MainWindow();
				
				MainListener mainListener = new MainListener(mainWindow);
				
				mainWindow.addListener(mainListener);
				mainWindow.setVisible(true);
			}
			
		});
	}
}
