package view.administrador;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import control.AdministradorListener;
import model.Clase;
import model.Instalacion;

public class PClases extends JPanel{
	private JScrollPane scrollPane;
	private JComboBox cmbDeporte;
	private DefaultComboBoxModel<String> dcbmDeporte;
	private JTable tblHorario;
	private DefaultTableModel dtm;
	private JButton btnConsultar;
	
	private static final String[] HEADER_TABLA = {"HORA", "LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO", "DOMINGO"};
	private static final String[] HORAS = {
			"09:00",
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
	private JButton btnEditar;

	public PClases() {
		init();
		configTabla();
	}

	private void configTabla() {
		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblHorario.setModel(dtm);
		for (int i = 0; i < HEADER_TABLA.length; i++) {
			dtm.addColumn(HEADER_TABLA[i]);
		}
		tblHorario.setRowHeight(50);
		tblHorario.setCellSelectionEnabled(true);
		
	}
	
	

	private void init() {
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
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(516, 50, 120, 21);
		add(btnEditar);
		btnEditar.setEnabled(false);
		
		
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
	
	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setListener(AdministradorListener adminListener) {
		btnConsultar.addActionListener(adminListener);
		btnEditar.addActionListener(adminListener);
		
	}
	
	public void cargarClases(ArrayList<Clase> listaClases) {
		dtm.getDataVector().clear();
		String[] rowActual = new String[8];
		DefaultTableCellRenderer modelCentrar = new DefaultTableCellRenderer();
		modelCentrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int j = 0; j < HORAS.length; j++) {
			for (int i = 0; i < HEADER_TABLA.length; i++) {
				if(i != 0) {
					for (Clase clase : listaClases) {
						if(clase.getHora().equals(HORAS[j]) && clase.getFecha().toUpperCase().equals(HEADER_TABLA[i])) {
							rowActual[i] = clase.toString();
							break;
						}else {
							rowActual[i] = "";
						}
					}
				}else {
					rowActual[i] = HORAS[j];
				}
				tblHorario.getColumnModel().getColumn(i).setCellRenderer(modelCentrar);
			}
			
			dtm.addRow(rowActual);
		}
		btnEditar.setEnabled(true);
	}
	
	public Clase getSelectedClase() {
		Clase clase = null;
		
		if(tblHorario.getSelectedColumn() != -1 && tblHorario.getSelectedRow() != -1) {
			String dataSt = ((String) ((Vector<String>) dtm.getDataVector().elementAt(tblHorario.getSelectedRow())).elementAt(tblHorario.getSelectedColumn()));
			
			if(dataSt == null || dataSt.isEmpty()) {
				clase = new Clase(1, HEADER_TABLA[tblHorario.getSelectedColumn()], HORAS[tblHorario.getSelectedRow()], null, null, getDeporte());
			}else {
				String[] data = dataSt.split(" ");
				clase = new Clase(0, HEADER_TABLA[tblHorario.getSelectedColumn()], HORAS[tblHorario.getSelectedRow()], null, new Instalacion(Integer.parseInt(data[1]), getDeporte(), data[0]), getDeporte());
			}
			
		}
		
		
		return clase;
	}
	
}
