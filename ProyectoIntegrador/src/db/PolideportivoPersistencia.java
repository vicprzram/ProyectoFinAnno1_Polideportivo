package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilities.OutputMessages;

public class PolideportivoPersistencia {
	private AccesoDB acceso;
	private static final String ERROR_CONEXIONES = "Ha habido un error en el manejo de la base de datos, compruebe conexiones";
	private static final String ERROR = "Ha habido un error en el manejo de la base de datos, consulte al administrador";
	
	private String NOM_TB_DEPORTE = "DEPORTE";
	private String NOM_COL_DEP_NOMBRE = "NOMBRE";
	
	private String NOM_TB_EMPLEADO = "EMPLEADO";
	private String NOM_COL_EMP_DNI = "DNI";
	private String NOM_COL_EMP_PASS = "PASS";

	
	public PolideportivoPersistencia() {
		acceso = new AccesoDB();
	}
	
	public ArrayList<String> getDeportes(){
		ArrayList<String> listaDeportes = new ArrayList<>();
		String query = "SELECT " + NOM_COL_DEP_NOMBRE + " FROM " + NOM_TB_DEPORTE;
		
		Connection con = null;
		Statement stat = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			stat = con.createStatement();
			rslt = stat.executeQuery(query);
			
			while(rslt.next()) {
				listaDeportes.add(rslt.getString(NOM_COL_DEP_NOMBRE));
			}
			
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, rslt);
		}
		
		return listaDeportes;
	}
	
	public boolean empleadoExists(String dni, String pass) {
		
		dni = dni.toLowerCase();
		pass = pass.toLowerCase();
		
		String query = "SELECT " + NOM_COL_EMP_DNI + ", " + NOM_COL_EMP_PASS + " FROM " + NOM_TB_EMPLEADO;
		boolean retornar = false;
		
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			rslt = stat.executeQuery();
			
			while(rslt.next()) {
				if(rslt.getString(NOM_COL_EMP_DNI).toLowerCase().equals(dni) && rslt.getString(NOM_COL_EMP_PASS).toLowerCase().equals(pass)) {
					retornar = true;
				}
			}
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, rslt);
		}
		
		return retornar;
	}
	
	private void cerrarConexiones(Connection con, Statement stat, ResultSet rslt) {
		try {
			if(rslt != null) {
				rslt.close();
			}
			if(stat != null) {
				stat.close();
			}
			if(con != null) {
				con.close();
			}
		} catch (Exception e) {
			new OutputMessages(0, ERROR_CONEXIONES);
			e.printStackTrace();
		}
	}
}
