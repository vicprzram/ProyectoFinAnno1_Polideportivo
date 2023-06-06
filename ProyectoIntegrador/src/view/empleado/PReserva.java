package view.empleado;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.LayoutStyle.ComponentPlacement;

import control.ReservaListener;
import db.PolideportivoPersistencia;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class PReserva extends JPanel {
	private JTextField txtDNI;
	private JLabel lblApeNom;
	private JButton btnBuscar;
	private JComboBox cmbDeporte;
	private DefaultComboBoxModel<String> dcbmDeporte;
	private PolideportivoPersistencia poliPers;
	public PReserva() {
		poliPers = new PolideportivoPersistencia();
		init();
		
	}
	private void init() {
		JLabel lblTitulo = new JLabel("Reserva de pistas");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblDNI = new JLabel("DNI\r\n");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblApeNom = new JLabel("");
		lblApeNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cmbDeporte = new JComboBox();
		
		dcbmDeporte = new DefaultComboBoxModel<>();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDNI, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(txtDNI, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
								.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
							.addGap(10)
							.addComponent(btnBuscar)
							.addGap(142))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDeporte)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cmbDeporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(lblCliente)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblApeNom, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
							.addGap(301))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblTitulo)
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDNI, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDNI, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApeNom, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDeporte, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbDeporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(175, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		cargarDeportes(poliPers.getDeportes());
		disableComponents();
	}
	
	public void disableComponents() {
		cmbDeporte.setEnabled(false);
	}
	
	public void cargarDeportes(ArrayList<String> lista) {
		dcbmDeporte.addAll(lista);
		cmbDeporte.setModel(dcbmDeporte);
		cmbDeporte.setSelectedIndex(0);
	}
}
