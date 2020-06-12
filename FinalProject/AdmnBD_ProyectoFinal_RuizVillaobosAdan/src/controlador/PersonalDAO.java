package controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import conexionDB.DBConnection;
import modelo.Personal;

import vista.ResultSetTableModel;

public class PersonalDAO {
	String user = "adan";
	String pass = "12345";
	String url = "jdbc:mysql://localhost/BD_InventarioBar?useTimezone=true&serverTimezone=UTC";
	
//final String tabla_Personal="personal";
	
	
	
	public boolean insertarRegistros(Personal p) {
		boolean finalizo = false;
		try {
			PreparedStatement mPS = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO Personal VALUES (?,?,?,?,?,?,?,?,?)");
			mPS.setString(1, p.getId());
			mPS.setString(2, p.getNombre());
			mPS.setString(3, p.getPrimerAp());
			mPS.setString(4, p.getSegundoAp());
			mPS.setString(5, p.getPuesto());
			mPS.setString(6, p.gethEntrada());
			mPS.setString(7, p.gethSalida());
			mPS.setInt(8, p.getSueldo());
			mPS.setInt(9, p.getDiasTrabajados());
			mPS.executeUpdate();
			finalizo = true;
			mPS.close();
		}catch(SQLException e) {
			e.printStackTrace();
			finalizo = false;
		}
		return finalizo;
	}
	
	
	
	public boolean eliminarRegistro(int id) {
		boolean finalizo = false;
		try {
			PreparedStatement mPS = DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM Personal WHERE id_Usuario = ?");
			mPS.setInt(1, id);
			mPS.executeUpdate();
	        finalizo = true;
	        mPS.close();			
		} catch (SQLException e) {
			// TODO: handle exception
			 e.printStackTrace();
	         finalizo = false;
		}
		return finalizo;
	}
	
	public boolean actualizarRegistros(Personal p) {
		boolean finalizo = false;
		
		try {
			PreparedStatement mPS = DBConnection.getInstance().getConnection().prepareStatement("UPDATE Personal SET " +
					"Primer_Nombre= ?, " +
					"Ap_Paterno= ?, "+ 
					"Ap_Materno= ?, "+
					"Puesto= ?, " +
					"Entrada = ?, " +
					"Salida = ?, " +
					"Sueldo_dia= ?, " +
					"Dias_Trabajados = ? "+
					"WHERE id_Usuario = ?");
			
			mPS.setString(1, p.getNombre());
			mPS.setString(2, p.getPrimerAp());
			mPS.setString(3, p.getSegundoAp());
			mPS.setString(4, p.getPuesto());
			mPS.setString(5, p.gethEntrada());
			mPS.setString(6, p.gethSalida());
			mPS.setInt(7, p.getSueldo());
			mPS.setInt(8, p.getDiasTrabajados());
			mPS.setString(9, p.getId());
			mPS.executeUpdate();
	        finalizo = true;
	        mPS.close();
		} catch (SQLException e) {
			// TODO: handle exception
			 e.printStackTrace();
	         finalizo = false;
		}
		return finalizo;
	}
	public void actualizarTabla(JTable tabla) {
		String controlador = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost/BD_InventarioBar?useTimezone=true&serverTimezone=UTC";
		String query = "SELECT * FROM Personal";
		String user= "adan";
		String password="12345";
		
		ResultSetTableModel modeloDatos = null;
		try {
			modeloDatos = new ResultSetTableModel(controlador, URL, user, password, query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tabla.setModel(new DefaultTableModel());
		tabla.setModel(modeloDatos);
	}
	public void actualizarTabla2(JTable tabla,String consulta) {
		String controlador = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost/BD_InventarioBar?useTimezone=true&serverTimezone=UTC";
		//String consulta = "SELECT * FROM Alumnos";
		String user= "adan";
		String password="12345";
		
		ResultSetTableModel modeloDatos = null;
		try {
			modeloDatos = new ResultSetTableModel(controlador, URL, "adan", "12345", consulta);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tabla.setModel(modeloDatos);
	}
	
	public void login(String user, String pass, String url) throws SQLException {
		DBConnection.getInstance();
	}

}