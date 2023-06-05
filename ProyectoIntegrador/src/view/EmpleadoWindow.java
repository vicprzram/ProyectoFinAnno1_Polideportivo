package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class EmpleadoWindow extends JFrame{
	private JScrollPane scrpContenedor;
	static final int ANCHO = 700;
	static final int ALTO = 500;
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
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta de disponibilidad");
		menuBar.add(mntmConsulta);
		
		JMenuItem mntmReserva = new JMenuItem("Hacer una reserva");
		menuBar.add(mntmReserva);
		
		JMenuItem mntmRegistro = new JMenuItem("Registrar usuario");
		menuBar.add(mntmRegistro);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar sesión");
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

}
