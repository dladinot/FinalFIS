package edu.logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import api.BaseDatos;
import edu.persistencia.ProxyBD;

public class Clasificado {

	private java.sql.Date fechaBD;
	Date fechaDate;
	private String codigo, nombre, apellido, cedula, correo, telefono, rol;
	private BaseDatos bd;
	
	public Clasificado(String codigo) {
		this.codigo = codigo;
		bd= new ProxyBD();
		bd.conectar("BD\\BDMonitorias.sqlite");
		nombre= (String) bd.consultar("SELECT nombre FROM Usuario WHERE codigo="+codigo);
		apellido= (String) bd.consultar("SELECT apellido FROM Usuario WHERE codigo="+codigo);
		cedula= (String) bd.consultar("SELECT cedula FROM Usuario WHERE codigo="+codigo);
		correo= (String) bd.consultar("SELECT correo FROM Usuario WHERE codigo="+codigo);
		telefono= (String) bd.consultar("SELECT telefono FROM Usuario WHERE codigo="+codigo);
		rol= (String) bd.consultar("SELECT r.descripcion FROM Rol r, Usuario u WHERE r.idRol=u.Rol_idRol AND u.codigo="+codigo);
		bd.desconectar();
	}

	public String fecha(){
		SimpleDateFormat formateador = new SimpleDateFormat(
		"dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
		fechaDate = new Date();
		String fecha = formateador.format(fechaDate);
		return(fecha);
	}
	public int toIntFecha() {
		SimpleDateFormat formato = new SimpleDateFormat(
		"HH:mm:ss");
		String[] datos = new String[3];
		Date fecha = new Date();
		String aux = formato.format(fecha);
		datos = (aux.split(":"));
		return Integer.parseInt(datos[0]+datos[1]+datos[2]);
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void publicarClasificado(String titulo, String descripcion) {
		
		bd.conectar("BD\\BDMonitorias.sqlite");
		bd.guardar("INSERT INTO Clasificados (idPost, titulo, descripcion, fecha, Usuario_codigo)"+
				"VALUES ("+toIntFecha()+", \""+titulo+"\", \""+descripcion+"\", datetime('now'), \""+codigo+"\")");
	}
	public void cargarClasificados() {
		
	}
	
}
