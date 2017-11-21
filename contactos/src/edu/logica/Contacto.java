package edu.logica;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import api.BaseDatos;
import edu.persistencia.ProxyBD;

public class Contacto {
	private String codigo;
	private String rol;
	private ArrayList<Usuario> administradores;
	private ArrayList<Usuario> docentes;
	private ArrayList<Usuario> monitores;
	
	public Contacto(String codigo) {
		this.codigo=codigo;
		cargarRolAutenticado();
		cargarContactos();
	}
	
	private void cargarRolAutenticado() {
		BaseDatos bd= new ProxyBD();
		bd.conectar("BD\\BDMonitorias.sqlite");
		rol= (String) bd.consultar("SELECT r.descripcion FROM Rol r, Usuario u WHERE r.idRol=u.Rol_idRol AND u.codigo="+codigo);
		bd.desconectar();
		
	}
	
	public void cargarContactos() {
		if(rol.equals("admin")) {
			cargarContactoAdmin();
			cargarContactoMonitores();
			cargarContactoDocentes();
		}
		else if(rol.equalsIgnoreCase("docente")) {
			cargarContactoAdmin();
			cargarContactoMonitores();
		}
		else if(rol.equalsIgnoreCase("estudiante")) {
			cargarContactoAdmin();
			cargarContactoDocentes();
		}
		
	}
	
	private void cargarContactoAdmin() {
		administradores =new ArrayList<Usuario>();
		ProxyBD bd= new ProxyBD();
		bd.conectar("BD\\BDMonitorias.sqlite");
		try {
			
			Statement stmt = bd.getAccesoBD().getConexion().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nombre, apellido, correo, telefono FROM Usuario WHERE Rol_IdRol='R01' and Codigo!="+codigo);                
            while (rs.next()) {   
            	Usuario userConsulta =new Usuario();
            	userConsulta.setNombre(rs.getString("nombre"));
            	userConsulta.setApellido(rs.getString("apellido"));
            	userConsulta.setCorreo(rs.getString("correo"));
            	userConsulta.setTelefono(rs.getString("telefono"));
            	administradores.add(userConsulta);
            }
			stmt.close();
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		bd.desconectar();

		}
	private void cargarContactoDocentes() {
		docentes =new ArrayList<Usuario>();
		ProxyBD bd= new ProxyBD();
		bd.conectar("BD\\BDMonitorias.sqlite");
		try {
			
			Statement stmt = bd.getAccesoBD().getConexion().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nombre, apellido, correo, telefono FROM Usuario WHERE Rol_IdRol='R03' and Codigo!="+codigo);                
            while (rs.next()) {   
            	Usuario userConsulta =new Usuario();
            	userConsulta.setNombre(rs.getString("nombre"));
            	userConsulta.setApellido(rs.getString("apellido"));
            	userConsulta.setCorreo(rs.getString("correo"));
            	userConsulta.setTelefono(rs.getString("telefono"));
            	docentes.add(userConsulta);
            }
			stmt.close();
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		bd.desconectar();
		
		}
	
	private void cargarContactoMonitores() {
		monitores =new ArrayList<Usuario>();
		ProxyBD bd= new ProxyBD();
		bd.conectar("BD\\BDMonitorias.sqlite");
		try {
			
			Statement stmt = bd.getAccesoBD().getConexion().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nombre, apellido, correo, telefono FROM Usuario WHERE Rol_IdRol='R02' and Codigo!="+codigo);                
            while (rs.next()) {   
            	Usuario userConsulta =new Usuario();
            	userConsulta.setNombre(rs.getString("nombre"));
            	userConsulta.setApellido(rs.getString("apellido"));
            	userConsulta.setCorreo(rs.getString("correo"));
            	userConsulta.setTelefono(rs.getString("telefono"));
            	monitores.add(userConsulta);
            }
			stmt.close();
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		bd.desconectar();
		
		}

	
	public String getRol() {
		return rol;
	}

	public ArrayList<Usuario> getAdministradores() {
		return administradores;
	}

	public ArrayList<Usuario> getDocentes() {
		return docentes;
	}

	public ArrayList<Usuario> getMonitores() {
		return monitores;
	}
	
	


}
