package api;

public interface BaseDatos {
	void conectar(String direccion);
	void guardar(String comandoSQL);
	Object consultar(String comandoSQL);
	void desconectar();
   
}
