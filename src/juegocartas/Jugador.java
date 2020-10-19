package juegocartas;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private ArrayList<Carta> cartas;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.cartas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addCarta(Carta carta) {
		this.cartas.add(carta);
	}
	
	public void addCarta(Carta c1, Carta c2) {
		this.cartas.add(c1);
		this.cartas.add(c2);
	}
	
	public Atributo elegirAtributo() {
		return this.cartas.get(0).getAtributo();
	}

}
