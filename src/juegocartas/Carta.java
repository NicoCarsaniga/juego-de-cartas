package juegocartas;

import java.util.ArrayList;

public class Carta {
	
	private String nombre;
	private ArrayList<Atributo> atributos;	
	
	
	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void addAtributos(Atributo atributos) {
		this.atributos.add(atributos);
	}
	
	public Atributo getAtributo(int i) {
		return this.atributos.get(i);
	}

	public int cantAtributos() {
		return this.atributos.size();
	}
	
	
	@Override
	public String toString() {
		return "nombre: " + nombre + " => " + atributos;
	}
	
	

}
