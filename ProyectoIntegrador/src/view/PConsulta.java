package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class PConsulta extends JPanel {
	private JTable table;
	public PConsulta() {
		
		JLabel lblTitle = new JLabel("Consulta de reservas");
		lblTitle.setBounds(10, 10, 221, 29);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JScrollPane scrpTabla = new JScrollPane();
		scrpTabla.setBounds(10, 100, 580, 190);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 49, 45, 13);
		
		JComboBox cmbFecha = new JComboBox();
		cmbFecha.setBounds(45, 45, 70, 21);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(260, 49, 45, 13);
		
		JComboBox cmbDeporte = new JComboBox();
		cmbDeporte.setBounds(315, 45, 70, 21);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(125, 49, 45, 13);
		
		JComboBox cmbHora = new JComboBox();
		cmbHora.setBounds(180, 45, 70, 21);
		
		table = new JTable();
		scrpTabla.setViewportView(table);
		setLayout(null);
		add(lblTitle);
		add(scrpTabla);
		add(lblFecha);
		add(cmbFecha);
		add(lblDeporte);
		add(cmbDeporte);
		add(lblHora);
		add(cmbHora);
		
		JLabel lblUso = new JLabel("Uso");
		lblUso.setBounds(407, 49, 28, 13);
		add(lblUso);
		
		JComboBox cmbUso = new JComboBox();
		cmbUso.setBounds(445, 45, 70, 21);
		add(cmbUso);
		
	}
}
