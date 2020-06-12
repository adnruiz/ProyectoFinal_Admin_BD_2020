package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controlador.*;
import modelo.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class personalABCC extends JFrame {

	JTable tableAltas;
	private JPanel contentPane;
	PersonalDAO personalDAO = new PersonalDAO();
	JPanel panelTabla = new JPanel();
	private JTextField textConsulta;
	//principal p = new principal();
	int selectedRow,selectedColumn;
	String aux = "";
	/**
	 * Create the frame.
	 */
	public personalABCC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 413);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		//personalDAO.actualizarTabla(tableAltas);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarPersonal frame = new agregarPersonal();
				frame.setVisible(true);
			}
		});
		btnAgregar.setIcon(new ImageIcon("iconos\\anadir.png"));
		btnAgregar.setBounds(530, 25, 115, 33);
		contentPane.add(btnAgregar);
		
		
		panelTabla.setBackground(SystemColor.activeCaption);
		panelTabla.setBounds(0, 69, 686, 244);
		contentPane.add(panelTabla);
		panelTabla.setLayout(null);
		
		String columnas[] = { "ID Usuario", "Nombre", "Primer Ap", "Segundo Ap", "Puesto", "Entrada", "Salida", "Sueldo", "Dias Trabj." };
		String datos[][] = {};

		tableAltas = new JTable(datos, columnas);
		JScrollPane scroll = new JScrollPane(tableAltas);
		scroll.setBounds(5, 9, 670, 160);
		panelTabla.add(scroll);
		personalDAO.actualizarTabla(tableAltas);
		
		ListSelectionModel model = tableAltas.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model.isSelectionEmpty()) {
					//GET SELECTED ROW
					selectedRow=model.getMinSelectionIndex();
					selectedColumn = tableAltas.getSelectedColumn();
					//JOptionPane.showMessageDialog(null, "Selected row: " + selectedRow);
					//JOptionPane.showMessageDialog(null, "Selected column: " + selectedColumn);
				}
			}
		});
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCerrar.setIcon(new ImageIcon("iconos\\cruz-entrecruzada.png"));
		btnCerrar.setBounds(402, 324, 112, 33);
		contentPane.add(btnCerrar);
		
		textConsulta = new JTextField();
		textConsulta.setBounds(38, 25, 256, 33);
		contentPane.add(textConsulta);
		textConsulta.setColumns(10);
		
		
		
		JButton btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aux = textConsulta.getText();
				
				
				String sql = "SELECT * FROM Personal WHERE Primer_Nombre LIKE '"+aux+"%' OR Ap_Paterno LIKE '" +aux+ "%' OR Ap_Materno LIKE '" +aux+ "%' OR Puesto LIKE '" +aux+"%' OR Entrada LIKE '" +aux+"%' OR Salida LIKE '" +aux+"%' OR Sueldo_dia LIKE '" +aux+ "%' OR Dias_Trabajados LIKE '" +aux+"';";
				personalDAO.actualizarTabla2(tableAltas, sql);
			}
		});
		btnConsultar.setIcon(new ImageIcon("iconos\\lupa.png"));
		btnConsultar.setBounds(289, 25, 39, 33);
		contentPane.add(btnConsultar);
		
		
		
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				personalDAO.eliminarRegistro(Integer.parseInt(tableAltas.getValueAt(selectedRow, 0).toString()));
				personalDAO.actualizarTabla(tableAltas);				
			}
		});
		btnEliminar.setIcon(new ImageIcon("iconos\\basura.png"));
		btnEliminar.setBounds(44, 324, 124, 33);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarPersonal frame = new modificarPersonal();
				frame.setVisible(true);
			}
		});
		btnModificar.setIcon(new ImageIcon("iconos\\lapiz.png"));
		btnModificar.setBounds(213, 324, 124, 33);
		contentPane.add(btnModificar);
		
	}
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personalABCC frame = new personalABCC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
