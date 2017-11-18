package com.logica;

import javax.swing.JOptionPane;

import com.persistencia.*;

public class Autenticacion {

	public Autenticacion() {
		
	}
	
	public boolean iniciarSesion(String codigo, String contrasena) {
		boolean ingreso=false;
		String codigoBD,contrasenaBD;
		BaseDatos bd= new ProxyBD();
		bd.conectar("BD\\BDMonitorias.sqlite");
		codigoBD= (String) bd.consultar("SELECT codigo FROM Usuario WHERE codigo="+codigo);
		System.out.println(codigoBD);
		contrasenaBD= (String) bd.consultar("SELECT contrasena FROM Usuario WHERE codigo="+codigo+" and contrasena="+contrasena);
		System.out.println(contrasenaBD);
		bd.desconectar();
		if(codigoBD==null) {
			JOptionPane.showMessageDialog(null,
				    "Usuario no existe",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}
		
		else if(contrasenaBD==null) {
			JOptionPane.showMessageDialog(null,
				    "Contraseña incorrecta",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			ingreso=true;
		}
		
		return ingreso;
	}

}
