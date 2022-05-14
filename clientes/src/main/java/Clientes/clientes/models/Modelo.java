package Clientes.clientes.models;

import Clientes.clientes.models.Conexion;

public class Modelo {
	String text;
	String resultSetA;
	{

		new Conexion();

		this.resultSetA = Conexion.getValues("Videoclub", "cliente");

		
	}
	
	//Getters & Setters 
	public String getResultSetA() {
		return resultSetA;
	}
	public void setResultSetA(String resultSetA) {
		this.resultSetA = resultSetA;
	}
	
	// Llamamos al metodo obtener valores
	public void Actualizar() {
		this.resultSetA = Conexion.getValues( "Videoclub","cliente");
	}
	
	// Llamamos al metodo eliminar introduciendo el id como parametro
	public void Delete(String num1) {
		Conexion.deleteRecord( "Videoclub","cliente", num1);
	}
	
	// Llamamos al metodo crear cliente con todos sus parametros
	public void Crear(String nombre, String apellido, String direccion, int dni1, String fecha) {
		Conexion.insertData("Videoclub", "cliente", nombre, apellido, direccion, dni1, fecha);
	}

}
