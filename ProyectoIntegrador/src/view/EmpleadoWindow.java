package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import control.EmpleadoListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class EmpleadoWindow extends JFrame{
	public static final String CERRAR_SESIÓN = "Cerrar sesión";
	public static final String REGISTRAR_USUARIO = "Registrar usuario";
	public static final String HACER_UNA_RESERVA = "Hacer una reserva";
	public static final String CONSULTA_DE_DISPONIBILIDAD = "Consulta de disponibilidad";
	private JScrollPane scrpContenedor;
	static final int ANCHO = 700;
	static final int ALTO = 500;
	private JMenuItem mntmConsulta;
	private JMenuItem mntmReserva;
	private JMenuItem mntmRegistro;
	private JMenuItem mntmCerrar;
	public EmpleadoWindow() {
		super("Cliente");
		init();
		
	}
	private void init() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmConsulta = new JMenuItem(CONSULTA_DE_DISPONIBILIDAD);
		menuBar.add(mntmConsulta);
		
		mntmReserva = new JMenuItem(HACER_UNA_RESERVA);
		menuBar.add(mntmReserva);
		
		mntmRegistro = new JMenuItem(REGISTRAR_USUARIO);
		menuBar.add(mntmRegistro);
		
		mntmCerrar = new JMenuItem(CERRAR_SESIÓN);
		menuBar.add(mntmCerrar);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		centrarVentana();
	}
	
	private void centrarVentana() {
		setSize(ANCHO, ALTO);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ANCHO, ALTO);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
	}
	
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}
	
	public void setListener(EmpleadoListener l) {
		mntmConsulta.addActionListener(l);
	}

}
