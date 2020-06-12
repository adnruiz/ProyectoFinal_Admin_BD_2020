package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controlador.BotellasDAO;
import modelo.Botellas;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modificarBotellas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCantidad;
	JComboBox <String> cboPrecio, cboNivel, cboDestilado;
	Font f = new Font("Tahoma", Font.BOLD, 12);
	MetodosMagicoBotellas magic = new MetodosMagicoBotellas();
	BotellasDAO botellasDAO = new BotellasDAO();
	JTable tablaModBot;
	int selectedRow,selectedColumn;
	/**
	 * Create the frame.
	 */
	public modificarBotellas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 397);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelComponentes = new JPanel();
		panelComponentes.setBackground(SystemColor.inactiveCaption);
		panelComponentes.setBounds(0, 0, 214, 358);
		contentPane.add(panelComponentes);
		panelComponentes.setLayout(null);
		
		JLabel lblNombre = new JLabel();
		lblNombre = magic.configuracionEtiqueta(lblNombre, "Nombre", f, 10, 21, 68, 14);
		panelComponentes.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre = magic.configuracionCajasTexto(txtNombre, f, 88, 18, 105, 20);
		panelComponentes.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel();
		lblPrecio = magic.configuracionEtiqueta(lblPrecio, "Precio", f, 10, 59, 68, 14);
		panelComponentes.add(lblPrecio);
		
		JLabel lblNivel = new JLabel();
		lblNivel = magic.configuracionEtiqueta(lblNivel, "Niv. Alcohol", f, 10, 100, 68, 14);
		panelComponentes.add(lblNivel);
		
		JLabel lblDestilado = new JLabel();
		lblDestilado = magic.configuracionEtiqueta(lblDestilado, "Destilado", f, 10, 139, 68, 14);
		panelComponentes.add(lblDestilado);
		
		JLabel lblCantidad = new JLabel();
		lblCantidad = magic.configuracionEtiqueta(lblCantidad, "Cantidad Bot.", f, 10, 172, 68, 14);
		panelComponentes.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad = magic.configuracionCajasTexto(txtCantidad, f, 88, 169, 105, 20);
		panelComponentes.add(txtCantidad);
		
		
		cboPrecio = magic.configuracionCombo(cboPrecio, magic.precios(), f, 88, 49, 105, 20);
		panelComponentes.add(cboPrecio);
		
		
		cboNivel = magic.configuracionCombo(cboNivel, magic.niveles(), f, 88, 97, 105, 20);
		panelComponentes.add(cboNivel);
		
		
		cboDestilado = magic.configuracionCombo(cboDestilado, magic.destilados(), f, 88, 136, 105, 20);
		panelComponentes.add(cboDestilado);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Botellas botellas = new Botellas(Integer.parseInt(tablaModBot.getValueAt(selectedRow, 0).toString()), txtNombre.getText(), 
						Double.parseDouble(cboPrecio.getSelectedItem().toString()), Double.parseDouble(cboNivel.getSelectedItem().toString()),
						cboDestilado.getSelectedItem().toString(), Integer.parseInt(txtCantidad.getText().toString()));
				boolean validacion1 = magic.validarComponentes(botellas);
				boolean validacion2 = magic.validarEspacios(botellas);
				botellasABCC b = new botellasABCC();
				if(validacion1 || validacion2) {
					 JOptionPane.showMessageDialog(getParent(), "No se pudo agregar, datos insuficientes");
				}else {
					JOptionPane.showMessageDialog(getParent(), "REGISTRO AGREGADO CORRECTAMENTE");
					
					botellasDAO.actualizarRegistros(botellas);
					botellasDAO.actualizarTablaB(tablaModBot);
					botellasDAO.actualizarTablaB(b.tablaBot);
				} 
			}
		});
		btnGuardar.setIcon(new ImageIcon("iconos\\salvar.png"));
		btnGuardar.setBounds(39, 226, 124, 38);
		panelComponentes.add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setIcon(new ImageIcon("iconos\\cruz-entrecruzada.png"));
		btnCancelar.setBounds(39, 290, 124, 38);
		panelComponentes.add(btnCancelar);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBackground(SystemColor.activeCaption);
		panelTabla.setBounds(214, 78, 481, 222);
		contentPane.add(panelTabla);
		setVisible(true);
		
		String columnasBot[] = {"ID Botella", "Nombre Bot.", "Precio Bot", "Niv. Alcohol", "Destilado", "Cantidad Botellas"};
		String datosBot[][] = {};
		
		tablaModBot = new JTable(datosBot, columnasBot);
		JScrollPane scrollB = new JScrollPane(tablaModBot);
		scrollB.setBounds(10, 9, 657, 180);
		panelTabla.add(scrollB);
		botellasDAO.actualizarTablaB(tablaModBot);
		
		ListSelectionModel model = tablaModBot.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model.isSelectionEmpty()) {
					//GET SELECTED ROW
					selectedRow=model.getMinSelectionIndex();
					selectedColumn = tablaModBot.getSelectedColumn();
					
					txtNombre.setText(tablaModBot.getValueAt(selectedRow, 1).toString());
					cboPrecio.setSelectedItem(tablaModBot.getValueAt(selectedRow, 2).toString());
					cboNivel.setSelectedItem(tablaModBot.getValueAt(selectedRow, 3).toString());
					cboDestilado.setSelectedItem(tablaModBot.getValueAt(selectedRow, 4));
					txtCantidad.setText(tablaModBot.getValueAt(selectedRow, 5).toString());
				}
			}
		});
		
	}
}
