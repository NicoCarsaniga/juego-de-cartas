package juegocartas;

import java.util.ArrayList;

public class Mazo {
	
	private ArrayList<Carta> cartas;
	
	public Mazo() {
		this.cartas = new ArrayList<>();
	}
	
	public void addCarta(Carta c) {
		this.cartas.add(c);
	}
	
	public Carta repartirCarta() {
		return this.cartas.remove((int)Math.random()*cartas.size());
	}

}
