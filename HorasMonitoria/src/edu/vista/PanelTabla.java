package edu.vista;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class PanelTabla extends JPanel{

	private DefaultTableModel dtm;
	private JTable tablaMonitor;
	private String columna [] = {"ID","NOMBRE","APELLIDO","HORAS"}; 
	
	public PanelTabla() {
		
		dtm = new DefaultTableModel(buscarMonitor(),columna);
		tablaMonitor = new JTable();
		tablaMonitor.setModel(dtm);
		add(tablaMonitor);
		setVisible(true);
	}
	
	/**
	 * Por parametros deberia recibir el id del panel busqueda
	 */
	public Object[][] buscarMonitor(){
		//Aqui va la busqueda en la BD
		Object datos [][] = {{"2014","Cristian","Cuervo","100"}
		,{"2016","Juan","Perez","200"}
		,{"2014","Daniel","Ladino","300"}
		,{"2014","Neider","Fajardo","250"}};
		return datos;
	}

}
