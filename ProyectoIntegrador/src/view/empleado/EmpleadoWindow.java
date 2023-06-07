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
import javax.swing.SwingConstants;
import javax.swing.JMenu;

public class EmpleadoWindow extends JFrame{
	
	private JMenuBar menuBar;
	private JMenuItem mntmConsulta, mntmReserva, mntmRegistro, mntmCerrar, mntmInicio;
	
	public static final String ITEM_CONSULTA = "Consulta reservas";
	public static final String ITEM_RESERVA = "Hacer una reserva";
	public static final String ITEM_MANEJO = "Manejo clientes";
	public static final String ITEM_SESION = "Cerrar sesion";
	public static final String ITEM_INICIO = "Inicio";
	public static final String ITEM_GESTION_CLASES = "Gestión clases";
	
	private JScrollPane scrpContenedor;
	
	public static final int ANCHO = 800;
	public static final int ALTO = 600;

	public EmpleadoWindow() {
		super("Empleado");
		init();
		
	}
	private void init() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		setResizable(false);
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmInicio = new JMenuItem(ITEM_INICIO);
		mntmInicio.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmInicio);
		mntmConsulta = new JMenuItem(ITEM_CONSULTA);
		menuBar.add(mntmConsulta);
		mntmConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		
		mntmReserva = new JMenuItem(ITEM_RESERVA);
		menuBar.add(mntmReserva);
		mntmReserva.setHorizontalAlignment(SwingConstants.CENTER);
		
		mntmRegistro = new JMenuItem(ITEM_MANEJO);
		mntmRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmRegistro);
		
		mntmCerrar = new JMenuItem(ITEM_SESION);
		mntmCerrar.setHorizontalAlignment(SwingConstants.CENTER);
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
