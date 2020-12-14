package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class ListaPropiedades {

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

	public Properties obtenerElemento(String ruta)  {
		Properties elemento = new Properties();
		try {
			elemento.load(new FileReader(ruta));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elemento;
	}

	public String[] obtenerListaDeElementos(String ruta) {
		File raiz = new File(ruta);
		if (raiz.exists() && raiz.isDirectory()) {
			String[] elementos = raiz.list();
			return elementos;
		} else if (!raiz.exists()) {
			String[] elementos = {"No existe la carpeta"};
			return elementos;
		} else {
			String[] elementos = {"La ruta no apunta a una carpeta"};
			return elementos;
		}
	}

	public String datosDelaCarpeta(String ruta) {
		File archivo = new File(ruta);
		String datos = "";
		datos += "File name: " + archivo.getName()+"\n";
		datos += "Absolute path: " + archivo.getAbsolutePath()+"\n";
		datos += "Writeable: " + archivo.canWrite()+"\n";
		datos += "Readable " + archivo.canRead()+"\n";
		datos += "File size in bytes " + archivo.length()+"\n";
		return datos;
	}
}