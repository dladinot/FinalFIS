package edu.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import api.IMonitoria;

public class GuiClasificados extends JFrame implements IMonitoria{

	private JPanel contentPane;
	private String codigo;

	@Override
	public void administrarMonitoria(String codigo) {
		this.codigo=codigo;
		setTitle("Clasificados");
		setBounds(100, 100, 559, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClasificados = new JLabel("Clasificados");
		lblClasificados.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblClasificados.setBounds(221, 23, 131, 21);
		contentPane.add(lblClasificados);
		
		JButton btnConsultarClasificados = new JButton("Consultar Clasificados");
		btnConsultarClasificados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Redirigiendo a consultas de clasificados....");	
			}
		});
		btnConsultarClasificados.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConsultarClasificados.setBounds(175, 113, 203, 23);
		contentPane.add(btnConsultarClasificados);
		
		JButton btnVisualizarClasificados = new JButton("Visualizar Clasificados");
		btnVisualizarClasificados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Redirigiendo a publicaciones de clasificados....");	

			}
		});
		btnVisualizarClasificados.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVisualizarClasificados.setBounds(175, 200, 203, 23);
		contentPane.add(btnVisualizarClasificados);
		
		this.setVisible(true);
	}
	
	
	

	
}