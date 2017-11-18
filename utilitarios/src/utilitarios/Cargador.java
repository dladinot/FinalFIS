package utilitarios;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import javax.swing.JOptionPane;

public class Cargador {
	static final String COMPONENTE = "COMPONENTE";
    URLClassLoader cargador;
    HashMap mapa=new HashMap<String,String>();
	public Cargador(String dir,ClassLoader cargador) {	

		File archivos[]=new File(dir).listFiles();
		URL urls[] = new URL[archivos.length];
		for(int i =0;i<archivos.length;i++) {
			try {
				urls[i]=archivos[i].toURI().toURL();
				////////////////////////////////////
				Manifest man = new JarFile(archivos[i]).getManifest();
				if(man!=null) {
					Attributes atrs=man.getAttributes(COMPONENTE);
					if(atrs!=null) {
						String nombre = atrs.getValue("nombre");
						String clase = atrs.getValue("clase");				
						mapa.put(nombre,clase);
					}
				}
				////////////////////////////////////
			} catch (Exception e) {			
				e.printStackTrace();
			}
		}
		this.cargador = new  URLClassLoader(urls);
	}
	public Class<?> cargarClase(String nombreDeClase) {
		try {
			return cargador.loadClass(nombreDeClase);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}   
	public Class<?> cargarComponente(String nombreDelComponente) {
		try {
			String componente=((String)mapa.get(nombreDelComponente)).trim();
			//JOptionPane.showMessageDialog(null,componente);
			return cargador.loadClass(componente);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}   
}
