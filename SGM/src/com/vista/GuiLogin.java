package com.vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.logica.Autenticacion;

import api.IMonitoria;

public class GuiLogin extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	public void ventana() {
		

		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		ImageIcon icono = new ImageIcon("img\\logoSGM.png");
		JLabel banner = new JLabel("");
		banner.setIcon(icono);
		banner.setFont(new Font("Tahoma", Font.BOLD, 17));
		banner.setBounds(69, 25, 437, 86);
		contentPane.add(banner);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Autenticacion token=new Autenticacion();
				if(token.iniciarSesion(textField.getText(), passwordField.getText())) {
					new GuiFachada().ventana();
					dispose();
				}

			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIngresar.setBounds(209, 205, 203, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(114, 125, 73, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setBounds(114, 150, 73, 14);
		contentPane.add(lblContrasena);
		
		textField = new JTextField();
		textField.setBounds(197, 122, 212, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(197, 149, 212, 20);
		contentPane.add(passwordField);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Aplicar look and feel sistema operativo nativo
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
					// sentencia que permite adaptar el programa a los visuales
					// de la plataforma nativa en la que se ejecute el programa
				} catch (UnsupportedLookAndFeelException e) {
					
				} catch (ClassNotFoundException e) {
					
				} catch (InstantiationException e) {
					
				} catch (IllegalAccessException e) {
					
				}
			
				new GuiLogin().ventana();
				
				
			}
		});
		
	
	}
	


}
