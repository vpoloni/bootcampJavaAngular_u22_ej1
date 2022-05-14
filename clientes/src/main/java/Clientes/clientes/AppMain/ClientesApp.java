package Clientes.clientes.AppMain;

import Clientes.clientes.controllers.Controlador;
import Clientes.clientes.models.Conexion;
import Clientes.clientes.models.Modelo;
import Clientes.clientes.views.Vista;

public class ClientesApp {

	public static void main(String[] args) {
		
		// Inicializacion de toda la aplicacion
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Conexion conexion = new Conexion();
		Controlador controlador = new Controlador(modelo, vista, conexion);
		
	}

}
