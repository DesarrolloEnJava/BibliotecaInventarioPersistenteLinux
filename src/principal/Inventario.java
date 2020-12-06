package principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Inventario extends ListaPropiedades {
		
	public Inventario( ) {
		
	}
	public void registrarLibro(Properties libroNuevo){
		super.agregarElemento(libroNuevo);
	}
	public void eliminarLibro(){
		
	}
	public String[] obtenerInventario(String ruta) throws FileNotFoundException, IOException{
		return super.obtenerElementos(ruta);
	}
}
