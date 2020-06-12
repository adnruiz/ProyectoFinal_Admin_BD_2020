package vista;

import javax.swing.table.DefaultTableModel;

import modelo.Botellas;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class MetodosMagicoBotellas {
	public JLabel configuracionEtiqueta(JLabel lbl,String texto, Font font, int x, int y, int width, int height){
		lbl=new JLabel(texto);
		lbl.setBounds(x, y, width, height);
		lbl.setFont(font);
		return lbl;
		
	}
	
	public JTextField configuracionCajasTexto(JTextField tf, Font font, int x,int y,int width, int height){
		tf=new JTextField();
		tf.setBounds(x, y, width, height);
		tf.setFont(font);
		return tf;
	}
	
	public JButton configuracionBoton(JButton btn,String texto,int x,int y,int width, int height){
		btn=new JButton(new ImageIcon(texto));
		btn.setBounds(x, y, width, height);;
		return btn;
	}
	
	public JComboBox<String>configuracionCombo(JComboBox<String> combo,String []txt,Font font, int x,int y,int width, int height){
		combo=new JComboBox<>(txt);
		combo.setBounds(x, y, width, height);
		return combo;
	}
	
	//Arreglos para comboBoxes
	public String[] precios() {
		String[] precios= {"590.00","699.99","799.99","999.99","1199.99","1200.00","3000.00"};
		return precios;
	}
	public String[]niveles(){
		String[]niveles= {"12.5","17.5","25.3","35.8","37.5","40.0","45.5","47.3","70.2"};
		return niveles;
	}
	public String[] destilados() {
		String[]destilados= {"Vino","Tequila","Whisky","Coñac","Brandy","Vodka","Ron","Ginebra","Licor","Mezcal","Champanhe"};
		return destilados;
	}
	
	public boolean validarEspacios(Botellas b) {
		boolean resultado = false;
		String n1 ="",n2 ="",n3 ="",n4 ="",n5 ="",n6 ="";
		n1=String.valueOf(b.getId_B());
		n2=b.getNombre_botella();
		n3=String.valueOf(b.getPrecio_botella());
		n4=String.valueOf(b.getNivel_alcohol());
		n5=b.getTipo_destilado();
		n6=String.valueOf(b.getCantidad_botellas());
		
		n1=n1.replaceAll(" " , "");
		n2=n2.replaceAll(" " , "");
		n3=n3.replaceAll(" " , "");
		n4=n4.replaceAll(" " , "");
		n5=n5.replaceAll(" " , "");
		n6=n6.replaceAll(" " , "");
		
		if(n1.length()==0 ||n2.length()==0 || n3.length()==0 || n4.length()==0 || n5.length()==0 || n6.length()==0){
			resultado =true;
			return resultado;
		}else{
			resultado=false;
			return resultado;
		}
	}
	
	public boolean validarComponentes(Botellas b) {
		if(b.getId_B()==0 || b.getNombre_botella().equals("") || b.getPrecio_botella()==0.0 ||
				b.getNivel_alcohol()==0.0 || b.getTipo_destilado().equals("") || b.getCantidad_botellas()==0){
			return true;
		}else {
			return false;
		}
	}
	public Object reestablecerComp(JTextField id, JTextField nombre, JTextField cantidad, JComboBox<String> precio, JComboBox<String> niveles, JComboBox<String>destilado) {
		id.setText("");
		nombre.setText("");
		cantidad.setText("");
		precio.setSelectedItem(null);
		niveles.setSelectedItem(null);
		destilado.setSelectedItem(null);
		
		Stack<Object> pila = new Stack<>();
		return pila;
	}
	public Object reestablecerComp2(JTextField nombre, JTextField cantidad, JComboBox<String> precio, JComboBox<String> niveles, JComboBox<String>destilado) {
		
		nombre.setText("");
		cantidad.setText("");
		precio.setSelectedItem(null);
		niveles.setSelectedItem(null);
		destilado.setSelectedItem(null);
		
		Stack<Object> pila = new Stack<>();
		return pila;
	}
}
