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
	
	//reveer
	//metodo que devuelve un list<string>
	public Atributo getAtributo(int i) {
		return this.atributos.get(i);
	}

	public int cantAtributos() {
		return this.atributos.size();
	}
	
	public boolean tieneAtributo(String s) {
		for(Atributo atributo: atributos)
			if(atributo.getNombre().equals(s))
				return true;
		return false;
	}
	
	public int getValor(String nombre) {
		for(Atributo atributo: atributos)
			if(atributo.getNombre().equals(nombre))
				return atributo.getValor();
		return 0;
	}
	
	public int combatir(Carta carta, String nombre) {
		return Integer.compare(this.getValor(nombre), carta.getValor(nombre));
	}
	
	@Override
	public String toString() {
		return "nombre: " + nombre + " => " + atributos;
	}
	
	@Override
	public boolean equals(Object o) {
		Carta c = (Carta)o;
		String s = "";		
		for(Atributo atributo: atributos) {
			s = atributo.getNombre();
			if(!c.tieneAtributo(s))
				return false;
		}
		return true;		
	}

	
	

}
