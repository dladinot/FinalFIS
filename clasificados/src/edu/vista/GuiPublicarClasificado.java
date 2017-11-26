package edu.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.logica.Clasificado;

public class GuiPublicarClasificado extends JFrame{
	
	private Clasificado clasificado;
	private JButton btnPublicar,btnCancelar;
	private JPanel contentPane;
	private JLabel lblFecha, lblAutor, lblAsunto;
	private JTextField txtAsunto;
	private JTextArea txtContenido;
	
	public GuiPublicarClasificado(Clasificado c) {
		this.clasificado = c;
		
		setTitle("Publicar");
		setBounds(150, 150, 559, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAutor = new JLabel();
		lblAutor.setBounds(10,20,200,20);
		lblAutor.setText("Autor: "+clasificado.getNombre()+" "+clasificado.getApellido());
		contentPane.add(lblAutor);
		
		lblFecha = new JLabel();
		lblFecha.setBounds(10,50,200,20);
		lblFecha.setText("Fecha: "+clasificado.fecha());
		contentPane.add(lblFecha);
		
		lblAsunto = new JLabel();
		lblAsunto.setBounds(10,80,60,20);
		lblAsunto.setText("Asunto: ");
		contentPane.add(lblAsunto);
		
		txtAsunto = new JTextField();
		txtAsunto.setBounds(70, 80, 500, 20);
		contentPane.add(txtAsunto);
		
		txtContenido = new JTextArea();
		txtContenido.setBounds(10, 110, 530, 100);
		txtContenido.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtContenido.setBackground(Color.white);
		contentPane.add(txtContenido);
		
		btnPublicar = new JButton("Publicar");
		btnPublicar.setBounds(280,280,150,20);
		contentPane.add(btnPublicar);
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clasificado.publicarClasificado(txtAsunto.getText(),txtContenido.getText());
				getVentana().dispose();
			}
		});
		
		btnCancelar= new JButton("Cancelar");
		btnCancelar.setBounds(120,280,150,20);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg00) {
				getVentana().dispose();
			}
		});
		
	}
	public JFrame getVentana() {
		return this;
	}
}
