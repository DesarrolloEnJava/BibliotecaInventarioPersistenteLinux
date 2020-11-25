package principal;

import java.util.Scanner;

public class Main {
	static Inventario inventario = new Inventario("archivo/Lista");
	static Scanner entrada = new Scanner(System.in);
	
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
			preguntarTipoDeLibroPorRegistrar();
			int tipo = obtenerOpcion(entrada);
			registrarLibro(tipo);
		}else if(opcion == 2) {
			System.out.println(inventario.obtenerInventario());
		}else if(opcion == 3) {
			System.out.println("Terminamos por hoy, hasta la proxima");
		}else {
			System.out.println("La opcion elegida no existe");
		}
	}
	public static void preguntarTipoDeLibroPorRegistrar() {// Preguntar al usuario el tipo de libro que quiere registrar
		System.out.println("Ingresa el numero de la opcion deseada y preciona enter");
		System.out.println("1 - Registrar Diccionario");
		System.out.println("2 - Registrar Enciclopedia");
		System.out.println("3 - Registar Novela");
	}
	public static void registrarLibro(int tipo) {
		if (tipo == 1) {
			Diccionario diccionarioNuevo = new Diccionario( );
			diccionarioNuevo.setAtributos(entrada);
			inventario.registrarLibro(diccionarioNuevo.getAtributos());
		} else if(tipo == 2){
			Enciclopedia enciclopediaNueva = new Enciclopedia();
			enciclopediaNueva.setAtributos(entrada);
			inventario.registrarLibro(enciclopediaNueva.getAtributos());
		}else if (tipo == 3){
			Novela novelaNueva = new Novela();
			novelaNueva.setAtributos(entrada);
			inventario.registrarLibro(novelaNueva.getAtributos());
		}else {
			System.out.println("La opcion elegida no existe");
		}
		
	}
}