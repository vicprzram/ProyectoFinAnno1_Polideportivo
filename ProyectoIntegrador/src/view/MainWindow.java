package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import control.MainListener;

public class MainWindow extends JFrame {
	
	private JMenuBar menuBar;
	private JMenuItem mntmInicio, mntmRanking, mntmHorario, mntmSalir;
	private JScrollPane srcPane;
	
	public static final String ITEM_RANKING = "Ranking";
	public static final String ITEM_HORARIO = "Horario";
	public static final String ITEM_SALIR = "Salir";
	public static final String ITEM_INICIO = "Inicio";
	
	private static final int ANCHO = 700;
	private static final int ALTO = 500;
	
	public MainWindow() {
		init();
	}
	
	private void init() {
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmInicio = new JMenuItem(ITEM_INICIO);
		mntmInicio.setHorizontalAlignment(SwingConstants.CENTER);
		
		mntmRanking = new JMenuItem(ITEM_RANKING);
		mntmRanking.setHorizontalAlignment(SwingConstants.CENTER);
		
		mntmHorario = new JMenuItem(ITEM_HORARIO);
		mntmHorario.setHorizontalAlignment(SwingConstants.CENTER);
		
		mntmSalir = new JMenuItem(ITEM_SALIR);
		mntmSalir.setHorizontalAlignment(SwingConstants.RIGHT);
		
		menuBar.add(mntmInicio);
		menuBar.add(mntmRanking);
		menuBar.add(mntmHorario);
		menuBar.add(mntmSalir);
		
		srcPane = new JScrollPane();
		
		getContentPane().add(srcPane, BorderLayout.CENTER);
		
		setSize(800, 600);
		
		centrarVentana();
	}
	
	private void centrarVentana() {
		setSize(ANCHO, ALTO);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ANCHO, ALTO);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
	}
	
	public void addListener(MainListener l) {
		this.mntmHorario.addActionListener(l);
		this.mntmInicio.addActionListener(l);
		this.mntmRanking.addActionListener(l);
		this.mntmSalir.addActionListener(l);
	}
	
	public void cargarPanel(JPanel panel) {
		srcPane.setViewportView(panel);
	}
}
