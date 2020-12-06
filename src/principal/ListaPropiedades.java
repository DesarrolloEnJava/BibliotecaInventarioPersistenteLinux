package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class ListaPropiedades {
	private String ruta=null;
	private String contenido = null;

	public ListaPropiedades() {
		
	}
	
	public String[] obtenerElementos(String ruta) throws FileNotFoundException, IOException {
		File raiz = new File(ruta);
		String[] archivos = raiz.list(); 
        String[] elementos = new String[archivos.length];
        int i = 0;
        String propiedades = "";
        for (String archivo : archivos) {
        	Properties propiedadesElemento = new Properties();
        	propiedadesElemento.load(new FileReader(ruta+archivo));
        	propiedades += propiedadesElemento.getProperty("id", "sin elemento");
        	propiedades += propiedadesElemento.getProperty("autor", "sin elemento");
        	propiedades += propiedadesElemento.getProperty("titulo", "sin elemento");
        	propiedades += propiedadesElemento.getProperty("fechaPublicacion", "sin elemento");
        	elementos[i] = propiedades;
        	propiedades = "";
        	propiedadesElemento.clear();
        	i++;
		}
		return elementos;
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
	
	public void agregarElemento(Properties elemento){
		try {
			FileWriter escritor = new FileWriter(elemento.getProperty("ruta"));
			elemento.store(escritor, "primer libro");
			escritor.close();
			System.out.println("Se completó la escritura en el archivo");
			}catch(IOException e) {
			System.out.println("Error al escribir el archivo");
			e.printStackTrace();
		}
	}
	
	public void borrarElemento(Properties elemento){
		File archivo = new File(elemento.getProperty("ruta")); 
	    if (archivo.delete()) { 
	      System.out.println("Se borro el archivo: " + archivo.getName());
	    } else {
	      System.out.println("Error al borrar el archivo");
	    } 
	}
	
	public void datosDelArchivo() {
		File archivo = new File("archivo/");

		System.out.println("File name: " + archivo.getName());
		System.out.println("Absolute path: " + archivo.getAbsolutePath());
		System.out.println("Writeable: " + archivo.canWrite());
		System.out.println("Readable " + archivo.canRead());
		System.out.println("File size in bytes " + archivo.length());
		System.out.println();
	}
}