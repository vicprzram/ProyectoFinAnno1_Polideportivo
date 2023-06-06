package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilities.OutputMessages;

import model.Cliente;
import model.Instalacion;
import model.Reserva;

public class PolideportivoPersistencia {
	private static final String NOM_COL_CI_DIA = "DIA";
	private AccesoDB acceso;

	private static final String NOM_TB_DEPORTE = "DEPORTE";
	private static final String NOM_COL_DEP_NOMBRE = "NOMBRE";
	private static final String NOM_TB_CI = "CLIENTE_INSTALACION";

	private static final String ERROR_CONEXIONES = "Ha habido un error en el manejo de la base de datos, compruebe conexiones";
	private static final String ERROR = "Ha habido un error en el manejo de la base de datos, consulte al administrador";
	
	private String NOM_TB_EMPLEADO = "EMPLEADO";
	private String NOM_COL_EMP_DNI = "DNI";
	private String NOM_COL_EMP_PASS = "PASS";

	
	public PolideportivoPersistencia() {
		acceso = new AccesoDB();
	}
	
	public ArrayList<String> getDeportes(){
		ArrayList<String> listaDeportes = new ArrayList<>();
		listaDeportes.add("TODOS");
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
	
	public ArrayList<String> getFechas(){
		ArrayList<String> listaFechas = new ArrayList<>();
		listaFechas.add("TODAS");
		String query = "SELECT " + NOM_COL_CI_DIA + " FROM " + NOM_TB_CI;
		
		Connection con = null;
		Statement stat = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			stat = con.createStatement();
			rslt = stat.executeQuery(query);
			
			while(rslt.next()) {
				listaFechas.add(rslt.getString(NOM_COL_CI_DIA));
			}
			
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, rslt);
		}
		
		return listaFechas;
	}
	
	public ArrayList<Reserva> getRegistros(String filtroDia, String filtroHora, String filtroDeporte, String filtroUso){
		
		ArrayList<Reserva> listaRegistros = new ArrayList<>();
		
		String query = "SELECT D.NOMBRE AS \"DEPORTE\", "
				+ "I.ID AS \"ID_INSTALACION\", "
				+ "I.TIPO AS \"TIPO\" , "
				+ "C.APENOM AS \"NOMBRE\", "
				+ "CI.DIA AS \"DIA\", "
				+ "CI.HORA AS \"HORA\" "
				+ "FROM INSTALACION I, DEPORTE D, INSTALACION_DEPORTE IDEP, CLIENTE C, CLIENTE_INSTALACION CI "
				+ "WHERE I.ID= IDEP.ID_INSTALACION "
				+ "AND D.ID = IDEP.ID_DEPORTE "
				+ "AND C.DNI = CI.DNI_CLIENTE "
				+ "AND CI.ID_INSTALACION = I.ID";
		
		if(!filtroDia.equals("TODAS")) {
			query += " AND CI.DIA = '" + filtroDia + "'";
		}
		
		if(!filtroHora.equals("TODAS")) {
			query += " AND CI.HORA = '" + filtroHora + "'";
		}
		
		if(!filtroDeporte.equals("TODOS")) {
			query += " AND D.NOMBRE = '" + filtroDeporte + "'";
		}
				
		Connection con = null;
		Statement stat = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			stat = con.createStatement();
			rslt = stat.executeQuery(query);
			
			Reserva reservaActual = null;
			Cliente clienteActual = null;
			
			while(rslt.next()) {
				clienteActual = new Cliente(null, rslt.getString("NOMBRE"), null, 0);
				listaRegistros.add(
						new Reserva(clienteActual, 
								new Instalacion(
										rslt.getInt("ID_INSTALACION"), 
										rslt.getString("DEPORTE"),
										rslt.getString("TIPO"), 
										null, 
										null
								), 
								0, 
								rslt.getString("DIA"), 
								rslt.getString("HORA"), 
								0, 
								false));
			}
			
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, rslt);
		}
		
		return listaRegistros;
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
