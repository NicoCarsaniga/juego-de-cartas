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
	
	public Atributo getAtributo() {
		return this.atributos.get((int)Math.random()*this.atributos.size());
	}

}
