package edu.persistencia;

import api.BaseDatos;

public class ProxyBD implements BaseDatos{
	
	private BDSQLite accesoBD =null;
	
	@Override
	public void conectar(String direccion) {
		if(accesoBD!=null){
			accesoBD.conectar(direccion);
		}
		else{
			accesoBD= new BDSQLite();
			accesoBD.conectar(direccion);
		}
	}
	@Override
	public Object consultar(String comandoSQL) {
		Object consulta = null;
		if(accesoBD!=null){
			consulta=accesoBD.consultar(comandoSQL);
		}
		else{
			accesoBD= new BDSQLite();
			consulta=accesoBD.consultar(comandoSQL);
		}
		return consulta;
	}
	@Override
	public void guardar(String comandoSQL) {
		if(accesoBD!=null){
			accesoBD.guardar(comandoSQL);
		}
		else{
			accesoBD= new BDSQLite();
			accesoBD.guardar(comandoSQL);
		}
	}
	@Override
	public void desconectar() {
		if(accesoBD!=null){
			accesoBD.desconectar();
		}
		else{
			accesoBD= new BDSQLite();
			accesoBD.desconectar();
		}
	}
	public BDSQLite getAccesoBD() {
		return accesoBD;
	}
	
	

}


