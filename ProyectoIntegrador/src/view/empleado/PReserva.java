package view.empleado;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import control.EmpleadoListener;
import model.Cliente;
import model.Instalacion;
import model.Reserva;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PReserva extends JPanel {
	public static final String BTN_BUSCAR = "Buscar";
	private JTextField txtDNI;
	private JLabel lblApeNom;
	private JButton btnBuscar;
	private JComboBox cmbDeporte;
	private DefaultComboBoxModel<String> dcbmDeporte;
	private JTextField txtApeNom;
	private JTextField txtDireccion;
	private JLabel lblTelefono;
	private JTextField txtTelef;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JLabel lblReserva;
	private JComboBox cmbFecha;
	private DefaultComboBoxModel<String> dcbmFecha;
	private JComboBox cmbHora;
	private static final String[] HORAS = {
			"TODAS",
			"9:00",
			"10:00",
			"11:00",
			"12:00",
			"13:00",
			"14:00",
			"15:00",
			"16:00",
			"17:00",
			"18:00",
			"19:00",
			"20:00"}; 
	private DefaultComboBoxModel<String> dcbmHora;
	private JScrollPane scrpTabla;
	private JTable tblReservas;
	private DefaultTableModel dtm;
	private static final String[] HEADER_TABLA = {"INSTALACIÓN", "FECHA", "HORA"};
	private JButton btnConsultar;
	public PReserva() {
		init();
		cargarFechas();
		cargarHoras();
	}
	
	private void init() {
		JLabel lblTitulo = new JLabel("Reserva de pistas");
		lblTitulo.setBounds(10, 6, 225, 29);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(103, 45, 45, 20);
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtDNI = new JTextField();
		txtDNI.setBounds(214, 45, 386, 20);
		txtDNI.setColumns(10);
		
		btnBuscar = new JButton(BTN_BUSCAR);
		btnBuscar.setBounds(633, 45, 102, 20);
		
		JLabel lblCliente = new JLabel("Datos del cliente:");
		lblCliente.setBounds(20, 76, 129, 17);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblApeNom = new JLabel("");
		lblApeNom.setBounds(82, 73, 67, 20);
		lblApeNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(54, 253, 50, 20);
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cmbDeporte = new JComboBox();
		cmbDeporte.setBounds(114, 253, 120, 21);
		cmbDeporte.setEnabled(false);
		
		dcbmDeporte = new DefaultComboBoxModel<>();
		setLayout(null);
		add(lblDNI);
		add(txtDNI);
		add(lblTitulo);
		add(btnBuscar);
		add(lblDeporte);
		add(cmbDeporte);
		add(lblCliente);
		add(lblApeNom);
		
		JLabel lblNombre = new JLabel("Nombre y apellidos");
		lblNombre.setBounds(54, 103, 150, 20);
		add(lblNombre);
		
		txtApeNom = new JTextField();
		txtApeNom.setEditable(false);
		txtApeNom.setBounds(214, 103, 386, 20);
		add(txtApeNom);
		txtApeNom.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Dirección");
		lblDireccion.setBounds(54, 133, 150, 20);
		add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(214, 133, 386, 20);
		add(txtDireccion);
		
		lblTelefono = new JLabel("Teléfono");
		lblTelefono.setBounds(54, 163, 150, 20);
		add(lblTelefono);
		
		txtTelef = new JTextField();
		txtTelef.setEditable(false);
		txtTelef.setColumns(10);
		txtTelef.setBounds(214, 163, 386, 20);
		add(txtTelef);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(54, 193, 150, 20);
		add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(214, 193, 386, 20);
		add(txtCorreo);
		
		lblReserva = new JLabel("Datos de la reserva:");
		lblReserva.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReserva.setBounds(20, 223, 200, 20);
		add(lblReserva);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(244, 253, 50, 20);
		add(lblFecha);
		
		cmbFecha = new JComboBox();
		cmbFecha.setEnabled(false); 
		cmbFecha.setBounds(304, 253, 120, 21);
		add(cmbFecha);
		
		dcbmFecha = new DefaultComboBoxModel<>();
		cmbFecha.setModel(dcbmFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHora.setBounds(434, 253, 50, 20);
		add(lblHora);
		
		cmbHora = new JComboBox();
		cmbHora.setEnabled(false);
		cmbHora.setBounds(494, 253, 120, 21);
		add(cmbHora);
		
		scrpTabla = new JScrollPane();
		scrpTabla.setBounds(20, 283, 715, 216);
		scrpTabla.setVisible(false);
		add(scrpTabla);
		
		tblReservas = new JTable();
		scrpTabla.setViewportView(tblReservas);
		
		configTabla();
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(631, 253, 104, 21);
		btnConsultar.setEnabled(false);
		add(btnConsultar);
	}
	
	
	private void configTabla() {
		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblReservas.setModel(dtm);
		for (int i = 0; i < HEADER_TABLA.length; i++) {
			dtm.addColumn(HEADER_TABLA[i]);
		}
	}

	public void cargarDeportes(ArrayList<String> lista) {
		dcbmDeporte.removeAllElements();
		lista.remove("TODOS");
		dcbmDeporte.addAll(lista);
		cmbDeporte.setModel(dcbmDeporte);
		cmbDeporte.setSelectedIndex(0);
	}
	
	private void cargarFechas() {
		LocalDate fechaDate = LocalDate.now();
		DateTimeFormatter fechaFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaString = "";
		ArrayList<String> listaFechas = new ArrayList<>();
		listaFechas.add("TODAS");
		for(int i = 0; i < 7; i++) {
			fechaString = fechaFormat.format(fechaDate.plusDays(i));
			listaFechas.add(fechaString);
		}
		dcbmFecha.removeAllElements();
		dcbmFecha.addAll(listaFechas);
		cmbFecha.setSelectedIndex(0);
		
	}
	
	private void cargarHoras() {
		dcbmHora = new DefaultComboBoxModel<>(HORAS);
		cmbHora.setModel(dcbmHora);
	}
	public void setListener(EmpleadoListener empleadoListener) {
		// TODO Auto-generated method stub
		btnBuscar.addActionListener(empleadoListener);
		btnConsultar.addActionListener(empleadoListener);
		
	}
	
	public String getDNI() {
		return txtDNI.getText().trim();
	}

	public void cargarCliente(Cliente cliente) {
		txtApeNom.setText(cliente.getApenom());
		txtDireccion.setText(cliente.getDireccion());
		txtTelef.setText(cliente.getTelefono());
		txtCorreo.setText(cliente.getCorreo());
	}
	
	public void setDefault() {
		txtApeNom.setText("");
		txtDireccion.setText("");
		txtTelef.setText("");
		txtCorreo.setText("");
	}
	
	public void activarComponentes() {
		cmbDeporte.setEnabled(true);
		cmbFecha.setEnabled(true);
		cmbHora.setEnabled(true);
		btnBuscar.setEnabled(false);
		txtDNI.setEditable(false);
		btnConsultar.setEnabled(true);
	}

	public JButton getBtnConsultar() {
		return btnConsultar;
	}
	
	public String getDeporte() {
		return cmbDeporte.getSelectedItem().toString();
	}
	
	public String getFecha() {
		return cmbFecha.getSelectedItem().toString();
	}
	public String getHora() {
		return cmbHora.getSelectedItem().toString();
	}
	
	public void visibilidadTabla(boolean b) {
		scrpTabla.setVisible(b);
	}
	
	public void cargarReservasDisponibles(ArrayList<Reserva> reservas, ArrayList<Instalacion> instalaciones) {
		String fecha = getFecha();
		String hora = getHora();
		ArrayList<Reserva> reservasDisponibles = new ArrayList<>();
				
		if(fecha.equals("TODAS")) {
			if(hora.equals("TODAS")) {
				for (int i = 1; i < HORAS.length; i++) {
					for(int j = 1; j < dcbmFecha.getSize(); j++) {
						for (Instalacion instalacion : instalaciones) {
							reservasDisponibles.add(new Reserva(instalacion, dcbmFecha.getElementAt(j), HORAS[i]));
						}
					}
				}
			}else {
				for(int j = 1; j < dcbmFecha.getSize(); j++) {
					for (Instalacion instalacion : instalaciones) {
						reservasDisponibles.add(new Reserva(instalacion, dcbmFecha.getElementAt(j), hora));
					}
				}
			}
		}else{
			if(hora.equals("TODAS")) {
				for (int i = 1; i < HORAS.length; i++) {
					for (Instalacion instalacion : instalaciones) {
						reservasDisponibles.add(new Reserva(instalacion, fecha, HORAS[i]));
					}
				}
			}else {
				for (Instalacion instalacion : instalaciones) {
					reservasDisponibles.add(new Reserva(instalacion, fecha, hora));
				}
			}
		}
		
		Reserva reTemp = null; 
		for(Reserva reserva : reservas) {
			reTemp = new Reserva(reserva.getInstalacion(), reserva.getDia(), reserva.getHora());
			reservasDisponibles.remove(reTemp);
		}
		
		dtm.getDataVector().clear();
		for(Reserva reTabla : reservasDisponibles) {
			dtm.addRow(reTabla.getRowReserva());
		}
	}
}
