package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

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

    @After
    public void paraEjecutarDespues() throws Exception {
    	// Fin de test. Aqui liberar recursos o borrar rastros del test
    }

}