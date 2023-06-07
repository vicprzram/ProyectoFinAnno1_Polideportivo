package view.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class GestionEmpleados extends JPanel{
	private JTable table;
	private JTable tablaEjercicios;
	private JButton btnAñadir;
	private DefaultTableModel tModel;
	
	public GestionEmpleados() {
	setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 128, 349, 126);
		add(scrollPane);
		
		tablaEjercicios = new JTable();
		ConfigurarTabla();
		scrollPane.setViewportView(tablaEjercicios);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAñadir.setBounds(69, 59, 85, 21);
		add(btnAñadir);
		
		JLabel lblInstalaciones = new JLabel("Gestion Instalaciones");
		lblInstalaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInstalaciones.setBounds(49, 21, 121, 13);
		add(lblInstalaciones);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(175, 60, 85, 21);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(281, 60, 85, 21);
		add(btnEliminar);
		
	}
	private void ConfigurarTabla() {
		
	}
}
