package juegocartas;

public class Atributo implements Comparable<Atributo>{
	
	private String nombre;
	private int valor;
	
	public Atributo(String nombre, int valor) {
		
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public boolean equals(Object o) {
		Atributo a = (Atributo)o;
		return a.getNombre().equals(this.nombre);
	}

	@Override
	public int compareTo(Atributo a) {
		
		if(this.valor < a.getValor())
			return -1;
		else if(this.valor == a.getValor())
			return 0;
		else
			return 1;
	}

	@Override
	public String toString() {
		return nombre + ": " + valor;
	}
	
	

}
