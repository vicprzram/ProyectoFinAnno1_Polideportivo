package view.empleado;

import javax.swing.JPanel;

import model.Empleado;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import control.EmpleadoListener;

public class PanelInicioEmpleado extends JPanel {
	
	private JCheckBox chkContrasena;
	private JLabel lblTitle, lblDni, lblDireccion, lblPuesto, lblContrasenaDatos;
	
	private String pass;
	
	public static final String CHECK_CONTRASENA = "Mostrar contraseña";
	
	public PanelInicioEmpleado() {
		setLayout(null);
		init();
		
	}
	
	private void init() {
		lblTitle = new JLabel("Bienvenido ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setBounds(10, 25, 780, 19);
		
		lblDni = new JLabel("DNI: ");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDni.setBounds(10, 71, 780, 14);
		
		lblDireccion = new JLabel("Dirección: ");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(20, 106, 770, 14);
		
		lblPuesto = new JLabel("Puesto: ");
		lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPuesto.setBounds(10, 141, 780, 14);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasena.setBounds(20, 176, 370, 14);
		
		lblContrasenaDatos = new JLabel("ESTE DATO SE MODIFICA EN UN METODO");
		lblContrasenaDatos.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasenaDatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasenaDatos.setBounds(400, 174, 390, 19);
		
		
		chkContrasena = new JCheckBox(CHECK_CONTRASENA);
		chkContrasena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkContrasena.setBounds(338, 210, 200, 23);
		
		add(lblTitle);
		add(lblDni);
		add(lblDireccion);
		add(lblPuesto);
		add(lblContrasena);
		add(lblContrasenaDatos);
		add(chkContrasena);
		
		setSize(EmpleadoWindow.ANCHO, EmpleadoWindow.ALTO);
	}
	
	public void addListener(EmpleadoListener l) {
		this.chkContrasena.addActionListener(l);
	}
	
	public void ofuscarContrasena(boolean value) {
		String nuevaContrasena = "";
		
		if(value == true) {
			for(int i = 0; i < this.pass.length(); i++) {
				nuevaContrasena += "*";
			}
			
			this.lblContrasenaDatos.setText(nuevaContrasena);
		}else {
			this.lblContrasenaDatos.setText(this.pass);
		}
	}
	
	public boolean getSelection() {
		return this.chkContrasena.isSelected();
	}
	
	public void cambiarTexto(Empleado empleado) {
		this.lblTitle.setText("Bienvenido " + empleado.getApenom());
		this.lblDni.setText("Dni: " + empleado.getDni());
		this.lblDireccion.setText("Direccion: " + empleado.getDireccion());
		this.lblPuesto.setText("Puesto: " + empleado.getRol());
		this.lblContrasenaDatos.setText(empleado.getPass());
		this.pass = empleado.getPass();
		
		ofuscarContrasena(true);
	}
}
