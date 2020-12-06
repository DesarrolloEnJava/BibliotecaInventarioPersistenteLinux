package principal;

import java.util.Properties;
import java.util.Scanner;

public class Main {
	static Inventario inventario = new Inventario();
	static Scanner entrada = new Scanner(System.in);
	static String carpeta = "archivo";
	
	public static void main(String[] args) {
		int opcion;
		do {
			presentarMenuPrincipal();
			opcion = obtenerOpcion(entrada);
			ejecutarOpcion(opcion);
		}while(opcion != 3);
		entrada.close();
	}
	public static void presentarMenuPrincipal() {// Preguntar al usuario el proceso que quiere realizar
		System.out.println("Ingresa el numero de la opcion deseada y preciona enter");
		System.out.println("1 - Registrar nuevo libro");
		System.out.println("2 - Consultar libros");
		System.out.println("3 - terminar");
	}
	public static int obtenerOpcion(Scanner entrada) { // Obtener el tipo de libro que capturo el usuario
		int dato = entrada.nextInt();
		entrada.nextLine();
		return dato;
	}
	public static void ejecutarOpcion(int opcion) {
		if(opcion == 1) {
			registrarLibro(obtnerDatosDelLibro());
		}else if(opcion == 2) {
			System.out.println(inventario.obtenerInventario());
		}else if(opcion == 3) {
			System.out.println("Terminamos por hoy, hasta la proxima");
		}else {
			System.out.println("La opcion elegida no existe");
		}
	}
	public static Properties obtnerDatosDelLibro() {// Preguntar al usuario el tipo de libro que quiere registrar
		Properties propiedadesLibro = new Properties();
		System.out.println("Ingrese el numero de registro");
		String id = entrada.nextLine();
		propiedadesLibro.setProperty("ruta",carpeta+id);
		propiedadesLibro.setProperty("id",id);
		System.out.println("Ingrese el autor");
		propiedadesLibro.setProperty("Autor",entrada.nextLine());
		System.out.println("Ingrese el titulo");
    	propiedadesLibro.setProperty("titulo",entrada.nextLine());
    	System.out.println("Ingrese el año de publicación");
    	propiedadesLibro.setProperty("fechaPublicacion",entrada.nextLine());
		return propiedadesLibro;
	}
	public static void registrarLibro(Properties Libro) {
		
		inventario.agregarElemento(Libro);
	}
}