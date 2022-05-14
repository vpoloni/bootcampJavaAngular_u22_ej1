package Clientes.clientes.controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Clientes.clientes.models.Modelo;
import Clientes.clientes.views.Vista;
import Clientes.clientes.models.Conexion;

public class Controlador implements ActionListener {
	
	private Modelo modelo;
	private Vista vista;
	private Conexion conexion;
	private java.sql.ResultSet resultSetA;
	
	public Controlador(Modelo modelo, Vista vista, Conexion conexion) {
		this.modelo = modelo;
		this.vista = vista;
		this.conexion = conexion;
		this.vista.ButtonVer.addActionListener(this);
		this.vista.ButtonCrear.addActionListener(this);
		this.vista.ButtonEditar.addActionListener(this);
		this.vista.ButtonEliminar.addActionListener(this);
		this.vista.ButtonActualizacion.addActionListener(this);
		vista.setVisible(true);// fa que surti la finestra grafica
		 System.out.println( modelo.getResultSetA());// Imprimimos en consola los valores de la base de datos
	}

	// Accion de los botones despues de apretarse
	public void actionPerformed(ActionEvent evento) {
		// Si apretamos el boton ver, veremos todos los clientes
		if(vista.ButtonVer == evento.getSource()) {
			vista.textPane.setText(modelo.getResultSetA());
		}
		// Si apretamos el boton eliminar, nos pregunta que Id queremos eliminar y lo borra
		if(vista.ButtonEliminar == evento.getSource()) {
			String num1=JOptionPane.showInputDialog("Que Id quieres eliminar?");
			modelo.Delete(num1);
		}
		// Si apretamos el boton Crear, nos pregunta todos los datos y lo introduce en la base de datos
		if(vista.ButtonCrear == evento.getSource()) {
			String nombre=JOptionPane.showInputDialog("Pon el Nombre");
			String apellido=JOptionPane.showInputDialog("Pon el Apellido");
			String direccion=JOptionPane.showInputDialog("Pon la Direccion");
			String dni=JOptionPane.showInputDialog("Pon el DNI");
			int dni1=Integer.parseInt(dni);
			String fecha=JOptionPane.showInputDialog("Pon la Fecha");
			modelo.Crear(nombre, apellido, direccion, dni1, fecha);
		}
		// Si damos al boton Editar, nos pregunta que registro queremos editar. Lo elimina y
		//seguidamente te pide de rellenar los nuevos datos. Por ultimo lo introduce en la base de datos
		if(vista.ButtonEditar == evento.getSource()) {
			String num1=JOptionPane.showInputDialog("Que Id vas a modificar?");
			modelo.Delete(num1);
			String nombre=JOptionPane.showInputDialog("Untroduce Nombre");
			String apellido=JOptionPane.showInputDialog("Untroduce Apellido");
			String direccion=JOptionPane.showInputDialog("Untroduce la Direccion");
			String dni=JOptionPane.showInputDialog("Untroduce el DNI");
			int dni1=Integer.parseInt(dni);
			String fecha=JOptionPane.showInputDialog("Untroduce la Fecha");
			modelo.Crear(nombre, apellido, direccion, dni1, fecha);
		}
		// Si apretamos el boton Actualizar datos, borra la informacion en pantalla,
		//llama a la base de datos y pide la nueva informacion,
		// por ultimo, imprime los datos de DDBB y los imprime en pantalla.
		if(vista.ButtonActualizacion == evento.getSource()) {
			vista.textPane.setText("");
			modelo.Actualizar();
			vista.textPane.setText(modelo.getResultSetA());
			
		}
	}
	

	

}
