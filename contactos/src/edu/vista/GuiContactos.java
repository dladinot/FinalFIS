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
import edu.logica.Contacto;

public class GuiContactos extends JFrame implements IMonitoria{
	private JPanel contentPane;
	private String codigo;
	private Contacto objContacto;
	private String rol;
	@Override
	public void administrarMonitoria(String codigo) {
		this.codigo=codigo;
		objContacto=new Contacto(codigo);
		rol=objContacto.getRol();
		
		
		setTitle("Contactos");
		setBounds(100, 100, 581, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		if(rol.equals("admin")) {
			GuiContactosAdmin ventana=new GuiContactosAdmin(codigo,objContacto);
			ventana.setVisible(true);
			dispose();
		}
		else if(rol.equals("docente")) {
			GuiContactosDocente ventana=new GuiContactosDocente(codigo,objContacto);
			ventana.setVisible(true);
			dispose();
		}
		else if(rol.equals("estudiante")) {
			GuiContactosMonitor ventana=new GuiContactosMonitor(codigo,objContacto);
			ventana.setVisible(true);
			dispose();
		}
		
		
	}	
	

}
