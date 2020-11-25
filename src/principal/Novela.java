package principal;

import java.util.Scanner;

public class Novela extends Libro{
	private String capitulos;
	
	public Novela( ) {
		super("Novela");
	}
	public String getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(String capitulos) {
		this.capitulos = capitulos;
	}
	@Override
	public String getAtributos() {
		String libro = super.getAtributos();
		libro += getCapitulos();
		return libro;
	}
	@Override
	public void setAtributos(Scanner entrada) {
		super.setAtributos(entrada);
		System.out.println("Ingresa los capitulos");
		this.capitulos = entrada.nextLine();
	}
}
