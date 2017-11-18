package edu.vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PanelBusqueda extends JPanel{
	
	private JLabel lblID , lblAgregarHora;
	private JTextField txtID , txtAgregarHora;
	private JButton btnAgregar;

	public PanelBusqueda() {
		setLayout(null);
		
		lblID = new JLabel("ID : ");
		lblID.setBounds(10, 14, 100, 14);
		lblAgregarHora = new JLabel("Cantidad de Horas");
		lblAgregarHora.setBounds(10, 52, 150, 14);
		
		txtID = new JTextField();
		txtID.setBounds(154, 11, 136, 20);
		
		txtAgregarHora = new JTextField();
		txtAgregarHora.setBounds(154, 49, 136, 20);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(90, 87, 120, 39);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Agregando las Hora");	
			}
		});
		
		add(lblID);
		add(txtID);
		add(lblAgregarHora);
		add(txtAgregarHora);
		add(btnAgregar);
	}

}
