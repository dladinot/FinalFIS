package edu.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.logica.Contacto;

public class GuiContactosMonitor extends JFrame {

	private JPanel contentPane;
	private String codigo;
	private Contacto objContacto;

	public GuiContactosMonitor(String codigo,Contacto objContacto) {
		this.codigo=codigo;
		this.objContacto=objContacto;
		setTitle("Contactos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblaQuinDesea = new JLabel("\u00BFA qui\u00E9n desea contactar?");
		lblaQuinDesea.setBounds(33, 33, 198, 14);
		contentPane.add(lblaQuinDesea);
		
		JButton btnAdministradores = new JButton("Administradores");
		btnAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiInfoContacto ventana =new GuiInfoContacto(codigo, "admin", objContacto);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnAdministradores.setBounds(101, 197, 130, 23);
		contentPane.add(btnAdministradores);
		
		JButton btnDocentes = new JButton("Docentes");
		btnDocentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiInfoContacto ventana =new GuiInfoContacto(codigo, "docente", objContacto);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnDocentes.setBounds(299, 197, 130, 23);
		contentPane.add(btnDocentes);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setIcon(null);
		btnVolver.setBounds(414, 7, 89, 23);
		contentPane.add(btnVolver);
		
		ImageIcon icono = new ImageIcon("img\\admin.png");
		JLabel lblImgadmin = new JLabel("");
		lblImgadmin.setIcon(icono);
		lblImgadmin.setBounds(101, 58, 130, 128);
		contentPane.add(lblImgadmin);
		
		ImageIcon icono2 = new ImageIcon("img\\docente.png");
		JLabel lblimgDocente = new JLabel("");
		lblimgDocente.setIcon(icono2);
		lblimgDocente.setBounds(299, 58, 130, 128);
		contentPane.add(lblimgDocente);
		
		ImageIcon icono3 = new ImageIcon("img\\estudiante.png");
		this.setLocationRelativeTo(null);
	}
	public void setObjContacto(Contacto objContacto) {
		this.objContacto = objContacto;
	}
}
