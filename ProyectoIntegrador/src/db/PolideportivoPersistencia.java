package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Cliente;
import model.Instalacion;
import model.Reserva;

public class PolideportivoPersistencia {
	private static final String NOM_COL_CI_DIA = "DIA";
	private AccesoDB acceso;
	private static final String NOM_TB_DEPORTE = "DEPORTE";
	private static final String NOM_COL_DEP_NOMBRE = "NOMBRE";
	private static final String NOM_TB_CI = "CLIENTE_INSTALACION";
	
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
				e.printStackTrace();
			}
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
				e.printStackTrace();
			}
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
				listaRegistros.add(new Reserva(clienteActual, new Instalacion(rslt.getInt("ID_INSTALACION"), rslt.getString("DEPORTE"),rslt.getString("TIPO"), null, null), 0, rslt.getString("DIA"), rslt.getString("HORA"), 0, false));
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
				e.printStackTrace();
			}
		}
		
		return listaRegistros;
	}
}
