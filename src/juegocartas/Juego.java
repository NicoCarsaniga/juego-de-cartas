package juegocartas;

import java.util.ArrayList;

import visormazo.VisorMazo;

public class Juego {
	
	private ArrayList<Jugador> jugadores;
	private Mazo mazo;
	private int turnos;
	
	public Juego(int turnos) {
		this.mazo = new Mazo();		
		this.jugadores = new ArrayList<>();
		this.turnos = turnos;
	}
	
	public Mazo getMazo() {
		return mazo;
	}
	
	public void addJugador(Jugador j) {
		this.jugadores.add(j);
	}
	
	public void ronda() {
		Jugador j1 = this.jugadores.get(0);
		Jugador j2 = this.jugadores.get(1);
		String atributoNombre = j1.elegirAtributo().getNombre();//debe ir jugador ganador 
		Carta c1 = j1.getPrimerCarta();
		Carta c2 = j2.getPrimerCarta();
		
		
	}
	
	
	
	
	
	//***************************************************************************************************************//

	public static void main(String[] args) {
		
		String mazoPath = "./superheroes.json";
		
		Juego juego = new Juego(20);
		
		juego.getMazo().crearMazo(mazoPath);
		
		Jugador j1 = new Jugador("Niko");
		Jugador j2 = new Jugador("Li");
		
		juego.getMazo().repartirCarta(j1, j2);
		
		
		System.out.println(j1);
		System.out.println(j2);

		
	}
	

}
