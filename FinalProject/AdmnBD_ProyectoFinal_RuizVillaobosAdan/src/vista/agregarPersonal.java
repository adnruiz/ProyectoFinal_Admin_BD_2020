package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.PersonalDAO;
import modelo.Personal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class agregarPersonal extends JFrame {

	private JPanel contentPane;
	private JTextField txt_IDUsuario, txtNombre, txtApellidoPaterno, txtApellidoMaterno;
	JComboBox <String>cboPuesto, cboEntrada, cboSalida, cboSueldo, cboDias;
	
	MetodosMagicosP magic = new MetodosMagicosP();
	//static agregarPersonal frame = new agregarPersonal();
	PersonalDAO personalDAO = new PersonalDAO();
	principal p = new principal();
	/**
	 * Create the frame.
	 */
	public agregarPersonal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 332, 463);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		Font f = new Font("Lucida Console", Font.BOLD, 13);
		
		JLabel lblTituloAgregarPer = new JLabel("AGREGAR USUARIO");
		lblTituloAgregarPer.setForeground(SystemColor.textHighlight);
		lblTituloAgregarPer.setFont(new Font("Lucida Console", Font.BOLD, 18));
		lblTituloAgregarPer.setBounds(62, 11, 190, 19);
		panel.add(lblTituloAgregarPer);
		
		JLabel lbl_IDUsuario = new JLabel();
		lbl_IDUsuario = magic.configuracionEtiqueta(lbl_IDUsuario, "ID:", f, 38, 41, 89, 19);
		panel.add(lbl_IDUsuario);
		
		txt_IDUsuario = magic.configuracionCajasTexto(txt_IDUsuario, f, 150, 41, 116, 20);
		panel.add(txt_IDUsuario);
		txt_IDUsuario.setColumns(10);
		
		JLabel lblNombre = new JLabel("");
		lblNombre = magic.configuracionEtiqueta(lblNombre, "NOMBRE:", f, 10, 78, 116, 20);
		panel.add(lblNombre);
		
		txtNombre = magic.configuracionCajasTexto(txtNombre, f, 150, 78, 116, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel();
		lblApellidoPaterno = magic.configuracionEtiqueta(lblApellidoPaterno, "APELLIDO PAT.", f, 10, 118, 141, 19);
		panel.add(lblApellidoPaterno);
		
		txtApellidoPaterno = magic.configuracionCajasTexto(txtApellidoPaterno,f, 150, 117, 116, 20);
		panel.add(txtApellidoPaterno);
		txtApellidoPaterno.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel();
		lblApellidoMaterno = magic.configuracionEtiqueta(lblApellidoMaterno, "APELLIDO MAT.", f, 10, 148, 141, 20);
		panel.add(lblApellidoMaterno);
		
		txtApellidoMaterno = magic.configuracionCajasTexto(txtApellidoMaterno, f, 150, 148, 116, 20);
		panel.add(txtApellidoMaterno);
		txtApellidoMaterno.setColumns(10);
		
		JLabel lblPuesto = new JLabel();
		lblPuesto = magic.configuracionEtiqueta(lblPuesto, "PUESTO:", f, 10, 178, 116, 23);
		panel.add(lblPuesto);
		
		
		cboPuesto = magic.configuracionCombo(cboPuesto, magic.puestos(), f,150, 179, 116, 20);
		panel.add(cboPuesto);
		
		JLabel lblEntrada = new JLabel();
		lblEntrada = magic.configuracionEtiqueta(lblEntrada, "H. ENTRADA", f, 10, 212, 130, 23);
		panel.add(lblEntrada);
		
		
		cboEntrada = magic.configuracionCombo(cboEntrada, magic.entrada(), f, 150, 215, 116, 20);
		panel.add(cboEntrada);
		
		JLabel lblSalida = new JLabel();
		lblSalida = magic.configuracionEtiqueta(lblSalida, "H. SALIDA", f, 10, 246, 141, 20);
		panel.add(lblSalida);
		
		
		cboSalida = magic.configuracionCombo(cboSalida, magic.salida(), f, 150, 246, 116, 20);
		panel.add(cboSalida);
		
		JLabel lblSueldo = new JLabel();
		lblSueldo = magic.configuracionEtiqueta(lblSueldo, "SUELDO:", f, 10, 277, 130, 25);
		panel.add(lblSueldo);
		
		
		cboSueldo = magic.configuracionCombo(cboSueldo, magic.sueldo(), f, 150, 282, 116, 20);
		panel.add(cboSueldo);
		
		JLabel lblDias = new JLabel();
		lblDias = magic.configuracionEtiqueta(lblDias, "DIAS TRABJ.", f, 10, 325, 141, 19);
		panel.add(lblDias);
		
		
		cboDias = magic.configuracionCombo(cboDias, magic.dias(), f, 150, 324, 116, 20);
		panel.add(cboDias);
		
		personalABCC per = new personalABCC();
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				personalDAO.actualizarTabla(per.tableAltas);
			}
		});
		btnCerrar.setIcon(new ImageIcon(/*C:\\Users\\adnru\\OneDrive\\Escritorio\\8\u00B0\\FinalProject\\AdmnBD_ProyectoFinal_RuizVillaobosAdan\\*/"iconos\\cruz-entrecruzada.png"));
		btnCerrar.setBounds(205, 375, 103, 33);
		panel.add(btnCerrar);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Double.parseDouble(txt_IDUsuario.getText());
					Personal pers = new Personal(txt_IDUsuario.getText(), txtNombre.getText(), txtApellidoPaterno.getText(), txtApellidoMaterno.getText(),
							cboPuesto.getSelectedItem().toString(), cboSalida.getSelectedItem().toString(), cboEntrada.getSelectedItem().toString(),
							Integer.parseInt(cboSueldo.getSelectedItem().toString()), Integer.parseInt(cboDias.getSelectedItem().toString()));
					boolean validacion1 = magic.validarComponentes(pers);
					boolean validacion2 = magic.validarEspacios(pers);
					if(validacion1 || validacion2) {
						 JOptionPane.showMessageDialog(getParent(), "No se pudo agregar, datos insuficientes");
					}else {
						int cont= 0;
						int aux = p.tabla1.getRowCount();
						for(int i = 0; i < aux; i++) {
							//System.out.println(p.tabla1.getModel().getValueAt(i, 0));
							//System.out.println("txt" + txt_IDUsuario.getText() + "tabla" + p.tabla1.getModel().getValueAt(i,0) );
							int t = Integer.parseInt(txt_IDUsuario.getText());
							int t2 = Integer.parseInt(p.tabla1.getModel().getValueAt(i,0).toString());
							if(t == t2) {
								cont = cont + 1;
							}//finaliza if
						}//finaliza for
						if(cont>=1) {
							 JOptionPane.showMessageDialog(getParent(), "No se pudeo agregar, este ID ya existe!");
						}else {
							 JOptionPane.showMessageDialog(getParent(), "REGISTRO AGREGADO CORRECTAMENTE");
							 personalDAO.insertarRegistros(pers);
							 personalDAO.actualizarTabla(per.tableAltas);
						}//else
					}//else
				}catch(NumberFormatException e1){  
					  JOptionPane.showMessageDialog(getParent(), "ID DEBE SER UN NUMERO");
				}  
			}
		});
		btnAgregar.setIcon(new ImageIcon(/*C:\\Users\\adnru\\OneDrive\\Escritorio\\8\u00B0\\FinalProject\\AdmnBD_ProyectoFinal_RuizVillaobosAdan\\*/"iconos\\anadir.png"));
		btnAgregar.setBounds(10, 375, 123, 33);
		panel.add(btnAgregar);
		
		JButton btnReestablecer = new JButton("REESTABLECER");
		btnReestablecer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object pila = magic.reestablcerComp(txt_IDUsuario, txtNombre, txtApellidoPaterno, txtApellidoMaterno, cboPuesto, cboEntrada, cboSalida, cboSueldo, cboDias);
			}
		});
		btnReestablecer.setIcon(new ImageIcon(/*C:\\Users\\adnru\\OneDrive\\Escritorio\\8\u00B0\\FinalProject\\AdmnBD_ProyectoFinal_RuizVillaobosAdan\\*/"iconos\\borrador.png"));
		btnReestablecer.setBounds(94, 419, 139, 33);
		panel.add(btnReestablecer);
	}
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

}
