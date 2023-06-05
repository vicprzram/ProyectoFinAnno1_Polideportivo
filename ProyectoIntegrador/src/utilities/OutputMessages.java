package utilities;

import javax.swing.JOptionPane;

public class OutputMessages {
	
	private int value;
	private String text;
	
	public OutputMessages(int value, String text) {
		this.value = value;
		this.text = text;
		execute();
	}
	
	private void execute() {
		switch(this.value) {
		
			//Errores
			case 0:
				JOptionPane.showMessageDialog(null, text, "ERROR", JOptionPane.OK_OPTION);
				break;

		}
	}
	
	public static int confirm(String text) {
		return JOptionPane.showConfirmDialog(null, text, "CONFIRM", JOptionPane.YES_NO_OPTION);
	}
}
