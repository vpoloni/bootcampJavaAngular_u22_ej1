package Clientes.clientes.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexion {

	// Conexion a la base de datos
	public static Connection conexionDB() {
		Connection conexion=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.17:3306?useTimezone=true&serverTimezone=UTC", "remote", "Reus_2022");
			System.out.println("Server Connected");
			return conexion;
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
			return conexion;
		}
		
	}
	
	// Metodo que inserta datos en tablas MYSQL
	public static void insertData(String db, String table_name, String name, String lastname, String direction, int dni, String date) {
		
		Connection Sql_conexion=conexionDB();
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = Sql_conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + " (Nombre, Apellido, direccion, dni, fecha) VALUE("
					+ "\"" + name + "\", "
					+ "\"" + lastname + "\", "
					+ "\"" + direction + "\", "
					+ "\"" + dni + "\", "
					+ "\"" + date + "\"); ";
			Statement st = Sql_conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
			Sql_conexion.close();
		
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	
	// Metodo que obtiene valores MYSQL
	public static String getValues(String db, String table_name) {

		String resultado="";
		
		Connection Sql_conexion=conexionDB();
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = Sql_conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = Sql_conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
		
			while (resultSet.next()) {
				
						resultado=resultado+"ID: " + resultSet.getString("Id")+" "
						+ "Nombre: " + resultSet.getString("nombre")+ " "
						+ "Apellido: " + resultSet.getString("apellido")+ " "
						+ "Direccion: " + resultSet.getString("direccion")+ " "
						+ "Dni: " + resultSet.getString("dni")+ " "
						+ "Fecha: " + resultSet.getString("fecha")+ "\n";		
			}
			
			Sql_conexion.close();
			
		
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisicion de datos");
	
		}
		return resultado;
	}
	
	// Metodo que elimina valores de nuestra Base de Datos
	public static void deleteRecord(String db, String table_name, String ID) {
		
		Connection Sql_conexion=conexionDB();
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = Sql_conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "DELETE FROM " + table_name + " WHERE ID = \""+ ID + "\"";
			Statement st = Sql_conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos borrados correctamente");
			Sql_conexion.close();
			
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}
	
}
