package edu.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import api.IMonitoria;
import edu.logica.Clasificado;

public class GuiClasificados extends JFrame implements IMonitoria{

	private Clasificado clasificados;
	private JPanel contentPane;
	private String codigo;
	private JTextArea txtClasificados;
	private GuiPublicarClasificado publicarClasificado;

	@Override
	public void administrarMonitoria(String codigo) {
		this.codigo=codigo;
		clasificados = new Clasificado(codigo);
		setTitle("Clasificados");
		setBounds(100, 100, 559, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		JLabel lblClasificados = new JLabel("Clasificados");
		lblClasificados.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblClasificados.setBounds(221, 23, 131, 21);
		contentPane.add(lblClasificados);

		
		txtClasificados = new JTextArea();
		txtClasificados.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtClasificados.setBackground(Color.white);
		txtClasificados.setEditable(false);
		txtClasificados.setBounds(0,50, 559, 240);
		contentPane.add(txtClasificados);
		
		JButton btnPublicarClasificados = new JButton("Publicar Clasificados");
		btnPublicarClasificados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				publicarClasificado = new GuiPublicarClasificado(clasificados);	
				publicarClasificado.setVisible(true);	
			}
		});
		btnPublicarClasificados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPublicarClasificados.setBounds(175, 300, 203, 23);
		contentPane.add(btnPublicarClasificados);
		
		this.setVisible(true);
		cargarClasificados();
	}
	
	public void cargarClasificados() {
		clasificados.cargarClasificados();
	}
	
	

	
}