package view.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class PClases extends JPanel{
	private JScrollPane scrollPane;
	private JComboBox cmbDeporte;
	private DefaultComboBoxModel<String> dcbmDeporte;
	private JTable tblHorario;
	private DefaultTableModel dtm;
	private JButton btnConsultar;
	
	private static final String[] HEADER_TABLA = {"HORA", "LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "SÁBADO", "DOMINGO"};
	private static final String[] HORAS = {
			"9:00",
			"10:00",
			"11:00",
			"12:00",
			"13:00",
			"14:00",
			"15:00",
			"16:00",
			"17:00",
			"18:00",
			"19:00",
			"20:00"}; 

	public PClases() {
		init();
		configTabla();
	}

	private void configTabla() {
		dtm = new DefaultTableModel();
		tblHorario.setModel(dtm);
		for (int i = 0; i < HEADER_TABLA.length; i++) {
			dtm.addColumn(HEADER_TABLA[i]);
		}
		for (int i = 0; i < HORAS.length; i++) {
			
		}
	}

	private void init() {
		// TODO Auto-generated method stub
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Gestión de clases");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setBounds(10, 10, 225, 30);
		add(lblTitle);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeporte.setBounds(20, 50, 65, 20);
		add(lblDeporte);
		
		cmbDeporte = new JComboBox();
		cmbDeporte.setBounds(95, 50, 120, 21);
		add(cmbDeporte);
		
		dcbmDeporte = new DefaultComboBoxModel<>();
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(20, 80, 746, 440);
		add(scrollPane);
		
		tblHorario = new JTable();
		scrollPane.setViewportView(tblHorario);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(646, 50, 120, 21);
		add(btnConsultar);
	}
	
	public void cargarDeportes(ArrayList<String> lista) {
		dcbmDeporte.removeAllElements();
		lista.remove("TODOS");
		dcbmDeporte.addAll(lista);
		cmbDeporte.setModel(dcbmDeporte);
		cmbDeporte.setSelectedIndex(0);
	}
	
	public String getDeporte() {
		return dcbmDeporte.getSelectedItem().toString();
	}
	
	public JButton getBtnConsultar() {
		return btnConsultar;
	}
}
