package com.vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JLabel banner = new JLabel("Sistema de Gestion de Monitorias");
		banner.setFont(new Font("Tahoma", Font.BOLD, 17));
		banner.setBounds(140, 41, 295, 21);
		contentPane.add(banner);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GuiFachada().ventana();
				dispose();

			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnIngresar.setBounds(197, 180, 203, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(140, 96, 73, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setBounds(140, 121, 73, 14);
		contentPane.add(lblContrasena);
		
		textField = new JTextField();
		textField.setBounds(223, 93, 212, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 121, 212, 20);
		contentPane.add(passwordField);
		
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
