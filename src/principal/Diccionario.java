package principal;

import java.util.Scanner;

public class Diccionario extends Libro {
	private String idioma;

	public Diccionario() {
		super("Dicionario");
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	@Override
	public String getAtributos() {
		String libro = super.getAtributos();
		libro += getIdioma();
		return libro;
	}
	@Override
	public void setAtributos(Scanner entrada) {
		super.setAtributos(entrada);
		System.out.println("Ingresa el idioma");
		this.idioma = entrada.nextLine();
	}
}
