package principal;

import java.io.File;
import java.io.IOException;

public class Carpeta {
	private File carpetaRaiz = new File("archivo");
	private File archivo;
	private String[] listas;
	private String rutaListaSeleccionada;

	public Carpeta() {
		this.rutaListaSeleccionada=null;
		actualizarListas();
	}

	public void obtenerListas(){
		if (this.listas == null || this.listas.length == 0) {
			System.out.println("No hay elementos dentro de la carpeta actual");
			return;
		}
		else {
			for (int i=0; i< this.listas.length; i++) {
				System.out.println(this.listas[i]);
			}
		}
	}	
	public void actualizarListas(){
		this.listas = this.carpetaRaiz.list();
	}
	public boolean encontrarLista(String nombreLista) {
		archivo = new File(carpetaRaiz,nombreLista);
		if(!archivo.exists()) {
			System.out.println("La lista ingresada no existe");
		}
		return archivo.exists();
	}
	public void seleccionarLista(String nombreLista) {
		archivo = new File(carpetaRaiz,nombreLista);
		this.rutaListaSeleccionada = archivo.getPath();
		System.out.println("Se selecciono la lista: "+archivo.getName());
	}
	public void crearLista(String nombreListaNueva) {
		try {
			archivo = new File(carpetaRaiz,nombreListaNueva);
			if(archivo.createNewFile()) {
				System.out.println("Se creo la lista: "+archivo.getName());
			}else {
				System.out.println("El archivo ya existe");
			}
		}catch(IOException e) {
			System.out.println("Error al crear el archivo");
			e.printStackTrace();
		}
	}
	public void eliminarLista(String nombreListaEliminar) { 
		archivo = new File(carpetaRaiz,nombreListaEliminar);
		if (archivo.delete()) { 
			System.out.println("Se borro el archivo: " + archivo.getName());
		} else {
			System.out.println("Error al eliminar el archivo");
		} 
	}
	public String obtenerRutaListaSeleccionada() {
		return rutaListaSeleccionada;
	}

}
