package edu.logica;

public class Usuario {
	private String codigo;
	private String rol;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
	
	public Usuario() {
		
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getRol() {
		return rol;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}
	
	
	
	
	

}
