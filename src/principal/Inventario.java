package principal;

public class Inventario extends Lista {
		
	public Inventario(String ruta) {
		super.establecerRuta(ruta);
	}
	public void registrarLibro(String libroNuevo){
		super.agregarElemento(libroNuevo);
	}
	public void eliminarLibro(){
		
	}
	public String obtenerInventario(){
		return super.obtenerContenido();
	}
}
