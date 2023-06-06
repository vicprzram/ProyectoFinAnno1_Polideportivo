package view.principal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import control.MainListener;
import model.Empleado;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PanelInicioSesion extends JPanel {
	private JTextField tfDni;
	
	private JCheckBox chkMostrarContrasena;
	
	private JButton btnIniciarSesion;
	
	public static final String BUTTON_INICIAR_SESION = "Iniciar sesion";
	public static final String CHECK_CONTRASENA = "Mostrar contraseña";
	
	private JPasswordField passwordField;
	
	public PanelInicioSesion() {
		init();
	}
	
	private void init() {
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Inicio de sesión");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitle.setBounds(348, 28, 156, 19);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDni.setBounds(248, 93, 49, 19);
		
		tfDni = new JTextField();
		tfDni.setBounds(348, 95, 202, 20);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblContrasena.setBounds(248, 145, 96, 20);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(354, 148, 196, 20);
		
		
		chkMostrarContrasena = new JCheckBox(CHECK_CONTRASENA);
		chkMostrarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 17));
		chkMostrarContrasena.setBounds(247, 203, 169, 23);
		
		btnIniciarSesion = new JButton(BUTTON_INICIAR_SESION);
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnIniciarSesion.setBounds(336, 282, 132, 31);
		
		add(lblTitle);
		add(lblDni);
		add(tfDni);
		add(lblContrasena);
		add(passwordField);
		add(chkMostrarContrasena);
		add(btnIniciarSesion);
		
		setSize(800, 600);
		
	}
	
	public void addListener(MainListener l) {
		this.btnIniciarSesion.addActionListener(l);
		this.chkMostrarContrasena.addActionListener(l);
	}
	
	public boolean getCheckValue() {
		return this.chkMostrarContrasena.isSelected();
	}
	
	
	public void showContrasena(int n) {
		if(n == 0) {
			this.passwordField.setEchoChar((char)0);
		}else {
			this.passwordField.setEchoChar('*');
		}
	}
	
	//Se configura para que solo devuelva dni y contraseña
	public Empleado getValues() {
		return new Empleado(this.tfDni.getText(), null, this.passwordField.getText(), null, null);
	}
}
