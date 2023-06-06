package view.empleado;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import control.EmpleadoListener;
import model.Empleado;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class EmpleadoWindow extends JFrame{
	private JMenuBar menuBar;
	private JMenuItem mntmConsulta, mntmReserva, mntmRegistro, mntmCerrar, mntmInicio;
	
	public static final String ITEM_CONSULTA = "Consulta disponibilidad";
	public static final String ITEM_RESERVA = "Hacer una reserva";
	public static final String ITEM_REGISTRO = "Registro usuario";
	public static final String ITEM_SESION = "Cerrar sesion";
	public static final String ITEM_INICIO = "Inicio";
	
	private JScrollPane scrpContenedor;
	
	public static final int ANCHO = 800;
	public static final int ALTO = 600;

	public EmpleadoWindow() {
		super("Cliente");
		init();
		
	}
	private void init() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmInicio = new JMenuItem(ITEM_INICIO);
		menuBar.add(mntmInicio);
		mntmConsulta = new JMenuItem(ITEM_CONSULTA);
		menuBar.add(mntmConsulta);
		
		mntmReserva = new JMenuItem(ITEM_RESERVA);
		menuBar.add(mntmReserva);
		
		mntmRegistro = new JMenuItem(ITEM_REGISTRO);
		menuBar.add(mntmRegistro);
		
		mntmCerrar = new JMenuItem(ITEM_SESION);
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
		this.mntmInicio.addActionListener(l);
		this.mntmCerrar.addActionListener(l);
		this.mntmConsulta.addActionListener(l);
		this.mntmReserva.addActionListener(l);
		this.mntmRegistro.addActionListener(l);
	}

}
