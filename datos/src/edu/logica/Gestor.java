package edu.logica;

import javax.swing.JOptionPane;

import api.CRUD;

public class Gestor implements CRUD{

	@Override
	public void actualizar() {
		JOptionPane.showMessageDialog(null,"Actualizando informacion en la BD....");	
		
	}

	@Override
	public void crear() {
		JOptionPane.showMessageDialog(null,"Creando informacion en la BD...");	
		
	}

	@Override
	public void eliminar() {
		JOptionPane.showMessageDialog(null,"Eliminando informacion en la BD...");	
		
	}

	@Override
	public void renombrar() {
		JOptionPane.showMessageDialog(null,"Renombrando informacion en la BD...");	
		
	}

	

}
