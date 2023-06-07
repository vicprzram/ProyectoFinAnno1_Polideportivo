package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilities.OutputMessages;
import model.Clase;
import model.Cliente;
import model.Empleado;
import model.Instalacion;
import model.Reserva;

public class PolideportivoPersistencia {
	private AccesoDB acceso;

	private static final String NOM_TB_DEPORTE = "DEPORTE";
	private static final String NOM_COL_DEP_ID = "ID";
	private static final String NOM_COL_DEP_NOMBRE = "NOMBRE";
	
	private static final String NOM_TB_CI = "CLIENTE_INSTALACION";
	private static final String NOM_COL_CI_DIA = "DIA";
	private static final String NOM_COL_CI_HORA = "HORA";
	private static final String NOM_COL_CI_PAGO = "PAGO";
	private static final String NOM_COL_CI_DNI = "DNI_CLIENTE";
	private static final String NOM_COL_CI_IDI = "ID_INSTALACION";
	
	private static final String NOM_TB_EMPLEADO = "EMPLEADO";
	private static final String NOM_COL_EMP_DNI = "DNI";
	private static final String NOM_COL_EMP_PASS = "PASS";
	private static final String NOM_COL_EMP_APENOM = "APENOM";
	private static final String NOM_COL_EMP_DIRECCION = "DIRECCION";
	private static final String NOM_COL_EMP_ROL = "ROL";
	private static final String NOM_COL_EMP_CORREO = "CORREO";
	private static final String NOM_COL_EMP_TELEFONO = "TELEFONO";
	
	private static final String NOM_TB_CLIENTE = "CLIENTE";
	private static final String NOM_COL_CLI_DNI = "DNI";
	private static final String NOM_COL_CLI_APENOM = "APENOM";
	private static final String NOM_COL_CLI_DIR = "DIRECCION";
	private static final String NOM_COL_CLI_NUM_CUENTA = "NUM_CUENTA";
	private static final String NOM_COL_CLI_CORREO = "CORREO";
	private static final String NOM_COL_CLI_TLF = "TELEF";
	
	private static final String NOM_TB_INSTALACION = "INSTALACION";
	private static final String NOM_COL_INS_ID = "ID";
	private static final String NOM_COL_INS_TIPO = "TIPO";
	
	private static final String NOM_TB_INS_DEP = "INSTALACION_DEPORTE";
	private static final String NOM_COL_INS_DEP_IDI = "ID_INSTALACION";
	private static final String NOM_COL_INS_DEP_IDD = "ID_DEPORTE";
	
	private static final String NOM_TB_CLA = "CLASE";
	private static final String NOM_COL_CLA_ID = "ID";
	private static final String NOM_COL_CLA_DIA = "DIA";
	private static final String NOM_COL_CLA_HORA = "HORA";
	private static final String NOM_COL_CLA_DNIE = "DNI_EMPLE";
	private static final String NOM_COL_CLA_IDI = "ID_INSTALACION";
	
	private static final String ERROR_CONEXIONES = "Ha habido un error en el manejo de la base de datos, compruebe conexiones";
	private static final String ERROR = "Ha habido un error en el manejo de la base de datos, consulte al administrador";
	private static final String ERROR_NO_DATA = "Ha habido un error al buscar datos en la base de datos, consulte al administrador";
	
	public PolideportivoPersistencia() {
		acceso = new AccesoDB();
	}
	
