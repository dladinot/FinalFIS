package edu.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.logica.Contacto;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class GuiInfoContacto extends JFrame {

	private JPanel contentPane;
	private String codigo;
	private Contacto objContacto;
	private String rol;
	private String destinoContacto;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtTel;

	public GuiInfoContacto(String codigo,String destinoContacto, Contacto objContacto) {
		this.destinoContacto=destinoContacto;
		this.codigo=codigo;
		this.objContacto=objContacto;
		rol=objContacto.getRol();
		
		setTitle("Contactos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiContactos ventana =new GuiContactos();
				ventana.administrarMonitoria(codigo);
				dispose();
			}
		});
		btnVolver.setIcon(null);
		btnVolver.setBounds(414, 7, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblSeleccioneLaPersona = new JLabel("Seleccione la persona a la cual desea obtener la informaci\u00F3n de contacto");
		lblSeleccioneLaPersona.setBounds(20, 35, 364, 14);
		contentPane.add(lblSeleccioneLaPersona);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 56, 345, 20);
		contentPane.add(comboBox);
		comboBox.addItem("...");
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(32, 100, 61, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(32, 125, 61, 14);
		contentPane.add(lblApellido);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(32, 150, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(32, 175, 52, 14);
		contentPane.add(lblTelefono);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(83, 97, 282, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(83, 122, 282, 20);
		contentPane.add(txtApellido);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(83, 147, 282, 20);
		contentPane.add(txtCorreo);
		
		txtTel = new JTextField();
		txtTel.setEditable(false);
		txtTel.setColumns(10);
		txtTel.setBounds(83, 172, 282, 20);
		contentPane.add(txtTel);
		
		ImageIcon icono = new ImageIcon("img\\correo.png");
		JLabel lblImgcorreo = new JLabel("");
		lblImgcorreo.setIcon(icono);
		lblImgcorreo.setBounds(400, 77, 140, 138);
		contentPane.add(lblImgcorreo);
		
		if(destinoContacto.equals("docente")) {
			for(int i=0;i<objContacto.getDocentes().size();i++) {
				comboBox.addItem(objContacto.getDocentes().get(i).getNombre()+" "+objContacto.getDocentes().get(i).getApellido());
			}
			comboBox.addActionListener (new ActionListener () {
				
			    public void actionPerformed(ActionEvent e) {
			    	   txtNombre.setText(objContacto.getDocentes().get(comboBox.getSelectedIndex()-1).getNombre());
				       txtApellido.setText(objContacto.getDocentes().get(comboBox.getSelectedIndex()-1).getApellido());
				       txtCorreo.setText(objContacto.getDocentes().get(comboBox.getSelectedIndex()-1).getCorreo());
				       txtTel.setText(objContacto.getDocentes().get(comboBox.getSelectedIndex()-1).getTelefono());
			    }
			});
		}
		else if(destinoContacto.equals("admin")) {
			for(int i=0;i<objContacto.getAdministradores().size();i++) {
				comboBox.addItem(objContacto.getAdministradores().get(i).getNombre()+" "+objContacto.getAdministradores().get(i).getApellido());
			}
			comboBox.addActionListener (new ActionListener () {
				
			    public void actionPerformed(ActionEvent e) {
			    	   txtNombre.setText(objContacto.getAdministradores().get(comboBox.getSelectedIndex()-1).getNombre());
				       txtApellido.setText(objContacto.getAdministradores().get(comboBox.getSelectedIndex()-1).getApellido());
				       txtCorreo.setText(objContacto.getAdministradores().get(comboBox.getSelectedIndex()-1).getCorreo());
				       txtTel.setText(objContacto.getAdministradores().get(comboBox.getSelectedIndex()-1).getTelefono());
			    }
			});
		}
		else if(destinoContacto.equals("monitor")) {
			for(int i=0;i<objContacto.getMonitores().size();i++) {
				comboBox.addItem(objContacto.getMonitores().get(i).getNombre()+" "+objContacto.getMonitores().get(i).getApellido());
			}
			comboBox.addActionListener (new ActionListener () {
				
			    public void actionPerformed(ActionEvent e) {
			    	   txtNombre.setText(objContacto.getMonitores().get(comboBox.getSelectedIndex()-1).getNombre());
				       txtApellido.setText(objContacto.getMonitores().get(comboBox.getSelectedIndex()-1).getApellido());
				       txtCorreo.setText(objContacto.getMonitores().get(comboBox.getSelectedIndex()-1).getCorreo());
				       txtTel.setText(objContacto.getMonitores().get(comboBox.getSelectedIndex()-1).getTelefono());
			    }
			});
		}
		
	
		
	}
}
