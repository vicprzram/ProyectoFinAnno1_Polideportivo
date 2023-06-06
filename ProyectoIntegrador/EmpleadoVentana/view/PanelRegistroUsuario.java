package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import control.EmpleadoListener;

import javax.swing.JButton;

public class PanelRegistroUsuario extends JPanel {
	private JTextField tfDni;
	private JTextField tfNombre;
	private JTextField tfDireccion;
	private JTextField tfCuenta;
	private JButton btnAnnadir;
	
	public static final String BUTTON_ANNADIR = "Annadir cliente";
	
	public PanelRegistroUsuario() {
		init();
	}
	
	private void init() {
		setSize(410, 295);
		setLayout(null);
		
		JLabel lblAnnadirCliente = new JLabel("Añadir cliente");
		lblAnnadirCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnnadirCliente.setBounds(124, 11, 113, 23);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDni.setBounds(38, 77, 41, 14);
		
		tfDni = new JTextField();
		tfDni.setBounds(89, 76, 123, 20);
		
		JLabel lblNombre = new JLabel("Nombre y apellidos:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(38, 102, 137, 23);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(180, 105, 185, 20);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(38, 136, 72, 23);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(108, 139, 185, 20);
		
		JLabel lblCuenta = new JLabel("Numero de cuenta:");
		lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuenta.setBounds(38, 174, 137, 23);
		
		tfCuenta = new JTextField();
		tfCuenta.setBounds(180, 177, 185, 20);
		
		btnAnnadir = new JButton(BUTTON_ANNADIR);
		btnAnnadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnnadir.setBounds(125, 222, 123, 23);
		
		add(lblAnnadirCliente);
		add(lblDni);
		add(tfDni);
		add(lblNombre);
		add(tfNombre);
		add(lblDireccion);
		add(tfDireccion);
		add(lblCuenta);
		add(tfCuenta);
		add(btnAnnadir);
	}
	
	public void addListener(EmpleadoListener l) {
		this.btnAnnadir.addActionListener(l);
	}
}