	public boolean deleteAllEmpleado() {
		String query = "DELETE FROM " + NOM_TB_EMPLEADO;
		
		Connection con = null;
		PreparedStatement stat = null;
		int rslt = 0;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			rslt = stat.executeUpdate();
	
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, null);
		}
		
		if(rslt == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean deleteEmpleado(String dni) {
		String query = "DELETE FROM " + NOM_TB_EMPLEADO + " WHERE " + NOM_COL_CLI_DNI + " =?";
		
		Connection con = null;
		PreparedStatement stat = null;
		int rslt = 0;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, dni);
			rslt = stat.executeUpdate();
	
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, null);
		}
		
		if(rslt == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean modifyEmpleado(Empleado values) {
		String query = "UPDATE " + NOM_TB_EMPLEADO + " SET " + NOM_COL_EMP_APENOM + " = ?, " +
				NOM_COL_EMP_DIRECCION + " =?, " + NOM_COL_EMP_PASS + " =?, " + NOM_COL_EMP_ROL + " =?, " +
				NOM_COL_CLI_CORREO  + " =?, " + NOM_COL_EMP_TELEFONO + " =? WHERE " + NOM_COL_CLI_DNI + " =?";
		
		Connection con = null;
		PreparedStatement stat = null;
		int rslt = 0;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, values.getApenom());
			stat.setString(2, values.getDireccion());
			stat.setString(3, values.getPass());;
			stat.setString(4, values.getRol());
			stat.setString(5, values.getCorreo());
			stat.setString(6, values.getTelefono());
			stat.setString(7, values.getDni());
			rslt = stat.executeUpdate();
	
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, null);
		}
		
		if(rslt == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public ArrayList<Empleado> getAllEmpleado(){
		ArrayList<Empleado> arrayList = new ArrayList<Empleado>();
		String query = "SELECT * FROM " + NOM_TB_EMPLEADO;
		
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			rslt = stat.executeQuery();
			
			Empleado cliente;
			
			while(rslt.next()) {
				cliente = new Empleado(
						rslt.getString(NOM_COL_EMP_DNI),
						rslt.getString(NOM_COL_EMP_APENOM),
						rslt.getString(NOM_COL_EMP_PASS),
						rslt.getString(NOM_COL_EMP_DIRECCION),
						rslt.getString(NOM_COL_EMP_ROL),
						rslt.getString(NOM_COL_EMP_CORREO),
						rslt.getString(NOM_COL_EMP_TELEFONO));
				
				arrayList.add(cliente);
			}
	
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, rslt);
		}
		
		return arrayList;
	}
	
	public boolean deleteAllCliente() {
		String query = "DELETE FROM " + NOM_TB_CLIENTE;
		
		Connection con = null;
		PreparedStatement stat = null;
		int rslt = 0;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			rslt = stat.executeUpdate();
	
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, null);
		}
		
		if(rslt == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean deleteCliente(String dni) {
		String query = "DELETE FROM " + NOM_TB_CLIENTE + " WHERE " + NOM_COL_CLI_DNI + " =?";
		
		Connection con = null;
		PreparedStatement stat = null;
		int rslt = 0;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, dni);
			rslt = stat.executeUpdate();
	
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, null);
		}
		
		if(rslt == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean modifyCliente(Cliente values) {
		String query = "UPDATE " + NOM_TB_CLIENTE + " SET " + NOM_COL_CLI_APENOM + " = ?, " +
				NOM_COL_CLI_DIR + " =?, " + NOM_COL_CLI_NUM_CUENTA + " =?, " + NOM_COL_CLI_CORREO + " =?, " +
				NOM_COL_CLI_TLF + " =? WHERE " + NOM_COL_CLI_DNI + " =?";
		
		Connection con = null;
		PreparedStatement stat = null;
		int rslt = 0;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, values.getApenom());
			stat.setString(2, values.getDireccion());
			stat.setInt(3, values.getNumCuenta());
			stat.setString(4, values.getCorreo());
			stat.setString(5, values.getTelefono());
			stat.setString(6, values.getDni());
			rslt = stat.executeUpdate();
	
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, null);
		}
		
		if(rslt == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public ArrayList<Cliente> getAllClientes(){
		ArrayList<Cliente> arrayList = new ArrayList<Cliente>();
		String query = "SELECT * FROM " + NOM_TB_CLIENTE;
		
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			rslt = stat.executeQuery();
			
			Cliente cliente;
			
			while(rslt.next()) {
				cliente = new Cliente(
						rslt.getString(NOM_COL_CLI_DNI),
						rslt.getString(NOM_COL_CLI_APENOM),
						rslt.getString(NOM_COL_CLI_DIR),
						rslt.getString(NOM_COL_CLI_CORREO),
						rslt.getString(NOM_COL_CLI_TLF),
						rslt.getInt(NOM_COL_CLI_NUM_CUENTA));
				
				arrayList.add(cliente);
			}
	
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, rslt);
		}
		
		return arrayList;
	}
	
	public boolean addCliente(Cliente values) {
		String query = "INSERT INTO " + NOM_TB_CLIENTE + " VALUES (?,?,?,?,?,?)";
	
		Connection con = null;
		PreparedStatement stat = null;
		int rslt = 0;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, values.getDni());
			stat.setString(2, values.getApenom());
			stat.setString(3, values.getDireccion());
			stat.setInt(4, values.getNumCuenta());
			stat.setString(5, values.getCorreo());
			stat.setString(6, values.getTelefono());
			rslt = stat.executeUpdate();
	
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, null);
		}
		
		if(rslt == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean addEmpleado(Empleado values) {
		String query = "INSERT INTO " + NOM_TB_EMPLEADO + " VALUES (?,?,?,?,?,?,?)";
	
		Connection con = null;
		PreparedStatement stat = null;
		int rslt = 0;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, values.getDni());
			stat.setString(2, values.getApenom());
			stat.setString(3, values.getDireccion());
			stat.setString(4, values.getPass());
			stat.setString(5, values.getRol());
			stat.setString(6, values.getCorreo());
			stat.setString(7, values.getTelefono());
			rslt = stat.executeUpdate();
	
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, null);
		}
		
		if(rslt == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public Empleado getAllValuesEmpleado(String dni) {
		String query = "SELECT * FROM " + NOM_TB_EMPLEADO + " WHERE " + NOM_COL_EMP_DNI + " = ?";
		Empleado empleado = null;
		
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, dni);
			rslt = stat.executeQuery();
			
			if(rslt.next()) {
				empleado = new Empleado(
						rslt.getString(NOM_COL_EMP_DNI),
						rslt.getString(NOM_COL_EMP_APENOM),
						rslt.getString(NOM_COL_EMP_PASS),
						rslt.getString(NOM_COL_EMP_DIRECCION),
						rslt.getString(NOM_COL_EMP_ROL),
						rslt.getString(NOM_COL_EMP_CORREO),
						rslt.getString(NOM_COL_EMP_TELEFONO));
			}else {
				new OutputMessages(0, ERROR_NO_DATA);
			}
	
		} catch (Exception e) {
			new OutputMessages(0, ERROR);
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, rslt);
		}
		
		return empleado;
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
		String query = "SELECT DISTINCT " + NOM_COL_CI_DIA + " FROM " + NOM_TB_CI + " ORDER BY " + NOM_COL_CI_DIA + " ASC";
		
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
	
	public ArrayList<Reserva> getRegistros(String filtroDia, String filtroHora, String filtroDeporte){
		
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
		
		query += " ORDER BY DIA ASC, HORA DESC";
		
		Connection con = null;
		Statement stat = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			stat = con.createStatement();
			rslt = stat.executeQuery(query);
			
			Cliente clienteActual = null;
			
			while(rslt.next()) {
				clienteActual = new Cliente(null, rslt.getString("NOMBRE"), null, 0);
				listaRegistros.add(
						new Reserva(
								clienteActual, 
								new Instalacion(
										rslt.getInt("ID_INSTALACION"), 
										rslt.getString("DEPORTE"),
										rslt.getString("TIPO")
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

	
	public String empleadoExists(Empleado empleado) {
		
		String dni = empleado.getDni().toLowerCase();
		String pass = empleado.getPass().toLowerCase();
		
		String query = "SELECT " + NOM_COL_EMP_DNI + ", " + NOM_COL_EMP_PASS + ", " + NOM_COL_EMP_ROL +  " FROM " + NOM_TB_EMPLEADO;
		String retornar = null;
		
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			rslt = stat.executeQuery();
			
			while(rslt.next()) {
				if(rslt.getString(NOM_COL_EMP_DNI).toLowerCase().equals(dni) && rslt.getString(NOM_COL_EMP_PASS).toLowerCase().equals(pass)) {
					retornar = rslt.getString(NOM_COL_EMP_ROL);
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

	public Cliente getCliente(String dni) {
		Cliente cliente = null;
		String query = "SELECT * FROM " + NOM_TB_CLIENTE + " WHERE " + NOM_COL_CLI_DNI + " = ?";
		
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, dni);
			rslt = stat.executeQuery();
			
			while(rslt.next()) {
				cliente = new Cliente(
						rslt.getString(NOM_COL_CLI_DNI), 
						rslt.getString(NOM_COL_CLI_APENOM), 
						rslt.getString(NOM_COL_CLI_DIR), 
						rslt.getString(NOM_COL_CLI_CORREO), 
						rslt.getString(NOM_COL_CLI_TLF), 
						rslt.getInt(NOM_COL_CLI_NUM_CUENTA)
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, rslt);
		}
		
		return cliente;
	}

	public ArrayList<Instalacion> getInstalaciones(String deporte) {
		ArrayList<Instalacion> instaciones = new ArrayList<>();
		
		String query = "SELECT "
				+ "I." + NOM_COL_INS_ID + ","
				+ " I." + NOM_COL_INS_TIPO
				+ " FROM " + NOM_TB_INSTALACION + " I, "
				+ NOM_TB_DEPORTE + " D, "
				+ NOM_TB_INS_DEP + " IDEP"
				+ " WHERE I." + NOM_COL_INS_ID + " = " + "IDEP." + NOM_COL_INS_DEP_IDI
				+ " AND D." + NOM_COL_DEP_ID + " = IDEP." + NOM_COL_INS_DEP_IDD
				+ " AND " + NOM_COL_DEP_NOMBRE + " = ?";
		
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, deporte);
			rslt = stat.executeQuery();
		
			while(rslt.next()) {
				instaciones.add(new Instalacion(
						rslt.getInt(NOM_COL_INS_ID),
						deporte,
						rslt.getString(NOM_COL_INS_TIPO)
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, rslt);
		}
		
		return instaciones;
	}

	public int addReserva(Reserva reserva) {
		int res = 0;
		String query = "INSERT INTO " + NOM_TB_CI + " ( "
				+ NOM_COL_CI_DIA + ", "
				+ NOM_COL_CI_HORA + ", "
				+ NOM_COL_CI_PAGO + ", "
				+ NOM_COL_CI_DNI + ", "
				+ NOM_COL_CI_IDI + " ) "
				+ " VALUES (?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement stat = null;
		
		try {
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, reserva.getDia());
			stat.setString(2, reserva.getHora());
			stat.setString(3, reserva.isPago()?"Sí":"No");
			stat.setString(4, reserva.getCliente().getDni());
			stat.setInt(5, reserva.getInstalacion().getId());
			
			res = stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			res = -1;
		}finally {
			cerrarConexiones(con, stat, null);
		}
		return res;
	}
	
	public ArrayList<Clase> getListaClases(String deporte){
		ArrayList<Clase> lista = new ArrayList<>();
		
		String query = "SELECT C."
				+ NOM_COL_CLA_DIA + ", C."
				+ NOM_COL_CLA_HORA + ", E."
				+ NOM_COL_EMP_APENOM + ", I."
				+ NOM_COL_INS_ID + ", I."
				+ NOM_COL_INS_TIPO
				+ " FROM " + NOM_TB_CLA + " C, "
				+ NOM_TB_DEPORTE + " D, "
				+ NOM_TB_EMPLEADO + " E, "
				+ NOM_TB_INSTALACION + " I, "
				+ NOM_TB_INS_DEP + " IDEP"
				+ " WHERE D." + NOM_COL_DEP_NOMBRE + " = ?"
				+ " AND D." + NOM_COL_DEP_ID + " = IDEP." + NOM_COL_INS_DEP_IDD
				+ " AND C." + NOM_COL_CLA_IDI + " = IDEP." + NOM_COL_INS_DEP_IDI
				+ " AND E." + NOM_COL_EMP_DNI + " = C." + NOM_COL_CLA_DNIE;
		
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, deporte);
			rslt = stat.executeQuery();
			
			while(rslt.next()) {
				lista.add(new Clase(
						0, 
						rslt.getString(NOM_COL_CLA_DIA), 
						rslt.getString(NOM_COL_CLA_HORA), 
						new Empleado(rslt.getString(NOM_COL_EMP_APENOM)), 
						new Instalacion(
								rslt.getInt(NOM_COL_INS_ID), 
								deporte, 
								rslt.getString(NOM_COL_INS_TIPO)), 
						deporte));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cerrarConexiones(con, stat, rslt);
		}
		
		return lista;
	}

	public ArrayList<Empleado> getMonitores(){
		ArrayList<Empleado> listaMonitores = new ArrayList<>();
		
		String query = "SELECT " + NOM_COL_EMP_APENOM + ", " + NOM_COL_EMP_DNI + " FROM " + NOM_TB_EMPLEADO + " WHERE " + NOM_COL_EMP_ROL + " = ?";
		
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setString(1, "Monitor");
			rslt = stat.executeQuery();
			while(rslt.next()){
				listaMonitores.add(new Empleado(rslt.getString(NOM_COL_EMP_APENOM), rslt.getString(NOM_COL_EMP_DNI)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaMonitores;
	}

	public int addClase(Clase clase) {
		int res = 0;
		String query = "INSERT INTO " + NOM_TB_CLA + " VALUES (?,?,?,?)";
		
		Connection con = null;
		PreparedStatement stat = null;
		
		try {
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			
			stat.setString(1, clase.getFecha().toUpperCase());
			stat.setString(2, clase.getHora());
			stat.setString(3, clase.getProfesor().getDni());
			stat.setInt(4, clase.getInstalacion().getId());
			
			res = stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			res = -1;
		}finally {
			cerrarConexiones(con, stat, null);
		}
		
		return res;
	}

	public int modClase(Clase clase) {
		int res = 0;
		String query = "UPDATE " + NOM_COL_CLA_DIA + " SET " + NOM_COL_CLA_IDI + " = ?, "
				+ NOM_COL_CLA_DNIE + " = ? WHERE " + NOM_COL_CLA_DIA + " = ? AND "
				+ NOM_COL_CLA_HORA + " = ?";
		Connection con = null;
		PreparedStatement stat = null;
		
		try {
			con = acceso.getConexion();
			stat = con.prepareStatement(query);
			stat.setInt(1, clase.getInstalacion().getId());
			stat.setString(2, clase.getProfesor().getDni());
			stat.setString(3, clase.getFecha());
			stat.setString(4, clase.getHora());
			
			res = stat.executeUpdate();
		} catch (Exception e) {
			res = -1;
		}
		return res;
	}
	
}
