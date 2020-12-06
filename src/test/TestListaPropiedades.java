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
import principal.ListaPropiedades;

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
public class TestListaPropiedades {

    private ListaPropiedades listaPropiedades;

    @Before
    public void paraEjecutarAntes() throws Exception {
    	
    }
    
  @Test
    public void agregarElemento() throws FileNotFoundException, IOException {
        Properties libroDePrueba = new Properties();
        libroDePrueba.setProperty("ruta", "test_archivo/0002");
        libroDePrueba.setProperty("id", "0002");
        libroDePrueba.setProperty("autor", "Damian");
        libroDePrueba.setProperty("titulo", "Prueba2");
        libroDePrueba.setProperty("fechaPublicacion", "hoy");
        
        ListaPropiedades listaPropiedades = new ListaPropiedades();
        listaPropiedades.agregarElemento(libroDePrueba);
        
        libroDePrueba.load(new FileReader("test_archivo/0002"));
        String resultado = libroDePrueba.getProperty("id");
        
        assertNotEquals("",resultado);
    }
      
    @Test
    public void obtenerElementos() throws FileNotFoundException, IOException {
        ListaPropiedades listaPropiedades = new ListaPropiedades();
        String[] listasPropiedades = listaPropiedades.obtenerElementos("test_archivo/");
        assertEquals("001",listasPropiedades[1]);
    }
    
    @Test
    public void eliminarElemento() throws FileNotFoundException, IOException {
    	Properties propiedades = new Properties();
    	ListaPropiedades listaPropiedades = new ListaPropiedades();
        propiedades.setProperty("ruta", "test_archivo/0003");
    	listaPropiedades.borrarElemento(propiedades);
        propiedades.load(new FileReader("test_archivo/0003"));
        assertEquals("0002",propiedades);
    }
    
    //@Test
    public void escribirLeerRutaDeLista() {
        String ruta = "archivo/lista"; 
    	listaPropiedades.establecerRuta(ruta);
    	assertEquals(ruta,listaPropiedades.obtnerRuta());
    }
    
    //@Test
    public void escribirArchivoDePropiedades() {
    	String propiedadRecuperada = "";
    	Properties archivoPropiedades = new Properties();
    	
    	archivoPropiedades.setProperty("id", "001");
    	archivoPropiedades.setProperty("autor", "Damian");
    	archivoPropiedades.setProperty("titulo", "Prueba1");
    	archivoPropiedades.setProperty("fechaPublicacion", "hoy");
    	
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
    
    //@Test
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
    
    //@Test
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