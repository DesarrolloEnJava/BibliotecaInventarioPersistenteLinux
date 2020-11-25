package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lista {
	private String ruta=null;
	private String contenido = null;

	public Lista( ) {

	}
	public Lista(String ruta) {
		this.ruta=ruta;
		establecerContenido(this.ruta);
	}
	public String obtnerRuta() {
		return this.ruta;
	}
	public void establecerRuta(String ruta) {
		this.ruta = ruta;
	}
	public String obtenerContenido() {
		System.out.println("Tu lista: \n");
		establecerContenido(this.ruta);
		return this.contenido;
	}
	public void establecerContenido(String ruta) {
		this.contenido = "";
		try{
			File archivo = new File(ruta);
			Scanner entrada = new Scanner(archivo);
			while(entrada.hasNextLine()) {
				this.contenido += entrada.nextLine()+"\n";
			}
			entrada.close();
		}catch(FileNotFoundException e) {
			System.out.println("El archivo no se encuentra");
			e.printStackTrace();
		}
	}
	public void agregarElemento(String elemento){
		System.out.println();
		escribir(this.ruta,this.contenido+elemento);
		System.out.println("elemento "+elemento+" agregado a la lista\n");
		establecerContenido(this.ruta);
	}
	public void borrarElemento(String elemento){
		String contenidoNuevo = "";
		boolean elementoBorrado = false;

		Scanner entrada = new Scanner(this.contenido);
		while(entrada.hasNextLine()) {
			String buscador = entrada.nextLine();
			if(buscador.equals(elemento)) {
				elementoBorrado = true;
			}else {
				contenidoNuevo += buscador+"\n";
			}
		}
		if (elementoBorrado) {
			escribir(this.ruta,contenidoNuevo);
			establecerContenido(this.ruta);
			System.out.println("\nelemento "+elemento+" encontrado y borrado");
		} else {
			System.out.println("elemento no encontrado");
		}
		entrada.close();
	}
	public void datosDelArchivo() {
		File archivo = new File("archivo/Lista");

		System.out.println("File name: " + archivo.getName());
		System.out.println("Absolute path: " + archivo.getAbsolutePath());
		System.out.println("Writeable: " + archivo.canWrite());
		System.out.println("Readable " + archivo.canRead());
		System.out.println("File size in bytes " + archivo.length());
		System.out.println();
	}
	private static void escribir(String ruta, String contenidoNuevo) {
		try {
			FileWriter escritor = new FileWriter(ruta);
			escritor.write(contenidoNuevo);
			escritor.close();
			System.out.println("Se completó la escritura en el archivo");
			}catch(IOException e) {
			System.out.println("El archivo no se encuentra");
			e.printStackTrace();
		}
	}
}
