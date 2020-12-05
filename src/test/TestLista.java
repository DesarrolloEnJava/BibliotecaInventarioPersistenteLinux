package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import principal.Lista;

/**
 * Una clase de tests con junit 5 El metodo que queramos que se ejecute antes
 * de hacer el test, debemos anotarlo con @Before. El que queramos que se
 * ejecute despues de los test debemos anotarlo con @After. Los metodos de test
 * con @Test. Para poder usar los metodos assert, debemos hacer un
 * 
 * import static org.junit.Assert.*;
 * 
 * @author Chuidiang
 */
public class TestLista {

    private Lista lista;

    @Before
    public void paraEjecutarAntes() throws Exception {
    	lista = new Lista("archivo/Lista");
    }
      
    @Test
    public void leerContenidoDeLaLista() {
        String resultado = lista.obtenerContenido();
        assertNotEquals("",resultado);
    	//assertEquals("Test incrementa", 2.0, suma.incrementa(1.0), 1e-6);
    }
    
    @Test
    public void escribirLeerRutaDeLista() {
        String ruta = "archivo/lista"; 
    	lista.establecerRuta(ruta);
    	assertEquals(ruta,lista.obtnerRuta());
    }
    
    @Test
    public void escribirArchivoDePropiedades() {
    	String propiedadRecuperada = "";
    	Properties archivoPropiedades = new Properties();
    	
    	archivoPropiedades.setProperty("Autor", "Damian");
    	try {
			FileWriter escritor = new FileWriter("test_archivo/propiedades");
			archivoPropiedades.store(escritor, "primera prueba");
			escritor.close();
			archivoPropiedades.load(new FileReader("test_archivo/propiedades"));
			Enumeration<Object> propiedades = archivoPropiedades.keys();
			while (propiedades.hasMoreElements()) {
				Object key = propiedades.nextElement();
				propiedadRecuperada = (String)key + "=" +archivoPropiedades.getProperty((String) key);
			}
			}catch(IOException e) {
			System.out.println("El archivo no se encuentra");
			e.printStackTrace();
		}
    	assertEquals(propiedadRecuperada,"Autor=Damian");
    }
    
    @Test
    public void agregarLineaArchivoDePropiedades() {
    	String propiedadRecuperada = "";
    	Properties archivoPropiedades = new Properties();
    	
    	archivoPropiedades.setProperty("Autor", "Damian");
    	try {
			FileWriter escritor = new FileWriter("test_archivo/propiedades");
			archivoPropiedades.store(escritor, "primera prueba");
			escritor.close();
			archivoPropiedades.load(new FileReader("test_archivo/propiedades"));
			Enumeration<Object> propiedades = archivoPropiedades.keys();
			while (propiedades.hasMoreElements()) {
				Object key = propiedades.nextElement();
				propiedadRecuperada = (String)key + "=" +archivoPropiedades.getProperty((String) key);
			}
			}catch(IOException e) {
			System.out.println("El archivo no se encuentra");
			e.printStackTrace();
		}
    	assertEquals(propiedadRecuperada,"Autor=Damian");
    }
    
    @Test
    public void obtenerListaDeArchivosEnLaCarpeta() throws IOException {
    	boolean esundirectorio = false;
    	try {
    		File carpeta = new File("test_archivo");
    		String[] listaDeArchivos = carpeta.list();
    		if(carpeta.isDirectory()) {
    			esundirectorio = true;
    			for (String archivo : listaDeArchivos) {
    				System.out.println(archivo);
				}
    					
    		}
    		}catch(NullPointerException e) {
    		
    	}
    	assertEquals(esundirectorio,true);
    }

    @After
    public void paraEjecutarDespues() throws Exception {
    	// Fin de test. Aqui liberar recursos o borrar rastros del test
    }

}