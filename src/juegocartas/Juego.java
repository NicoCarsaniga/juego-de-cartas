package juegocartas;

import java.util.ArrayList;

import visormazo.VisorMazo;

public class Juego {
	
	private ArrayList<Jugador> jugadores;
	private Mazo mazo;
	
	public Juego() {
		this.mazo = new Mazo();		
		this.jugadores = new ArrayList<>();
	}
	
	public Mazo getMazo() {
		return mazo;
	}
	
	public void addJugador(Jugador j) {
		this.jugadores.add(j);
	}

	public static void main(String[] args) {
		
		String mazoPath = "./superheroes.json";
		
		Juego juego = new Juego();
		
		juego.getMazo().crearMazo(mazoPath);
		
	}
	

}
