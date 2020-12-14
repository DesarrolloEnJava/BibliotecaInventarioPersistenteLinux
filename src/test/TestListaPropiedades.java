package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Enumeration;
import java.util.Properties;

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

	@Before
	public void paraEjecutarAntes() throws Exception {

	}

	@Test
	public void agregarElemento() throws FileNotFoundException, IOException {
		Properties fichaDePrueba = new Properties();
		fichaDePrueba.setProperty("ruta", "test_archivo/0002");
		fichaDePrueba.setProperty("id", "0002");
		fichaDePrueba.setProperty("autor", "Damian");
		fichaDePrueba.setProperty("titulo", "Prueba2");
		fichaDePrueba.setProperty("fechaPublicacion", "hoy");

		ListaPropiedades listaPropiedades = new ListaPropiedades();
		listaPropiedades.agregarElemento(fichaDePrueba);

		fichaDePrueba.load(new FileReader("test_archivo/0002"));
		String resultado = fichaDePrueba.getProperty("id");

		assertNotEquals("",resultado);
	}

	@Test(expected=FileNotFoundException.class)
	public void eliminarElemento() throws FileNotFoundException, IOException {
		Properties fichaDePrueba = new Properties();
		ListaPropiedades listaPropiedades = new ListaPropiedades();
		String ruta = "test_archivo/0003";
		fichaDePrueba.setProperty("ruta", ruta);
		listaPropiedades.agregarElemento(fichaDePrueba);
		listaPropiedades.borrarElemento(fichaDePrueba);
		fichaDePrueba.load(new FileReader(ruta));
	}

	@Test
	public void obtenerElemento() {
		Properties fichaDePrueba = new Properties();
		fichaDePrueba.setProperty("ruta", "test_archivo/0100");
		fichaDePrueba.setProperty("id", "0100");
		fichaDePrueba.setProperty("autor", "Damian");
		fichaDePrueba.setProperty("titulo", "Prueba100");
		fichaDePrueba.setProperty("fechaPublicacion", "hoy");

		ListaPropiedades listaPropiedades = new ListaPropiedades();
		listaPropiedades.agregarElemento(fichaDePrueba);

		Properties fichaRecuperada = listaPropiedades.obtenerElemento("test_archivo/0100");
		String idRecuperado = fichaRecuperada.getProperty("id");

		assertEquals("0100",idRecuperado);
	}

	@Test
	public void obtenerListaDeElementos() {
		ListaPropiedades listaPropiedades = new ListaPropiedades();
		String ruta = "test_archivo/";
		String[] fichas = listaPropiedades.obtenerListaDeElementos(ruta);
		if(!fichas[0].equals("No existe la carpeta") && !fichas[0].equals("La ruta no apunta a una carpeta")) {
			for (String ficha : fichas) {
				Properties fichaRecuperada = listaPropiedades.obtenerElemento(ruta+ficha);
				Enumeration<Object> propiedades = fichaRecuperada.keys();

				while (propiedades.hasMoreElements()) {
					Object propiedad = propiedades.nextElement();
					System.out.println(propiedad + " = " + fichaRecuperada.get(propiedad));
				}	
			}
		}else if(fichas[0].equals("No existe la carpeta")) {
			fail("No existe la carpeta");
		}else {
			fail("La ruta no apunta a una carpeta");
		}
	}

	@After
	public void paraEjecutarDespues() throws Exception {

	}

}