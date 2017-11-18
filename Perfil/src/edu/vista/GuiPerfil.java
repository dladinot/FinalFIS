package edu.vista;

import java.awt.Color;
import java.nio.charset.MalformedInputException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import api.IMonitoria;

public class GuiPerfil extends JFrame implements IMonitoria{

	public JLabel lblNombre, lblCorreo, lblTelefono, lblHoras;
	public String nombre, correo, telefono;
	public JPanel panel;
	public JButton btnEditar;
	public JProgressBar numeroHoras;
	int ALTO,ANCHO, MAXIMOHORAS, horas;
	public GuiPerfil() {
	//-----------------------------
		nombre = "Neider Fajardo";
		correo="nafajardo01@gmail.com";
		telefono= "123465";
		horas = 60;
	//-----------------------------
		ALTO = 500;
		ANCHO = 321;
		MAXIMOHORAS = 200;
		
	}
	@Override
	public void administrarMonitoria() {
		
		lblNombre = new JLabel();
		lblCorreo = new JLabel();
		lblTelefono = new JLabel();
		lblHoras = new JLabel();
		btnEditar = new JButton();
		numeroHoras = new JProgressBar(0,MAXIMOHORAS);
		panel = new JPanel();
		
		

		this.setTitle("Perfil");
		this.setBounds(100, 100, ANCHO, ALTO);
		this.setResizable(false);
		this.setVisible(true);
		
		panel.setLayout(null);
		this.setContentPane(panel);
		panel.setBackground(Color.white);
		
		lblNombre.setText("Nombre: "+nombre);
		lblNombre.setBounds(10,200,200,20);
		panel.add(lblNombre);
		
		lblCorreo.setText("Correo: "+correo);
		lblCorreo.setBounds(10,230,200,20);
		panel.add(lblCorreo);
		
		lblTelefono.setText("Teléfono: "+telefono);
		lblTelefono.setBounds(10,260,200,20);
		panel.add(lblTelefono);
		
		lblHoras.setText("Horas realizadas: "+String.valueOf(horas));
		lblHoras.setBounds(10,290,200,20);
		panel.add(lblHoras);
		
		numeroHoras.setValue(horas);
		numeroHoras.setStringPainted(true);
		numeroHoras.setBounds(10,320,300,20);
		panel.add(numeroHoras);
		
		
		btnEditar.setText("Editar Perfil");
		btnEditar.setBounds(0,ALTO-50,ANCHO,25);
		btnEditar.setBackground(Color.white);
		panel.add(btnEditar);
	}
	
//	public static void main(String[] args) {
//		GuiPerfil perfil = new GuiPerfil();
//	}
}
