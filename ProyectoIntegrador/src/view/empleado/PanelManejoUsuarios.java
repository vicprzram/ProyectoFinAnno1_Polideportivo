package view.empleado;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;

import control.ManejoClientesListener;
import model.Cliente;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelManejoUsuarios extends JPanel {
	private JTextField tfDniAnnadir, tfNombreCompletoAnnadir,tfDireccionAnnadir, tfCuentaAnnadir, tfCorreoAnnadir, tfTelefonoAnnadir,
		tfDniModificar,tfCuentaModificar, tfTelefonoModificar, tfNombreCompletoModificar, tfDireccionModificar,tfCorreoModificar,tfDniEliminar;
	
	private JPanel panelAnnadir, panelModificar, panelEliminar;
	private JButton btnAnnadirCliente, btnLimpiarAnnadir, btnBuscarCliente, btnModificarCliente, btnLimpiarModificar, 
		btnEliminarCliente, btnEliminarAll;
	private JLabel lblConsultar;
	
	public static final String BUTTON_ANNADIR = "Añadir cliente";
	public static final String BUTTON_BUSCAR = "Buscar cliente";
	public static final String BUTTON_MODIFICAR = "Modificar cliente";
	public static final String BUTTON_ELIMINAR = "Eliminar cliente";
	public static final String BUTTON_LIMPIAR = "Limpiar";
	
	public PanelManejoUsuarios() {
		setSize(EmpleadoWindow.ANCHO, EmpleadoWindow.ALTO);
		setLayout(null);	
		init();
	}
	
	private void init() {
		JLabel lblTitle = new JLabel("Manejo clientes");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 5, 780, 21);
		
		cargarAnnadir();
		cargarModificar();
		cargarEliminar();
		
		lblConsultar = new JLabel("<html><u>Consultar clientes</u></html>");
		lblConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar.setBackground(new Color(128, 255, 255));
		lblConsultar.setBounds(532, 370, 258, 14);
		lblConsultar.setForeground(new Color(0, 46, 255));
		
		//Añadir a JPanel global
		add(lblTitle);
		add(panelAnnadir);
		add(panelModificar);
		add(panelEliminar);
		add(lblConsultar);
		
		deshabilitarModificar(true);
	}
	
	private void cargarAnnadir() {
		panelAnnadir = new JPanel();
		panelAnnadir.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelAnnadir.setBounds(10, 56, 251, 504);
		panelAnnadir.setLayout(null);
		
		JLabel lblAnnadir = new JLabel("<html><u>Añadir</u></html>");
		lblAnnadir.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAnnadir.setHorizontalAlignment(SwingConstants.CENTER);
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
		lblNombreCompleto.setBounds(10, 178, 231, 19);
		
		tfNombreCompletoAnnadir = new JTextField();
		tfNombreCompletoAnnadir.setBounds(10, 201, 231, 20);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(10, 232, 231, 19);
		
		tfDireccionAnnadir = new JTextField();
		tfDireccionAnnadir.setColumns(10);
		tfDireccionAnnadir.setBounds(10, 254, 231, 20);
		
		JLabel lblCuenta = new JLabel("Nº Cuenta:");
		lblCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuenta.setBounds(10, 92, 87, 19);
		
		tfCuentaAnnadir = new JTextField();
		tfCuentaAnnadir.setColumns(10);
		tfCuentaAnnadir.setBounds(101, 93, 140, 20);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCorreo.setBounds(10, 285, 231, 19);
		
		tfCorreoAnnadir = new JTextField();
		tfCorreoAnnadir.setColumns(10);
		tfCorreoAnnadir.setBounds(10, 308, 231, 20);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(10, 132, 87, 19);
		
		tfTelefonoAnnadir = new JTextField();
		tfTelefonoAnnadir.setColumns(10);
		tfTelefonoAnnadir.setBounds(101, 133, 140, 20);
		
		btnAnnadirCliente = new JButton(BUTTON_ANNADIR);
		btnAnnadirCliente.setBounds(10, 394, 231, 34);
		
		btnLimpiarAnnadir = new JButton(BUTTON_LIMPIAR);
		btnLimpiarAnnadir.setBounds(67, 439, 113, 34);
		
		
		panelAnnadir.add(lblAnnadir);
		panelAnnadir.add(lblDni);
		panelAnnadir.add(tfDniAnnadir);
		panelAnnadir.add(lblNombreCompleto);
		panelAnnadir.add(tfNombreCompletoAnnadir);
		panelAnnadir.add(lblDireccion);
		panelAnnadir.add(tfDireccionAnnadir);
		panelAnnadir.add(lblCuenta);
		panelAnnadir.add(tfCuentaAnnadir);
		panelAnnadir.add(lblCorreo);
		panelAnnadir.add(tfCorreoAnnadir);
		panelAnnadir.add(lblTelefono);
		panelAnnadir.add(tfTelefonoAnnadir);
		panelAnnadir.add(btnAnnadirCliente);
		panelAnnadir.add(btnLimpiarAnnadir);
	}
	
	private void cargarModificar() {
		panelModificar = new JPanel();
		panelModificar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelModificar.setBounds(271, 56, 251, 504);
		panelModificar.setLayout(null);
		
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
		tfDniModificar.setBounds(89, 48, 152, 20);
		
		btnBuscarCliente = new JButton(BUTTON_BUSCAR);
		btnBuscarCliente.setBounds(10, 80, 231, 34);
		
		JLabel lblCuenta = new JLabel("Nº Cuenta:");
		lblCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuenta.setBounds(10, 139, 87, 19);
		
		tfCuentaModificar = new JTextField();
		tfCuentaModificar.setColumns(10);
		tfCuentaModificar.setBounds(101, 140, 140, 20);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(10, 179, 87, 19);
		
		tfTelefonoModificar = new JTextField();
		tfTelefonoModificar.setColumns(10);
		tfTelefonoModificar.setBounds(101, 180, 140, 20);
		
		JLabel lblNombreCompleto = new JLabel("Nombre completo:");
		lblNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreCompleto.setBounds(10, 211, 231, 19);
		
		tfNombreCompletoModificar = new JTextField();
		tfNombreCompletoModificar.setColumns(10);
		tfNombreCompletoModificar.setBounds(10, 234, 231, 20);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(10, 265, 231, 19);
		
		tfDireccionModificar = new JTextField();
		tfDireccionModificar.setColumns(10);
		tfDireccionModificar.setBounds(10, 287, 231, 20);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCorreo.setBounds(10, 318, 231, 19);
		
		tfCorreoModificar = new JTextField();
		tfCorreoModificar.setColumns(10);
		tfCorreoModificar.setBounds(10, 341, 231, 20);
		
		btnModificarCliente = new JButton("Modificar cliente");
		btnModificarCliente.setBounds(10, 394, 231, 34);
		
		btnLimpiarModificar = new JButton("Limpiar");
		btnLimpiarModificar.setBounds(73, 439, 113, 34);
		
		panelModificar.add(lblModificar);
		panelModificar.add(lblDni);
		panelModificar.add(tfDniModificar);
		panelModificar.add(btnBuscarCliente);
		panelModificar.add(lblCuenta);
		panelModificar.add(tfCuentaModificar);
		panelModificar.add(lblTelefono);
		panelModificar.add(tfTelefonoModificar);
		panelModificar.add(lblNombreCompleto);
		panelModificar.add(tfNombreCompletoModificar);
		panelModificar.add(lblDireccion);
		panelModificar.add(tfDireccionModificar);
		panelModificar.add(lblCorreo);
		panelModificar.add(tfCorreoModificar);
		panelModificar.add(btnModificarCliente);
		panelModificar.add(btnLimpiarModificar);
		
	}
	
	private void cargarEliminar() {
		panelEliminar = new JPanel();
		panelEliminar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelEliminar.setBounds(532, 56, 251, 235);
		panelEliminar.setLayout(null);
		
		JLabel lblEliminar = new JLabel("<html><u>Eliminar</u></html>");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEliminar.setBounds(10, 11, 231, 14);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDni.setBounds(10, 56, 69, 19);
		
		tfDniEliminar = new JTextField();
		tfDniEliminar.setColumns(10);
		tfDniEliminar.setBounds(89, 57, 152, 20);
		
		btnEliminarCliente = new JButton("Eliminar cliente");
		btnEliminarCliente.setBounds(10, 89, 231, 34);
		
		btnEliminarAll = new JButton("Eliminar todos los clientes");
		btnEliminarAll.setBounds(10, 190, 231, 34);
		
		panelEliminar.add(lblEliminar);
		panelEliminar.add(lblDni);
		panelEliminar.add(tfDniEliminar);
		panelEliminar.add(btnEliminarCliente);
		panelEliminar.add(btnEliminarAll);
	}
	
	public void addListener(ManejoClientesListener l) {
		//Añadir
		this.btnAnnadirCliente.addActionListener(l);
		this.btnLimpiarAnnadir.addActionListener(l);
		
		//Modificar
		this.btnBuscarCliente.addActionListener(l);
		this.btnModificarCliente.addActionListener(l);
		this.btnLimpiarModificar.addActionListener(l);
		
		//Eliminar
		this.btnEliminarCliente.addActionListener(l);
		this.btnEliminarAll.addActionListener(l);
		
		//Consultar
		this.lblConsultar.addMouseListener(l);
	}
	
	public Cliente getValues(boolean type) {
		int nCuenta = 0;
		
		if(type) {
			
			try {
				if(!tfCuentaAnnadir.getText().isEmpty()) {
					nCuenta = Integer.parseInt(this.tfCuentaAnnadir.getText());
				}
			}catch(NumberFormatException e) {
				nCuenta = -1;
			}
			
			return new Cliente(
					this.tfDniAnnadir.getText(),
					this.tfNombreCompletoAnnadir.getText(),
					this.tfDireccionAnnadir.getText(),
					this.tfCorreoAnnadir.getText(),
					this.tfTelefonoAnnadir.getText(),
					nCuenta);
		}else {
			try {
				if(!tfCuentaModificar.getText().isEmpty()) {
					nCuenta = Integer.parseInt(this.tfCuentaModificar.getText());
				}
			}catch(NumberFormatException e) {
				nCuenta = -1;
			}
			
			return new Cliente(
					this.tfDniModificar.getText(),
					this.tfNombreCompletoModificar.getText(),
					this.tfDireccionModificar.getText(),
					this.tfCorreoModificar.getText(),
					this.tfTelefonoModificar.getText(),
					nCuenta);
		}
	}
	
	
	
	public void clearAllAnnadir() {
		this.tfDniAnnadir.setText("");
		this.tfNombreCompletoAnnadir.setText("");
		this.tfDireccionAnnadir.setText("");
		this.tfCorreoAnnadir.setText("");
		this.tfTelefonoAnnadir.setText("");
		this.tfCuentaAnnadir.setText("");
	}
	
	public void clearAllModificar() {
		this.tfDniModificar.setText("");
		this.tfNombreCompletoModificar.setText("");
		this.tfDireccionModificar.setText("");
		this.tfCorreoModificar.setText("");
		this.tfTelefonoModificar.setText("");
		this.tfCuentaModificar.setText("");
	}
	
	public JButton getLimpiarAnnadir() {
		return this.btnLimpiarAnnadir;
	}
	
	public JButton getLimpiarModificar() {
		return this.btnLimpiarModificar;
	}
	
	public String getDniModificar() {
		return this.tfDniModificar.getText();
	}
	
	public void setTextModificar(Cliente values) {
		this.tfNombreCompletoModificar.setText(values.getApenom());
		this.tfDireccionModificar.setText(values.getDireccion());
		this.tfCorreoModificar.setText(values.getCorreo());
		this.tfTelefonoModificar.setText(values.getTelefono());
		this.tfCuentaModificar.setText("" + values.getNumCuenta());
	}
	
	public void deshabilitarModificar(boolean value) {
		if(value) {
			this.tfNombreCompletoModificar.setEnabled(false);
			this.tfDireccionModificar.setEnabled(false);
			this.tfCorreoModificar.setEnabled(false);
			this.tfTelefonoModificar.setEnabled(false);
			this.tfCuentaModificar.setEnabled(false);
			this.btnModificarCliente.setEnabled(false);
			this.btnLimpiarModificar.setEnabled(false);
			this.btnBuscarCliente.setEnabled(true);
			this.tfDniModificar.setEnabled(true);
		}else {
			this.tfNombreCompletoModificar.setEnabled(true);
			this.tfDireccionModificar.setEnabled(true);
			this.tfCorreoModificar.setEnabled(true);
			this.tfTelefonoModificar.setEnabled(true);
			this.tfCuentaModificar.setEnabled(true);
			this.btnModificarCliente.setEnabled(true);
			this.btnLimpiarModificar.setEnabled(true);
			this.btnBuscarCliente.setEnabled(false);
			this.tfDniModificar.setEnabled(false);
		}
	}
}
