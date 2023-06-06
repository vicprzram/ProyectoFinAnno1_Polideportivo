package view;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import db.PolideportivoPersistencia;

import javax.swing.JTextField;

import control.EmpleadoListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class PReserva extends JPanel {
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
	private JComboBox cmbHora;
	private static final String[] HORAS = {
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
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(633, 45, 81, 20);
		
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
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHora.setBounds(434, 253, 50, 20);
		add(lblHora);
		
		cmbHora = new JComboBox();
		cmbHora.setEnabled(false);
		cmbHora.setBounds(494, 253, 120, 21);
		add(cmbHora);
	}
	
	
	public void cargarDeportes(ArrayList<String> lista) {
		dcbmDeporte.addAll(lista);
		cmbDeporte.setModel(dcbmDeporte);
		cmbDeporte.setSelectedIndex(0);
	}
	
	private void cargarFechas() {
		// TODO Auto-generated method stub
		
	}
	
	private void cargarHoras() {
		dcbmHora = new DefaultComboBoxModel<>(HORAS);
		cmbHora.setModel(dcbmHora);
	}
	public void setListener(EmpleadoListener empleadoListener) {
		// TODO Auto-generated method stub
		
	}
}
