package edu.logica;

import api.BaseDatos;
import edu.persistencia.*;


public class Perfil {
	
	private String nombre;
	private String apellido;
	private String codigo;
	private String cedula;
	private String correo;
	private String telefono;
	private String rol;
	
	public Perfil(String codigo) {
		
		this.codigo=codigo;
		cargarInformacionPerfil();
	}

	public void cargarInformacionPerfil() {
		BaseDatos bd= new ProxyBD();
		bd.conectar("BD\\BDMonitorias.sqlite");
		nombre= (String) bd.consultar("SELECT nombre FROM Usuario WHERE codigo="+codigo);
		apellido= (String) bd.consultar("SELECT apellido FROM Usuario WHERE codigo="+codigo);
		cedula= (String) bd.consultar("SELECT cedula FROM Usuario WHERE codigo="+codigo);
		correo= (String) bd.consultar("SELECT correo FROM Usuario WHERE codigo="+codigo);
		telefono= (String) bd.consultar("SELECT telefono FROM Usuario WHERE codigo="+codigo);
		rol= (String) bd.consultar("SELECT r.descripcion FROM Rol r, Usuario u WHERE r.idRol=u.Rol_idRol AND u.codigo="+codigo);
		bd.desconectar();
	}
	
	public void cambiarContrasena(String nuevaContrasena) {
		BaseDatos bd= new ProxyBD();
		bd.conectar("BD\\BDMonitorias.sqlite");
		bd.guardar("update Usuario set contrasena="+nuevaContrasena+" where codigo="+codigo);
		bd.desconectar();
	}
	
	public void actualizarPerfil(String nombre,String apellido, String cedula, String correo, String telefono) {
		BaseDatos bd= new ProxyBD();
		bd.conectar("BD\\BDMonitorias.sqlite");
		bd.guardar("update Usuario set nombre='"+nombre+"', apellido='"+apellido+"', cedula='"+cedula+"', correo='"+correo+"', telefono='"+telefono+"' where codigo="+codigo);
	}
	
	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getRol() {
		return rol;
	}


}
