package edu.vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import api.IMonitoria;
import edu.logica.Perfil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class GuiEditarPerfil extends JFrame implements IMonitoria{
	private String codigo;
	private Perfil perfil;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCodigo;
	private JTextField txtCedula;
	private JTextField txtCorreo;
	private JTextField txtTel;
	private JTextField txtRol;
	
	public GuiEditarPerfil() {
		
	}
	
	public void administrarMonitoria(String codigo) {
		this.codigo=codigo;
		perfil=new Perfil(this.codigo);
		
		setTitle("Editar Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon icono = new ImageIcon("img\\perfil.png");
		JLabel fotoPerfil = new JLabel("");
		fotoPerfil.setBounds(43, 44, 121, 121);
		fotoPerfil.setIcon(icono);
		contentPane.add(fotoPerfil);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(193, 44, 66, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(193, 68, 66, 14);
		contentPane.add(lblApellido);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigo.setBounds(193, 93, 46, 14);
		contentPane.add(lblCdigo);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdula.setBounds(193, 118, 66, 14);
		contentPane.add(lblCdula);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorreo.setBounds(193, 143, 66, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelfono.setBounds(193, 168, 66, 14);
		contentPane.add(lblTelfono);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRol.setBounds(193, 193, 46, 14);
		contentPane.add(lblRol);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(true);
		txtNombre.setBounds(254, 41, 249, 20);
		txtNombre.setText(perfil.getNombre());
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(true);
		txtApellido.setColumns(10);
		txtApellido.setBounds(254, 65, 249, 20);
		txtApellido.setText(perfil.getApellido());
		contentPane.add(txtApellido);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(254, 90, 249, 20);
		txtCodigo.setText(this.codigo);
		contentPane.add(txtCodigo);
		
		txtCedula = new JTextField();
		txtCedula.setEditable(true);
		txtCedula.setColumns(10);
		txtCedula.setBounds(254, 115, 249, 20);
		txtCedula.setText(perfil.getCedula());
		contentPane.add(txtCedula);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(true);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(254, 140, 249, 20);
		txtCorreo.setText(perfil.getCorreo());
		contentPane.add(txtCorreo);
		
		txtTel = new JTextField();
		txtTel.setEditable(true);
		txtTel.setColumns(10);
		txtTel.setBounds(254, 165, 249, 20);
		txtTel.setText(perfil.getTelefono());
		contentPane.add(txtTel);
		
		txtRol = new JTextField();
		txtRol.setEditable(false);
		txtRol.setColumns(10);
		txtRol.setBounds(254, 190, 249, 20);
		txtRol.setText(perfil.getRol());
		contentPane.add(txtRol);
		
		JButton btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfil.actualizarPerfil(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtCorreo.getText(), txtTel.getText());
				JOptionPane.showMessageDialog(null, "Cambios realizados correctamente");
				new GuiPerfil().administrarMonitoria(codigo);
				dispose();
			}
		});
		btnGuardarCambios.setBounds(310, 231, 115, 23);
		contentPane.add(btnGuardarCambios);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GuiPerfil().administrarMonitoria(codigo);
				dispose();
			}
		});
		btnVolver.setIcon(null);
		btnVolver.setBounds(414, 7, 89, 23);
		contentPane.add(btnVolver);
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
