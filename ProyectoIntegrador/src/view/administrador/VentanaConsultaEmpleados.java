package view.administrador;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.AdministradorListener;
import control.ManejoClientesListener;
import model.Cliente;
import model.Empleado;

public class VentanaConsultaEmpleados extends JFrame {
	
	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	private JScrollPane srcPane;
	private DefaultTableModel modelTable;
	private JButton btnNewButton;
	
	public static final String BUTTON_RECARGAR = "Recargar";
	public static final String BUTTON_SALIR = "Salir";
	
	private static final String[] COLUMNS_ARRAY = {"DNI", "Nombre", "Direccion", "Contraseña", 
			"Correo", "Telefono", "Rol"};
	private JTable table;
	private JButton btnSalir;
	
	public VentanaConsultaEmpleados() {
		super("Consulta clientes");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		modelTable = new DefaultTableModel();
		
		for(String i : COLUMNS_ARRAY) {
			modelTable.addColumn(i);
		}
		
		table = new JTable(modelTable);
		table.setBounds(10, 79, 764, 471);
		srcPane = new JScrollPane(table);
		srcPane.setBounds(10, 79, 764, 471);
		getContentPane().add(srcPane);
		
		btnNewButton = new JButton(BUTTON_RECARGAR);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 11, 139, 38);
		getContentPane().add(btnNewButton);
		
		btnSalir = new JButton(BUTTON_SALIR);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalir.setBounds(635, 20, 139, 38);
		getContentPane().add(btnSalir);
		
		centrarVentana();
	}
	
	public void insertData(Empleado values) {
		modelTable.addRow(new String[] {values.getDni(), values.getApenom(), values.getDireccion(),
				"" + values.getPass(), values.getCorreo(), values.getTelefono(), values.getRol()});
	}
	
	public void addListener(AdministradorListener l) {
		this.btnNewButton.addActionListener(l);
		this.btnSalir.addActionListener(l);
	}
	
	private void centrarVentana() {
		setSize(ANCHO, ALTO);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ANCHO, ALTO);
		setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
	}
	
	public void deshabilitar(boolean value) {
		if(value) {
			this.table.setVisible(false);
			this.srcPane.setVisible(false);
		}else {
			this.table.setVisible(true);
			this.srcPane.setVisible(true);
		}
	}
	
	public void removeData() {
		this.modelTable.getDataVector().clear();
	}
}
