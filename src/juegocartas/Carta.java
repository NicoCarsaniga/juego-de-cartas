package juegocartas;

import java.util.ArrayList;

import mejorasdecartas.PocimaAbs;

public class Carta {
	
	private String nombre;
	private ArrayList<Atributo> atributos;	
	private PocimaAbs pocima;
	
	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<>();
		this.pocima = null;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public PocimaAbs getPocima() {
		return pocima;
	}
	
	public void setPocima(PocimaAbs pocima) {
		this.pocima = pocima;
	}
	
	public void addAtributos(Atributo atributos) {
		this.atributos.add(atributos);
	}

	public boolean tieneAtributo(String s) {
		for(Atributo atributo: atributos)
			if(atributo.getNombre().equals(s))
				return true;
		return false;
	}
	
	public Atributo getAtributo(int i) {
		return new Atributo(this.atributos.get(i).getNombre(), this.atributos.get(i).getValor());
	}
	
	public int cantAtributos() {
		return this.atributos.size();
	}
	
	public int getValorSimple(String nombre) {
		for(Atributo atributo: atributos)
			if(atributo.getNombre().equals(nombre)){
				return atributo.getValor();
			}
		return 0;
	}
	
	public int getValor(String nombre) {
		for(Atributo atributo: atributos)
			if(atributo.getNombre().equals(nombre)){
				if(this.pocima == null){
					return atributo.getValor();
				}else
					return this.modificar(atributo);
			}
		return 0;
	}
	
	private int modificar(Atributo atributo) {
		int num = 0;
		if(this.pocima != null)
			num = this.pocima.aplicar(atributo);
		return num;
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
