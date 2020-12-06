package principal;

import java.util.Scanner;

public class Libro {
	private String ruta;
	private String id;
	private String titulo;
	private String autor;
	private String fechaPublicacion;

	public Libro(String[] datosDelLibro) {
		this.id = datosDelLibro[1];
		this.titulo = datosDelLibro[2];
		this.autor = datosDelLibro[3];
		this.fechaPublicacion = datosDelLibro[4];
		this.ruta = datosDelLibro[0]+id;
	}
	public String getRuta() {
		return ruta;
	}
	
	public String getId() {
		return id;
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
	public String getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(String editorial) {
		this.fechaPublicacion = editorial;
	}
	public String getAtributos() {
		String libro = id+" "+titulo+" "+autor+" "+fechaPublicacion+" "; 
		return libro;
	}
	public void setAtributos(Scanner entrada) {
		
		this.id = entrada.nextLine();
		
		this.titulo = entrada.nextLine();
		
		this.autor = entrada.nextLine();
		
		this.fechaPublicacion = entrada.nextLine();
	}
}
