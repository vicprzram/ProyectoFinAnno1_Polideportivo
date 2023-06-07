package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comprobaciones {
	
	public static final String ERROR_DNI = "DNI erroneo, se requieren 8 caracteres, con 8 numeros y una letra";
	public static final String ERROR_CORREO = "CORREO erroneo, se requiere un correo valido";
	public static final String ERROR_DIRECCION = "DIRECCION erroneo, se requiere que empieze por C o AV";
	public static final String ERROR_NOMBRE = "NOMBRE erroneo, se requiere nombre valido";
	public static final String ERROR_TELEFONO = "TELEFONO erroneo, se requiere telefono valido";
	
	public static boolean dni(String dni) {
		Pattern pattern = Pattern.compile("[0-9]{8}[A-Z a-z]");
		Matcher match = pattern.matcher(dni);
		if(match.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean correo(String correo) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
		Matcher match = pattern.matcher(correo);
		if(match.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean direccion(String direccion) {
		Pattern pattern = Pattern.compile("^(C/|Av/)[a-zA-Z]+$");
		Matcher match = pattern.matcher(direccion);
		if(match.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean nombre(String nombre) {
		Pattern pattern = Pattern.compile("^([A-ZÁÉÍÓÚÑa-zñáéíóúñ]{1,}'?-?[A-ZÁÉÍÓÚÑa-zñáéíóú]+[\\s]*)+$");
		Matcher match = pattern.matcher(nombre);
		
		if(match.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean telefono(String telefono) {
		Pattern pattern = Pattern.compile("^(\+34|0034|34)?[89]\d{8}$");
		Matcher match = pattern.matcher(telefono);
		if(match.find()) {
			return true;
		}else {
			return false;
		}
	}
}
