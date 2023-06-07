package view.administrador;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import control.AdministradorListener;
import control.ClaseListener;
import model.Clase;
import model.Empleado;
import model.Instalacion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowClases extends JFrame {
	
	private static final int ANCHO = 600;
	private static final int ALTO = 400;
	private JLabel lblDeporte;
	private JTextField txtDeporte;
	private JTextField txtDia;
	private JTextField txtHora;
	private JComboBox cmbInstalacion;
	private DefaultComboBoxModel<String> dcbmInstalacion;
	private JComboBox cmbProfesor;
	private DefaultComboBoxModel<String> dcbmProfesor;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblId;
	private JButton btnBorrar;
	
	public WindowClases() {
		init();
		centrarVentana();
	}

	private void init() {
		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		JLabel lblTitulo = new JLabel("Datos clase");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(10, 10, 225, 30);
		getContentPane().add(lblTitulo);
		
		JLabel lblInstalacion = new JLabel("Instalación");
		lblInstalacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInstalacion.setBounds(20, 95, 120, 20);
		getContentPane().add(lblInstalacion);
		
		cmbInstalacion = new JComboBox();
		cmbInstalacion.setBounds(150, 95, 388, 20);
		getContentPane().add(cmbInstalacion);
		
		dcbmInstalacion = new DefaultComboBoxModel<>();
		cmbInstalacion.setModel(dcbmInstalacion);
		
		lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeporte.setBounds(20, 50, 80, 20);
		getContentPane().add(lblDeporte);
		
		txtDeporte = new JTextField();
		txtDeporte.setEditable(false);
		txtDeporte.setBounds(110, 51, 96, 19);
		getContentPane().add(txtDeporte);
		txtDeporte.setColumns(10);
		
		JLabel lblDia = new JLabel("Día");
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDia.setBounds(216, 50, 50, 20);
		getContentPane().add(lblDia);
		
		txtDia = new JTextField();
		txtDia.setEditable(false);
		txtDia.setColumns(10);
		txtDia.setBounds(276, 51, 96, 19);
		getContentPane().add(txtDia);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHora.setBounds(382, 50, 50, 20);
		getContentPane().add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setColumns(10);
		txtHora.setBounds(442, 51, 96, 19);
		getContentPane().add(txtHora);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProfesor.setBounds(20, 135, 120, 20);
		getContentPane().add(lblProfesor);
		
		cmbProfesor = new JComboBox();
		cmbProfesor.setBounds(150, 135, 388, 20);
		getContentPane().add(cmbProfesor);
		
		dcbmProfesor =  new DefaultComboBoxModel<>();
		cmbProfesor.setModel(dcbmProfesor);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(82, 165, 85, 21);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(416, 165, 85, 21);
		getContentPane().add(btnCancelar);
		
		lblId = new JLabel("");
		lblId.setForeground(new Color(240, 240, 240));
		lblId.setEnabled(false);
		lblId.setBounds(10, 286, 45, 13);
		getContentPane().add(lblId);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(249, 165, 85, 21);
		getContentPane().add(btnBorrar);
	}
	
	private void centrarVentana() {
		setSize(600, 400);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ANCHO, ALTO);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
	}
	
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	
	public void cargarDatos(Clase clase) {
		txtDeporte.setText(clase.getDeporte());
		txtDia.setText(clase.getFecha());
		txtHora.setText(clase.getHora());
		lblId.setText(Integer.toString(clase.getId()));
		if(clase.getId() == 0) {
			btnBorrar.setEnabled(true);
		}else {
			btnBorrar.setEnabled(false);
		}
	}

	public void cargarInstalaciones(ArrayList<Instalacion> instalaciones) {
		ArrayList<String> lista = new ArrayList<>();
		for (Instalacion instalacion : instalaciones) {
			lista.add(instalacion.toString());
		}
		dcbmInstalacion.removeAllElements();
		dcbmInstalacion.addAll(lista);
		
		if(!lista.isEmpty()) {
			cmbInstalacion.setSelectedIndex(0);
			btnGuardar.setEnabled(true);
		}else {
			btnGuardar.setEnabled(false);
		}
	}
	
	public void cargarMonitores(ArrayList<Empleado> listaMonitores) {
		ArrayList<String> lista = new ArrayList<>();
		for (Empleado empl : listaMonitores) {
			lista.add(empl.getApenom() + "-" + empl.getDni());
		}
		dcbmProfesor.removeAllElements();
		dcbmProfesor.addAll(lista);
		if(!lista.isEmpty()) {
			cmbProfesor.setSelectedIndex(0);
			btnGuardar.setEnabled(true);
		}else {
			btnGuardar.setEnabled(false);
		}
	}
	
	public Clase getClase() {
		String[] datosInstalacion = cmbInstalacion.getSelectedItem().toString().split(" ");
		String[] datosEmple = cmbProfesor.getSelectedItem().toString().split("-");
		Clase clase = new Clase(Integer.parseInt(lblId.getText()), txtDia.getText(), txtHora.getText(), new Empleado(datosEmple[0], datosEmple[1]), new Instalacion(Integer.parseInt(datosInstalacion[1]), txtDeporte.getText(), datosInstalacion[0]), txtDeporte.getText());
		
		return clase;
	}
	
	public void setListener(ClaseListener l) {
		btnCancelar.addActionListener(l);
		btnGuardar.addActionListener(l);
		btnBorrar.addActionListener(l);
	}
}
