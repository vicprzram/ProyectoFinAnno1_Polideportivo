package view.empleado;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import control.EmpleadoListener;
import model.Clase;
import model.Reserva;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PConsulta extends JPanel {
	public static final String BTN_CONSULTAR = "Consultar";
	private JTable table;
	private DefaultTableModel dtm;
	private static final String[] HEADER_TABLA =  {"INSTALACIÓN", "DEPORTE", "USO", "USUARIO", "DIA", "HORA"};
	private JButton btnFiltro;
	private JComboBox cmbUso;
	private DefaultComboBoxModel<String> dcbmUso;
	public static final String[] USO = {
			"TODOS",
			"RESERVADO",
			"CLASE"
	};
	private JComboBox cmbHora;
	private static final String[] HORAS = {
			"TODAS",
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
	private DefaultComboBoxModel<String> dcbmHora;
	private JComboBox cmbDeporte;
	private DefaultComboBoxModel<String> dcbmDeporte;
	private JComboBox cmbFecha;
	private DefaultComboBoxModel<String> dcbmFecha;
	private JScrollPane scrpTabla;	
	
	public PConsulta() {
		
		init();
		
	}

	private void init() {
		JLabel lblTitle = new JLabel("Consulta de reservas");
		lblTitle.setBounds(10, 10, 271, 29);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblTitle);
		
		scrpTabla = new JScrollPane();
		scrpTabla.setBounds(40, 105, 700, 400);
		add(scrpTabla);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 45, 45, 20);
		add(lblFecha);
		
		cmbFecha = new JComboBox();
		cmbFecha.setBounds(65, 45, 70, 21);
		add(cmbFecha);
		
		dcbmFecha = new DefaultComboBoxModel<>();
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(265, 45, 50, 20);
		add(lblDeporte);
		
		cmbDeporte = new JComboBox();
		cmbDeporte.setBounds(325, 45, 120, 21);
		add(cmbDeporte);
		
		dcbmDeporte = new DefaultComboBoxModel<>();
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(145, 45, 30, 20);
		add(lblHora);
		
		cmbHora = new JComboBox();
		cmbHora.setBounds(185, 45, 70, 21);
		add(cmbHora);
		
		dcbmHora = new DefaultComboBoxModel<>(HORAS);
		cmbHora.setModel(dcbmHora);
		
		table = new JTable();
		scrpTabla.setViewportView(table);
		setLayout(null);
				
		JLabel lblUso = new JLabel("Uso");
		lblUso.setBounds(455, 45, 28, 20);
		add(lblUso);
		
		cmbUso = new JComboBox();
		cmbUso.setBounds(493, 45, 120, 21);
		add(cmbUso);
		
		dcbmUso = new DefaultComboBoxModel<>(USO);
		cmbUso.setModel(dcbmUso);
		
		btnFiltro = new JButton(BTN_CONSULTAR);
		btnFiltro.setBounds(10, 75, 90, 20);
		add(btnFiltro);
		
		configTabla();
	}
	
	private void configTabla() {
		visibilidadTabla(false);
		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(dtm);
		for (int i = 0; i < HEADER_TABLA.length; i++) {
			dtm.addColumn(HEADER_TABLA[i]);
		}
		
	}

	public void recargarTabla(ArrayList<Reserva> listaReservas, ArrayList<Clase> listaClases) {
		dtm.getDataVector().clear();
		if(listaReservas != null) {
			for (Reserva reserva : listaReservas) {
				dtm.addRow(reserva.getRowConsulta());
			}
		}
		if(listaClases != null) {
			for(Clase clase: listaClases) {
				dtm.addRow(clase.getRowConsulta());
			}
		}
		
	}
	
	public JButton getBtnConsultar() {
		return btnFiltro;
	}
	
	public void cargarDeportes(ArrayList<String> lista) {
		dcbmDeporte.removeAllElements();
		dcbmDeporte.addAll(lista);
		cmbDeporte.setModel(dcbmDeporte);
		cmbDeporte.setSelectedIndex(0);
	}
	
	public void cargarFechas(ArrayList<String> listaFechas) {
		dcbmFecha.removeAllElements();
		dcbmFecha.addAll(listaFechas);
		cmbFecha.setModel(dcbmFecha);
		cmbFecha.setSelectedIndex(0);
	}

	public void setListener(EmpleadoListener empleWListener) {
		btnFiltro.addActionListener(empleWListener);
	}
	
	public String getFecha() {
		return dcbmFecha.getSelectedItem().toString();
	}
	
	public String getHora() {
		return dcbmHora.getSelectedItem().toString();
	}
	
	public String getDeporte() {
		return dcbmDeporte.getSelectedItem().toString();
	}
	
	public String getUso() {
		return dcbmUso.getSelectedItem().toString();
	}

	public void visibilidadTabla(boolean b) {
		scrpTabla.setVisible(b);
	}
}
