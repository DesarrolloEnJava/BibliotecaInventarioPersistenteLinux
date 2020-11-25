package principal;

import java.util.Scanner;

public class Enciclopedia extends Libro{
	private String temas;

	public Enciclopedia( ) {
		super("Enciclopedia");
	}
	public String getTemas() {
		return temas;
	}
	public void setTemas(String temas) {
		this.temas = temas;
	}
	@Override
	public String getAtributos() {
		String libro = super.getAtributos();
		libro += getTemas();
		return libro;
	}
	@Override
	public void setAtributos(Scanner entrada) {
		super.setAtributos(entrada);
		System.out.println("Ingresa los temas");
		this.temas = entrada.nextLine();
	}
}
