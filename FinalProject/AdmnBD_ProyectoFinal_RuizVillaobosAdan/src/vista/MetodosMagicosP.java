package vista;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import modelo.Personal;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class MetodosMagicosP {
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
	public String[] puestos(){
		String []puestos={"  ","Gerente","C.Meseros", "J.Barra", "J.Cocina", "Aux.Barra",
				"Aux.Cocina", "Mesero", "Garrotero"};
		return puestos;
	}
	public String[] entrada() {
		String[]entrada={"12:00:00", "18:00:00", "21:00:00"};
		return entrada;
	}
	public String[]salida(){
		String[]salida= {"19:00:00","03:30:00","05:45:00"};
		return salida;
	}
	public String[]sueldo(){
		String[]sueldo = {"650","450","350","200"};
		return sueldo;
	}
	public String[]dias(){
		String[]dias = {"2","3","4","5","6"};
		return dias;
	}
	public boolean validarEspacios(Personal p){
		boolean resultado=false;
		String n1="",n5="",n4="",n3="",n2="",n6="",n7="",n8="",n9="";
		n1=p.getId();
		n2=p.getNombre();
		n3=p.getPrimerAp();
		n4=p.getSegundoAp();
		n5=p.getPuesto();
		n6=p.gethEntrada();
		n7=p.gethSalida();
		n8=String.valueOf(p.getSueldo());
		n9=String.valueOf(p.getDiasTrabajados());
		
		n1=n1.replaceAll(" " , "");
		n2=n2.replaceAll(" " , "");
		n3=n3.replaceAll(" " , "");
		n4=n4.replaceAll(" " , "");
		n5=n5.replaceAll(" " , "");
		n6=n6.replaceAll(" " , "");
		n7=n7.replaceAll(" " , "");
		n8=n8.replaceAll(" " , "");
		n9=n9.replaceAll(" " , "");
		
		if(n1.length()==0 ||n2.length()==0 || n3.length()==0 || n4.length()==0 || n5.length()==0 || n6.length()==0 || n7.length()==0 || n8.length()==0||n9.length()==00){
			resultado =true;
			return resultado;
		}else{
			resultado=false;
			return resultado;
		}
		
	}
	public boolean validarComponentes(Personal p){
		
		if(p.getId().equals("") || p.getNombre().equals("") || p.getPrimerAp().equals("") || p.getSegundoAp().equals("") || p.getPuesto().equals("")||
				p.gethEntrada().equals("")||p.gethSalida().equals("")|| p.getSueldo()==0 || p.getDiasTrabajados() ==0){
			return true;
		}else{
			return false;
		}
	}
	public Object reestablcerComp(JTextField id, JTextField nom, JTextField apPat, JTextField apMat, JComboBox<String> puesto,JComboBox<String> entrada, JComboBox<String> salida, JComboBox<String>sueldo, JComboBox<String>dias) {
		id.setText("");
		nom.setText("");
		apPat.setText("");
		apMat.setText("");
		puesto.setSelectedItem(null);
		entrada.setSelectedItem(null);
		salida.setSelectedItem(null);
		sueldo.setSelectedItem(null);
		dias.setSelectedItem(null);
		
		
		Stack<Object> pila=new Stack<>();
		/*pila.add(id);
		pila.add(nom);
		pila.add(apPat);
		pila.add(apMat);
		pila.add(puesto);
		pila.add(entrada);
		pila.add(salida);
		pila.add(sueldo);
		pila.add(dias);*/
		return pila;
	} 
	public Object reestablcerComp2( JTextField nom, JTextField apPat, JTextField apMat, JComboBox<String> puesto,JComboBox<String> entrada, JComboBox<String> salida, JComboBox<String>sueldo, JComboBox<String>dias) {
		
		nom.setText("");
		apPat.setText("");
		apMat.setText("");
		puesto.setSelectedItem(null);
		entrada.setSelectedItem(null);
		salida.setSelectedItem(null);
		sueldo.setSelectedItem(null);
		dias.setSelectedItem(null);
		
		
		Stack<Object> pila=new Stack<>();
		return pila;
	} 
	
}