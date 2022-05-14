package Clientes.clientes.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Clientes.clientes.models.Conexion;
import javax.swing.JTextPane;


public class Vista extends JFrame {

	//Variables publicas
	private JPanel contentPane;
	public JButton ButtonVer;
	public JButton ButtonCrear;
	public JButton ButtonEditar;
	public JButton ButtonEliminar;
	public JButton ButtonActualizacion;
	
	public JTextPane textPane;

	// frontal con sus componentes
	public Vista() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonVer = new JButton("Ver");
		ButtonVer.setBounds(10, 11, 89, 23);
		contentPane.add(ButtonVer);
		
		ButtonCrear = new JButton("Crear");
		ButtonCrear.setBounds(10, 45, 89, 23);
		contentPane.add(ButtonCrear);
		
		ButtonEditar = new JButton("Editar");
		ButtonEditar.setBounds(10, 79, 89, 23);
		contentPane.add(ButtonEditar);
		
		ButtonEliminar = new JButton("Eliminar");
		ButtonEliminar.setBounds(10, 113, 89, 23);
		contentPane.add(ButtonEliminar);
		
		ButtonActualizacion = new JButton("Actualizar datos");
		ButtonActualizacion.setBounds(232, 184, 192, 23);
		contentPane.add(ButtonActualizacion);
		
		textPane = new JTextPane();
		textPane.setBounds(159, 14, 265, 159);
		contentPane.add(textPane);
	}
}
