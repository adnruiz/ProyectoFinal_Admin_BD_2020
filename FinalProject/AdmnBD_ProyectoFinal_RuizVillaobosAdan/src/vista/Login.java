package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import conexionDB.DBConnection;

public class Login  extends  JFrame  implements ActionListener, KeyListener{
	//Instancia de la clase metodosMagicos
	MetodosMagicosP magic = new MetodosMagicosP();
	
	//Variables para la ventana LOGIN
	public final String usuario = "adan";
	public final String contraseña = "12345";
	//AGREGAR USUARIO Y CONTRASEÑA DE MYSQL

	
	JPasswordField password;
	JTextField user;
	JButton btnBorrar,btnIngresar;
	
	public Login() {
		configuracionLogin();
	}
	public void configuracionLogin(){
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350,250);
		setLocationRelativeTo(null);
		setTitle("BAR");
		setVisible(true);
		setResizable(false);
		
		Font f1 = new Font("Dosis", Font.BOLD, 24);
		
		JLabel lblUser = new JLabel();
		lblUser = magic.configuracionEtiqueta(lblUser, "Usuario", f1,  5, 20, 100, 35);
		add(lblUser);
		
		user = new JTextField();
		user=magic.configuracionCajasTexto(user, f1, 110, 25, 180, 30);
		add(user);
		
		JLabel lblPassWrd = new JLabel();
		lblPassWrd= magic.configuracionEtiqueta(lblPassWrd, "Contraseña", f1, 5, 70, 150, 35);
		add(lblPassWrd);
		
		password = new JPasswordField();
		password.setBounds(150, 75, 150, 30);
		add(password);
		
		btnBorrar = new JButton();
		btnBorrar= magic.configuracionBoton(btnBorrar, "iconos/borrador.png", 50, 120, 70, 70);
		add(btnBorrar);
		btnBorrar.addActionListener(this);
		btnBorrar.addKeyListener(this);
		
		btnIngresar = new JButton();
		btnIngresar = magic.configuracionBoton(btnIngresar, "iconos/aceptar.png", 200, 120, 70, 70);
		add(btnIngresar);
		btnIngresar.addActionListener(this);
		btnIngresar.addKeyListener(this);
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			
			btnIngresar.doClick();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==btnBorrar) {
			user.setText("");
			password.setText("");
		}
		if(a.getSource()==btnIngresar) {
			if((user.getText().equals("") && password.getText().equals(""))){
				JOptionPane.showMessageDialog(getParent(), "CAMPOS VACIOS: usuario & contraseña ");
			}
			else if((user.getText().equals("") || password.getText().equals(""))){
				if(user.getText().equals("")){
					JOptionPane.showMessageDialog(getParent(), "CAMPO VACIO: Usuario");

				}else{
					JOptionPane.showMessageDialog(getParent(), "CAMPO VACIO: Contraseña");
				}
			}//cierre de else if algun campo vacio
			else{
				//PersonalDAO pdao= new PersonalDAO();
				
				if(user.getText().equals(usuario) && password.getText().equals(contraseña)){
					try {
						DBConnection.getInstance();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(getParent(), "Bienvenido... "+ user.getText());
					
					principal frame = new principal();
					frame.setVisible(true);
					
				}else if(!password.getText().equals(contraseña)){
					JOptionPane.showMessageDialog(getParent(), "CONTRASEÑA INCORRECTA");
					
				}else if(!user.getText().equals(usuario) ){
					JOptionPane.showMessageDialog(getParent(), "USUARIO NO REGISTRADO");
				}
				
			}//Cierre de else comprobacion
			
		}//cierre de if btnIngresar
	}
	
}