package edu.vista;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import api.IMonitoria;

public class GuiGestionHoras extends JFrame implements IMonitoria{

	private JPanel panelBusqueda;
	private JPanel panelTabla;
	private String codigo;

	@Override
	public void administrarMonitoria(String codigo) {
		this.codigo=codigo;
		setLayout(new GridLayout());
		
		panelBusqueda = new PanelBusqueda();
		panelTabla = new PanelTabla();
		
		add(panelBusqueda);
		add(panelTabla);
		
		setSize(640, 200);
		setVisible(true);
		
	}

}
