package principal;

import java.util.Properties;

public class Inventario extends Lista {
		
	public Inventario( ) {
		
	}
	public void registrarLibro(Properties libroNuevo){
		super.agregarElemento(libroNuevo);
	}
	public void eliminarLibro(){
		
	}
	public String obtenerInventario(){
		return super.obtenerContenido();
	}
}
