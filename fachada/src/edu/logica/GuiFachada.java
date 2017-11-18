/**
 * 
 */
package edu.logica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import api.IMonitoria;
import utilitarios.Cargador;

/**
 * @author usuario
 *
 */
public class GuiFachada extends JFrame{
	private JPanel contentPane;
	private IMonitoria clasificado;
	private IMonitoria contactos;
	private IMonitoria perfil;
	
	public GuiFachada() {
		Cargador c = new Cargador("Componentes", ClassLoader.getSystemClassLoader());
		try {
			Class<?> cl = c.cargarComponente(IMonitoria.class.getName());
			if (cl != null) {
				//IMonitoria frame = (IMonitoria) c.cargarComponente(IMonitoria.class.getName()).newInstance();
				clasificado = (IMonitoria) c.cargarClase("edu.logica.GuiClasificados").newInstance();
				//contactos = (IMonitoria) c.cargarClase("edu.logica.GuiContactos").newInstance();
				//perfil = (IMonitoria) c.cargarClase("edu.logica.GuiPerfil").newInstance();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ventana() {
		
		setTitle("Fachada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al Sistema de Gestion de Monitorias");
		lblBienvenidoAlSistema.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBienvenidoAlSistema.setBounds(63, 37, 459, 21);
		contentPane.add(lblBienvenidoAlSistema);
		
		JButton btnMonitoria = new JButton("Monitoria");
		btnMonitoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Redirigiendo a modulo gestion de monitoria...");	
			}
		});
		btnMonitoria.setBounds(239, 93, 89, 23);
		contentPane.add(btnMonitoria);
		
		JButton btnIrAClasificados = new JButton("Clasificados");
		btnIrAClasificados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clasificado.administrarMonitoria();
			}
		});
		btnIrAClasificados.setBounds(239, 161, 89, 23);
		contentPane.add(btnIrAClasificados);
		
		JButton btnVerPerfil = new JButton("Ver perfil");
		btnVerPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				perfil.administrarMonitoria();
			}
		});
		btnVerPerfil.setBounds(239, 127, 89, 23);
		contentPane.add(btnVerPerfil);
		
		JButton btnContactarUsuario = new JButton("Contactar usuario");
		btnContactarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contactos.administrarMonitoria();
			}
		});
		btnContactarUsuario.setBounds(213, 195, 139, 23);
		contentPane.add(btnContactarUsuario);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Saliendo...");	
				dispose();
			}
		});
		btnSalir.setBounds(239, 229, 89, 23);
		contentPane.add(btnSalir);
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new GuiFachada().ventana();
	
	}
	


}
