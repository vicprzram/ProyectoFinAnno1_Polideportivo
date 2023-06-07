package view.administrador;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import control.AdministradorListener;
import model.Cliente;
import model.Empleado;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManejoEmpleadosPanel extends JPanel {
	private JTextField tfDniAnnadir;
	private JTextField tfNombreCompletoAnnadir;
	private JTextField tfNombreCompletoModificar;
	private JTextField tfDireccionAnnadir;
	private JTextField tfDniModificar;
	private JTextField tfDireccionModificar;
	private JTextField textField_12;
	private JPasswordField passwordField;
	private JPasswordField tfPassword;
	
	private JPanel panelAnnadir, panelModificar, panelEliminar;
	private JButton btnLimpiarAnnadir, btnAadirEmpleado, btnBuscarEmpleado, btnModificarEmpleado, btnLimpiarModificar, 
		btnEliminarEmpleado, btnEliminarTodosLos;
	private JComboBox<String> comboBox, comboBoxModificar;

	private static final String[] COMBO_ROLES = {"Administrador", "Administrativo", "Monitor"};
	
	public static final String BUTTON_ANNADIR = "Añadir empleado";
	public static final String BUTTON_ELIMINAR = "Eliminar empleado";
	public static final String BUTTON_ELIMINAR_ALL = "Eliminar todos los empleado";
	public static final String BUTTON_LIMPIAR = "Limpiar";
	public static final String BUTTON_MODIFICAR = "Modificar empleado";
	public static final String BUTTON_BUSCAR = "Buscar empleado";
	
	private JLabel lblCorreo, lblConsultar;
	private JTextField tfCorreoModificar;
	private JLabel lblCorreo_1;
	private JTextField tfCorreoAnnadir;
	private JTextField tfTelefonoAnnadir;
	private JLabel lblCorreo_2;
	private JLabel lblCorreo_3;
	private JTextField tfTelefonoModificar;
	
	public ManejoEmpleadosPanel() {
		setLayout(null);
		init();
		centrarVentana();
	}
	
	private void init() {
		
		JLabel lblManejoEmpleado = new JLabel("Manejo empleados");
		lblManejoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblManejoEmpleado.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblManejoEmpleado.setBounds(10, 11, 780, 21);
		
		
		cargarAnnadir();
		cargarModificar();
		cargarEliminar();
		
		lblConsultar = new JLabel("<html><u>Consultar empleados</u></html>");
		lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar.setForeground(new Color(0, 46, 255));
		lblConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConsultar.setBackground(new Color(128, 255, 255));
		lblConsultar.setBounds(532, 348, 258, 14);
		
		
		add(lblManejoEmpleado);
		add(panelAnnadir);	
		add(panelModificar);
		add(panelEliminar);
		add(lblConsultar);
		
		deshabilitarModificar(true);
	}
	
	private void cargarEliminar() {
		panelEliminar = new JPanel();
		panelEliminar.setLayout(null);
		panelEliminar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelEliminar.setBounds(532, 38, 251, 235);
		
		
		JLabel lblEliminar = new JLabel("<html><u>Eliminar</u></html>");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEliminar.setBounds(10, 11, 231, 14);
		panelEliminar.add(lblEliminar);
		
		JLabel lblDni_2 = new JLabel("DNI:");
		lblDni_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDni_2.setBounds(10, 47, 69, 19);
		panelEliminar.add(lblDni_2);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(89, 46, 152, 20);
		panelEliminar.add(textField_12);
		
		btnEliminarEmpleado = new JButton(BUTTON_ELIMINAR);
		btnEliminarEmpleado.setBounds(10, 89, 231, 34);
		panelEliminar.add(btnEliminarEmpleado);
		
		btnEliminarTodosLos = new JButton(BUTTON_ELIMINAR_ALL);
		btnEliminarTodosLos.setBounds(10, 190, 231, 34);
		panelEliminar.add(btnEliminarTodosLos);

	}
	
	private void cargarAnnadir() {
		panelAnnadir = new JPanel();
		panelAnnadir.setLayout(null);
		panelAnnadir.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelAnnadir.setBounds(10, 38, 251, 504);
		
		JLabel lblAnnadir = new JLabel("<html><u>Añadir</u></html>");
		lblAnnadir.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnadir.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAnnadir.setBounds(10, 11, 231, 14);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDni.setBounds(10, 49, 69, 19);
		
		tfDniAnnadir = new JTextField();
		tfDniAnnadir.setBounds(89, 48, 152, 20);
		
		JLabel lblNombreCompleto = new JLabel("Nombre completo:");
		lblNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreCompleto.setBounds(10, 124, 231, 19);
		
		tfNombreCompletoAnnadir = new JTextField();
		tfNombreCompletoAnnadir.setBounds(10, 147, 231, 20);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(10, 178, 231, 19);
		
		tfDireccionAnnadir = new JTextField();
		tfDireccionAnnadir.setColumns(10);
		tfDireccionAnnadir.setBounds(10, 200, 231, 20);
		
		btnLimpiarAnnadir = new JButton(BUTTON_LIMPIAR);
		btnLimpiarAnnadir.setBounds(66, 459, 113, 34);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(10, 382, 94, 19);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(114, 383, 127, 20);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRol.setBounds(10, 352, 94, 19);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(114, 348, 127, 22);
		
		for(String i : COMBO_ROLES) {
			comboBox.addItem(i);
		}
		
		btnAadirEmpleado = new JButton(BUTTON_ANNADIR);
		btnAadirEmpleado.setBounds(10, 414, 231, 34);
		panelAnnadir.add(btnAadirEmpleado);
		
		lblCorreo_1 = new JLabel("Correo");
		lblCorreo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCorreo_1.setBounds(10, 231, 231, 19);
		panelAnnadir.add(lblCorreo_1);
		
		tfCorreoAnnadir = new JTextField();
		tfCorreoAnnadir.setColumns(10);
		tfCorreoAnnadir.setBounds(10, 253, 231, 20);
		panelAnnadir.add(tfCorreoAnnadir);
		
		lblCorreo_2 = new JLabel("Telefono");
		lblCorreo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCorreo_2.setBounds(10, 283, 231, 19);
		panelAnnadir.add(lblCorreo_2);
		
		tfTelefonoAnnadir = new JTextField();
		tfTelefonoAnnadir.setColumns(10);
		tfTelefonoAnnadir.setBounds(10, 305, 231, 20);
		panelAnnadir.add(tfTelefonoAnnadir);
		
		panelAnnadir.add(lblAnnadir);
		panelAnnadir.add(lblDni);
		panelAnnadir.add(tfDniAnnadir);
		panelAnnadir.add(lblNombreCompleto);
		panelAnnadir.add(tfNombreCompletoAnnadir);
		panelAnnadir.add(lblDireccion);
		panelAnnadir.add(tfDireccionAnnadir);
		panelAnnadir.add(btnLimpiarAnnadir);
		panelAnnadir.add(lblContrasea);
		panelAnnadir.add(passwordField);
		panelAnnadir.add(lblRol);
		panelAnnadir.add(comboBox);
		panelAnnadir.add(btnAadirEmpleado);
	}
	
	private void cargarModificar() {
		panelModificar = new JPanel();
		panelModificar.setLayout(null);
		panelModificar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelModificar.setBounds(271, 38, 251, 504);
		
		JLabel lblModificar = new JLabel("<html><u>Modificar</u></html>");
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModificar.setBounds(10, 11, 231, 14);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDni.setBounds(10, 47, 69, 19);
		
		tfDniModificar = new JTextField();
		tfDniModificar.setColumns(10);
		tfDniModificar.setBounds(89, 46, 152, 20);
		
		btnBuscarEmpleado = new JButton(BUTTON_BUSCAR);
		btnBuscarEmpleado.setBounds(10, 80, 231, 34);
		
		JLabel lblNombreCompleto = new JLabel("Nombre completo:");
		lblNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreCompleto.setBounds(10, 125, 231, 19);
		
		tfNombreCompletoModificar = new JTextField();
		tfNombreCompletoModificar.setColumns(10);
		tfNombreCompletoModificar.setBounds(10, 148, 231, 20);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(10, 179, 231, 19);
		
		tfDireccionModificar = new JTextField();
		tfDireccionModificar.setColumns(10);
		tfDireccionModificar.setBounds(10, 201, 231, 20);
		
		btnModificarEmpleado = new JButton(BUTTON_MODIFICAR);
		btnModificarEmpleado.setBounds(10, 414, 231, 34);
		
		btnLimpiarModificar = new JButton(BUTTON_LIMPIAR);
		btnLimpiarModificar.setBounds(72, 459, 113, 34);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(10, 352, 94, 19);
		lblRol.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		comboBoxModificar = new JComboBox<String>();
		comboBoxModificar.setBounds(114, 348, 127, 22);
		
		for(String i : COMBO_ROLES) {
			comboBoxModificar.addItem(i);
		}
		
		JLabel lblContrasea_1 = new JLabel("Contraseña:");
		lblContrasea_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea_1.setBounds(10, 382, 94, 19);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(114, 383, 127, 20);
		tfPassword.setEchoChar((char)0);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCorreo.setBounds(10, 232, 231, 19);
		panelModificar.add(lblCorreo);
		
		tfCorreoModificar = new JTextField();
		tfCorreoModificar.setColumns(10);
		tfCorreoModificar.setBounds(10, 254, 231, 20);
		panelModificar.add(tfCorreoModificar);
		
		lblCorreo_3 = new JLabel("Telefono");
		lblCorreo_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCorreo_3.setBounds(10, 285, 231, 19);
		panelModificar.add(lblCorreo_3);
		
		tfTelefonoModificar = new JTextField();
		tfTelefonoModificar.setColumns(10);
		tfTelefonoModificar.setBounds(10, 307, 231, 20);
		panelModificar.add(tfTelefonoModificar);
		
		panelModificar.add(lblModificar);
		panelModificar.add(lblDni);
		panelModificar.add(tfDniModificar);
		panelModificar.add(btnBuscarEmpleado);
		panelModificar.add(lblNombreCompleto);
		panelModificar.add(tfNombreCompletoModificar);
		panelModificar.add(lblDireccion);
		panelModificar.add(tfDireccionModificar);
		panelModificar.add(btnModificarEmpleado);
		panelModificar.add(btnLimpiarModificar);
		panelModificar.add(lblRol);
		panelModificar.add(comboBoxModificar);
		panelModificar.add(lblContrasea_1);
		panelModificar.add(tfPassword);
	}
	
	private void centrarVentana() {
		setSize(AdministradorWindow.ANCHO, AdministradorWindow.ALTO);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(AdministradorWindow.ANCHO, AdministradorWindow.ALTO);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
	}
	
	public void setTextModificar(Empleado values) {
		this.tfNombreCompletoModificar.setText(values.getApenom());
		this.tfDireccionModificar.setText(values.getDireccion());
		this.tfCorreoModificar.setText(values.getCorreo());
		this.tfTelefonoModificar.setText(values.getTelefono());
		this.tfPassword.setText("" + values.getPass());
	}
	
	public Empleado getValuesAnnadir() {
		
		String rol = COMBO_ROLES[this.comboBox.getSelectedIndex()];
		
		return new Empleado(
				this.tfDniAnnadir.getText(),
				this.tfNombreCompletoAnnadir.getText(),
				this.passwordField.getText(),
				this.tfDireccionAnnadir.getText(),
				rol,
				this.tfCorreoAnnadir.getText(),
				this.tfTelefonoAnnadir.getText());
	}
	
	public void addListener(AdministradorListener l) {
		this.btnAadirEmpleado.addActionListener(l);
		this.btnLimpiarAnnadir.addActionListener(l);
		this.lblConsultar.addMouseListener(l);
		this.btnEliminarEmpleado.addActionListener(l);
		this.btnEliminarTodosLos.addActionListener(l);
		this.btnModificarEmpleado.addActionListener(l);
		this.btnBuscarEmpleado.addActionListener(l);
		this.btnLimpiarModificar.addActionListener(l);
	}
	
	public void clearAnnadir() {
		this.tfDniAnnadir.setText("");
		this.tfNombreCompletoAnnadir.setText("");
		this.passwordField.setText("");
		this.tfDireccionAnnadir.setText("");
		this.comboBox.setSelectedIndex(0);
		this.tfCorreoAnnadir.setText("");
		this.tfTelefonoAnnadir.setText("");
	}
	
	public void clearModificar() {
		this.tfNombreCompletoModificar.setText("");
		this.tfDireccionModificar.setText("");
		this.tfCorreoModificar.setText("");
		this.tfTelefonoModificar.setText("");
		this.comboBoxModificar.setSelectedIndex(0);
		this.tfPassword.setText("");
		this.tfDniModificar.setText("");
	}
	
	public String getDniModificar() {
		return this.tfDniModificar.getText();
	}

	public JButton getLimpiarAnnadir() {
		return this.btnLimpiarAnnadir;
	}
	
	public JButton getLimpiarModificar() {
		return this.btnLimpiarModificar;
	}

	public void deshabilitarModificar(boolean value) {
		if(value) {
			this.tfNombreCompletoModificar.setEnabled(false);
			this.tfDireccionModificar.setEnabled(false);
			this.tfCorreoModificar.setEnabled(false);
			this.tfTelefonoModificar.setEnabled(false);
			this.tfPassword.setEnabled(false);
			this.btnModificarEmpleado.setEnabled(false);
			this.comboBoxModificar.setEnabled(false);
			this.btnLimpiarModificar.setEnabled(false);
			this.btnBuscarEmpleado.setEnabled(true);
			this.tfDniModificar.setEnabled(true);
		}else {
			this.tfNombreCompletoModificar.setEnabled(true);
			this.tfDireccionModificar.setEnabled(true);
			this.tfCorreoModificar.setEnabled(true);
			this.tfTelefonoModificar.setEnabled(true);
			this.tfPassword.setEnabled(true);
			this.btnModificarEmpleado.setEnabled(true);
			this.btnLimpiarModificar.setEnabled(true);
			this.btnBuscarEmpleado.setEnabled(false);
			this.tfDniModificar.setEnabled(false);
			this.comboBoxModificar.setEnabled(true);
		}
	}
	
	public Empleado getValues(boolean type) {
		
		if(type) {
			
			return new Empleado(
					this.tfDniAnnadir.getText(),
					this.tfNombreCompletoAnnadir.getText(),
					this.passwordField.getText(),
					this.tfDireccionAnnadir.getText(),
					COMBO_ROLES[this.comboBox.getSelectedIndex()],
					this.tfCorreoAnnadir.getText(),
					this.tfTelefonoAnnadir.getText());
		}else {
	
			
			return new Empleado(
					this.tfDniModificar.getText(),
					this.tfNombreCompletoModificar.getText(),
					this.tfPassword.getText(),
					this.tfDireccionModificar.getText(),
					COMBO_ROLES[this.comboBoxModificar.getSelectedIndex()],
					this.tfCorreoModificar.getText(),
					this.tfTelefonoModificar.getText());
		}
	}
}
