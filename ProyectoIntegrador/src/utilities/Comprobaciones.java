package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comprobaciones {
	public static boolean dni(String dni) {
		Pattern pattern = Pattern.compile("[0-9]{8}[A-Z a-z]");
		Matcher match = pattern.matcher(dni);
		if(match.find()) {
			return true;
		}else {
			new OutputMessages(0, "El DNI introducido no es válido");
			return false;
		}
	}
	
	public static boolean correo(String correo) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
		Matcher match = pattern.matcher(correo);
		if(match.find()) {
			return true;
		}else {
			new OutputMessages(0, "El correo introducido no es válido");
			return false;
		}
	}
	
	public static boolean direccion(String direccion) {
		Pattern pattern = Pattern.compile("^(C|Av)\\\\s\\\\d{2}\\\\s#\\\\d{2}-\\\\d{2}\\\\s[a-zA-Z\\\\s]+$");
		Matcher match = pattern.matcher(direccion);
		if(match.find()) {
			return true;
		}else {
			new OutputMessages(0, "La dirección introducida no es válida");
			return false;
		}
	}
}
