package controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import conexionDB.DBConnection;
import modelo.Botellas;

import vista.ResultSetTableModel;

public class BotellasDAO {
	String user = "adan";
	String pass = "12345";
	String url = "jdbc:mysql://localhost/BD_InventarioBar?useTimezone=true&serverTimezone=UTC";
	
	public boolean insertarRegistros(Botellas b) {
		boolean finalizo = false;
		try {
			PreparedStatement mPS = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO inventario_botellas VALUES (?,?,?,?,?,?)");
			mPS.setInt(1, b.getId_B());
			mPS.setString(2, b.getNombre_botella());
			mPS.setDouble(3, b.getPrecio_botella());
			mPS.setDouble(4, b.getNivel_alcohol());
			mPS.setString(5, b.getTipo_destilado());
			mPS.setInt(6, b.getCantidad_botellas());
			mPS.executeUpdate();
			finalizo=true;
			mPS.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			finalizo = true;
		}
		return finalizo;
	}
	
	public boolean eliminarRegistro(int id) {
		boolean finalizo = false;
		try {
			PreparedStatement mPS = DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM inventario_botellas WHERE id_Bot = ?");
			mPS.setInt(1, id);
			mPS.executeUpdate();
			finalizo=true;
			mPS.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			finalizo = false;
		}
		return finalizo;
	}
	
	public boolean actualizarRegistros(Botellas b) {
		boolean finalizo = false;
		try {
			PreparedStatement mPS = DBConnection.getInstance().getConnection().prepareStatement("UPDATE inventario_botellas SET " +
					//"id_Bot = ?, " +
					"Nombre_Botella = ?, " +
					"Precio_Botella = ?, "+
					"Nivel_Alcohol = ?, " +
					"Tipo_Destilado = ?, " +
					"Cantidad_Botellas = ? " +
					"WHERE id_Bot = ?");
			mPS.setString(1, b.getNombre_botella());
			mPS.setDouble(2, b.getPrecio_botella());
			mPS.setDouble(3, b.getNivel_alcohol());
			mPS.setString(4, b.getTipo_destilado());
			mPS.setInt(5, b.getCantidad_botellas());
			mPS.setInt(6, b.getId_B());
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
	
	public boolean actualizarRegistros2(Botellas b) {
		boolean finalizo = false;
		try {
			PreparedStatement mPS = DBConnection.getInstance().getConnection().prepareStatement("UPDATE inventario_botellas SET " +
					//"id_Bot = ?, " +
					//"Nombre_Botella = ?, " +
					//"Precio_Botella = ?, "+
					//"Nivel_Alcohol = ?, " +
					//"Tipo_Destilado = ?, " +
					"Cantidad_Botellas = ? " +
					"WHERE id_Bot = ?");
			//mPS.setString(1, b.getNombre_botella());
			//mPS.setDouble(2, b.getPrecio_botella());
			//mPS.setDouble(3, b.getNivel_alcohol());
			//mPS.setString(4, b.getTipo_destilado());
			mPS.setInt(1, b.getCantidad_botellas());
			mPS.setInt(2, b.getId_B());
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
	
	public void actualizarTablaB(JTable tabla) {
		String controlador = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost/BD_InventarioBar?useTimezone=true&serverTimezone=UTC";
		String query = "SELECT * FROM inventario_botellas";
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
	
	public void actualizarTabla2B(JTable tabla,String consulta) {
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
