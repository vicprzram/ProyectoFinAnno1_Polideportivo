package view.administrador;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import control.AdministradorListener;
import control.EmpleadoListener;

import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;

public class AdministradorWindow extends JFrame{
	private JMenuBar menuBar;
	private JMenuItem mntmGestionEmple, mntmGestionInsta, mntmRegistroClase, mntmCerrar;
	
	public static final String ITEM_EMPLEADOS = "Gestion empleados";
	public static final String ITEM_INSTALACIONES = "Gestion instalaciones";
	public static final String ITEM_CLASE = "Gestion clases";
	public static final String ITEM_SESION = "Cerrar sesion";

	
	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	
	private JScrollPane scrpContenedor;
	
	public AdministradorWindow() {
		super("Administardos");
		init();
	}
	private void init() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mntmGestionEmple = new JMenuItem(ITEM_EMPLEADOS);
		mntmGestionEmple.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmGestionEmple);
		
		mntmGestionInsta = new JMenuItem(ITEM_INSTALACIONES);
		mntmGestionInsta.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmGestionInsta);
		
		mntmRegistroClase = new JMenuItem(ITEM_CLASE);
		menuBar.add(mntmRegistroClase);
		
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
	public void setListener(AdministradorListener l) {
		this.mntmRegistroClase.addActionListener(l);
		this.mntmCerrar.addActionListener(l);
		this.mntmGestionEmple.addActionListener(l);
		this.mntmGestionInsta.addActionListener(l);
	
	}

}