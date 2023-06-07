package view.administrador;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class WindowClases extends JFrame {
	
	private static final int ANCHO = 600;
	private static final int ALTO = 400;
	private JLabel lblDeporte;
	private JTextField txtDeporte;
	private JTextField txtDia;
	private JTextField txtHora;
	private JComboBox cmbInstalacion;
	private JComboBox cmbProfesor;
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	public WindowClases() {
		init();
		centrarVentana();
	}

	private void init() {
		// TODO Auto-generated method stub
getContentPane().setLayout(null);
		
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
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(150, 165, 85, 21);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(347, 165, 85, 21);
		getContentPane().add(btnCancelar);
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
}
