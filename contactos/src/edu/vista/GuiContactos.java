package edu.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import api.IMonitoria;

public class GuiContactos extends JFrame implements IMonitoria{
	private JPanel contentPane;

	@Override
	public void administrarMonitoria() {
		setTitle("Contactos");
		setBounds(100, 100, 454, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContactos = new JLabel("Contactos");
		lblContactos.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblContactos.setBounds(192, 22, 101, 26);
		contentPane.add(lblContactos);
		
		JLabel lblSeleccionarPersona = new JLabel("Seleccionar persona:");
		lblSeleccionarPersona.setBounds(10, 71, 135, 14);
		contentPane.add(lblSeleccionarPersona);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Juan Perez", "Luis Martinez", "Diego Torres", "Daniel Ladino"}));
		comboBox.setBounds(157, 68, 123, 20);
		contentPane.add(comboBox);
		
		JButton btnContactar = new JButton("Contactar");
		btnContactar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Contactando usuario....");	
			}
		});
		btnContactar.setBounds(184, 135, 109, 23);
		contentPane.add(btnContactar);
		this.setVisible(true);
	}	
	

}
