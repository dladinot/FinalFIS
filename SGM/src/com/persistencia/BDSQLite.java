package com.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDSQLite extends BaseDatos{
	private Connection conexion;
	@Override
	public void conectar(String direccion) {
		String driver = "org.sqlite.JDBC";
        String connectString = "jdbc:sqlite:"+direccion;
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(connectString);
            System.out.println("Conectado exitosamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}

	@Override
	public Object consultar(String comandoSQL) {
		
		Object consulta = null;
	
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(comandoSQL);                
            while (rs.next()) {         
            consulta=rs.getString(1);
            }
			stmt.close();
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return consulta;
	}

	@Override
	public void guardar(String comandoSQL) {
		 try {
	         Statement stmt = conexion.createStatement();
	         stmt.executeUpdate (comandoSQL);   
	         stmt.close();
	         desconectar();
	        } catch (Exception e) {
	        	System.out.println(e.getMessage());
	        }
	}

	@Override
	public void desconectar() {
		try {
			conexion.close();
		} catch (SQLException e) {	
			System.out.println(e.getMessage());
		}
	}

}


