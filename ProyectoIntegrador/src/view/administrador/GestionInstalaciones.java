package view.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


import model.Instalacion;

public class GestionInstalaciones extends JPanel{
	private JTable table;
	private JTable tablaInstalaciones;
	private JButton btnAñadir;
	private DefaultTableModel tModel;
	
	public GestionInstalaciones() {
	setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 128, 349, 126);
		add(scrollPane);
		
		tablaInstalaciones = new JTable();
		ConfigurarTabla();
		scrollPane.setViewportView(tablaInstalaciones);
		
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
		tModel = new DefaultTableModel(){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		tablaInstalaciones.setModel(tModel);
		
		/*tModel.addColumn(id);
		tModel.addColumn(tipo);
		tModel.addColumn(deporte);
		;
		
		tablaInstalaciones.getColumn().setPreferredWidth(50);
		tablaInstalaciones.getColumn().setPreferredWidth(50);
		tablaInstalaciones.getColumn().setPreferredWidth(50);*/
	
		
	}
	
	public void rellenarTabla(ArrayList<Instalacion> listaInstalaciones) {
		
		tModel.setRowCount(0);
		
		Object[] fila = new Object[4];
		
		for(Instalacion ej : listaInstalaciones) {
				fila[0] = ej.getId();
				fila[1] = ej.getDeporte();
				fila[2] = ej.getTipo();
				
				tModel.addRow(fila);
		}			
	}

}
