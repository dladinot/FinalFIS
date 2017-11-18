package com.persistencia;

public abstract class BaseDatos {
	public abstract void conectar(String direccion);
	public abstract Object consultar(String comandoSQL);
	public abstract void guardar(String comandoSQL);
	public abstract void desconectar();
}


