package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PolideportivoPersistencia {
	private AccesoDB acceso;
	private String NOM_TB_DEPORTE = "DEPORTE";
	private String NOM_COL_DEP_NOMBRE = "NOMBRE";
	
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
			// TODO: handle exception
			e.printStackTrace();
		}finally {
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
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return listaDeportes;
	}
}
