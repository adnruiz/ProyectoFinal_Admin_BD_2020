package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.BotellasDAO;
import controlador.PersonalDAO;
import modelo.Botellas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class agregarBot extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtCantidad;
	JComboBox <String> cboPrecio, cboNivel, cboDestilado;
	MetodosMagicoBotellas magic = new MetodosMagicoBotellas();
	BotellasDAO botellasDAO = new BotellasDAO();
	botellasABCC botellas = new botellasABCC();
	//principal p = new principal();
	/**
	 * Create the frame.
	 */
	Font f = new Font("Lucida Console", Font.BOLD, 11);
	public agregarBot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_IDBot = new JLabel();
		lb_IDBot = magic.configuracionEtiqueta(lb_IDBot, "ID", f, 10, 58, 46, 14);
		contentPane.add(lb_IDBot);
		
		JLabel lblTitulo = new JLabel("AGREGAR BOTELLA");
		lblTitulo.setIcon(new ImageIcon("iconos\\vino.png"));
		lblTitulo.setForeground(SystemColor.textHighlight);
		lblTitulo.setFont(new Font("Lucida Console", Font.BOLD, 18));
		lblTitulo.setBounds(55, 11, 222, 36);
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel();
		lblNombre = magic.configuracionEtiqueta(lblNombre, "Nom. Botella", f, 10, 93, 107, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel();
		lblPrecio = magic.configuracionEtiqueta(lblPrecio, "Precio", f, 10, 131, 107, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblNivel = new JLabel();
		lblNivel = magic.configuracionEtiqueta(lblNivel, "Niv. Alcohol", f, 10, 167, 107, 14);
		contentPane.add(lblNivel);
		
		JLabel lblDestilado = new JLabel();
		lblDestilado = magic.configuracionEtiqueta(lblDestilado, "Destilado", f, 10, 205, 107, 14);
		contentPane.add(lblDestilado);
		
		JLabel lblCantidad = new JLabel();
		lblCantidad = magic.configuracionEtiqueta(lblCantidad, "Cantidad", f, 10, 236, 107, 14);
		contentPane.add(lblCantidad);
		
		txtID = new JTextField();
		txtID = magic.configuracionCajasTexto(txtID, f, 193, 58, 143, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre = magic.configuracionCajasTexto(txtNombre, f, 193, 87, 143, 20);
		contentPane.add(txtNombre);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad = magic.configuracionCajasTexto(txtCantidad, f, 193, 236, 143, 20);
		contentPane.add(txtCantidad);
		
		
		cboPrecio = magic.configuracionCombo(cboPrecio, magic.precios(), f, 193, 128, 143, 20);
		contentPane.add(cboPrecio);
		
		
		cboNivel = magic.configuracionCombo(cboNivel, magic.niveles(), f, 193, 167, 143, 20);
		contentPane.add(cboNivel);
		
		
		cboDestilado = magic.configuracionCombo(cboDestilado, magic.destilados(), f, 193, 202, 143, 20);
		contentPane.add(cboDestilado);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer.parseInt(txtID.getText());
				Botellas bot = new Botellas(Integer.parseInt(txtID.getText()), txtNombre.getText(), Double.parseDouble(cboPrecio.getSelectedItem().toString()),
						Double.parseDouble(cboNivel.getSelectedItem().toString()), cboDestilado.getSelectedItem().toString(), Integer.parseInt(txtCantidad.getText()));
				boolean validacion1 = magic.validarComponentes(bot);
				boolean validacion2 = magic.validarEspacios(bot);
				if(validacion1 || validacion2) {
					 JOptionPane.showMessageDialog(getParent(), "No se pudo agregar, datos insuficientes");
				}else {
					int cont = 0;
					int aux = botellas.tablaBot.getRowCount();
					for(int i = 0; i<aux; i++) {
						int a = Integer.parseInt(txtID.getText());
						int a2 = Integer.parseInt(botellas.tablaBot.getModel().getValueAt(i,0).toString());
						if(a == a2) {
							cont = cont +1;
						}//finaliza if
					}//finaliza for
					if(cont>=1) {
						JOptionPane.showMessageDialog(getParent(), "No se pudeo agregar, este ID ya existe!");
					}else {
						JOptionPane.showMessageDialog(getParent(), "REGISTRO AGREGADO CORRECTAMENTE");
						botellasDAO.insertarRegistros(bot);
						botellasDAO.actualizarTablaB(botellas.tablaBot);
					}
				}
			}
		});
		btnAgregar.setIcon(new ImageIcon("iconos\\vino.png"));
		btnAgregar.setBounds(10, 277, 130, 36);
		contentPane.add(btnAgregar);
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				botellasDAO.actualizarTablaB(botellas.tablaBot);
				//personalDAO.actualizarTabla(per.tableAltas);
			}
		});
		btnCerrar.setIcon(new ImageIcon("iconos\\cruz-entrecruzada.png"));
		btnCerrar.setBounds(193, 277, 130, 36);
		contentPane.add(btnCerrar);
		
		JButton btnRestablecer = new JButton("REESTABLECER");
		btnRestablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object pila = magic.reestablecerComp(txtID, txtNombre, txtCantidad, cboPrecio, cboNivel, cboDestilado);
			}
		});
		btnRestablecer.setIcon(new ImageIcon("iconos\\borrador.png"));
		btnRestablecer.setBounds(100, 328, 156, 36);
		contentPane.add(btnRestablecer);
		setVisible(true);
		
	}
	
	/*
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agregarBot frame = new agregarBot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

}
