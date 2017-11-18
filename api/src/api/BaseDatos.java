package api;

public interface BaseDatos {
	void conectar();
	void guardar(Object obj);
	Object consultar();
	void desconectar();
   
}
