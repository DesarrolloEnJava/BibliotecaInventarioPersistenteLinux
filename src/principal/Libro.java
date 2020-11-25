package principal;

import java.util.Scanner;

public class Libro {
	private String tipo;
	private String titulo;
	private String autor;
	private String editorial;

	public Libro(String tipo) {
		this.tipo = tipo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getAtributos() {
		String libro = tipo+" "+titulo+" "+autor+" "+editorial+" "; 
		return libro;
	}
	public void setAtributos(Scanner entrada) {
		System.out.println("Ingresa el titulo");
		this.titulo = entrada.nextLine();
		System.out.println("Ingresa el autor");
		this.autor = entrada.nextLine();
		System.out.println("Ingresa la editorial");
		this.editorial = entrada.nextLine();
	}
}
