package juegocartas;

import juegocartas.estrategiasJugador.EstrategiaJugador;
import juegocartas.estrategiasJugador.Inteligente;
import juegocartas.estrategiasJugador.Obstinado;

public class Main {

	public static void main(String[] args) {

		String mazoPath = "./autos.json";
		
		EstrategiaJugador inteligente = new Inteligente();
		EstrategiaJugador porfiado = new Obstinado("velocidad");

		Jugador j1 = new Jugador("Niko", porfiado);
		Jugador j2 = new Jugador("Li", inteligente);

		Juego juego = new Juego(1000, j1, j2);

		juego.getMazo().crearMazo(mazoPath);


		juego.getMazo().repartirCarta(j1, j2);		

		System.out.println(j1);
		System.out.println(j2);

		juego.jugar();
		
		System.out.println(j1);
		System.out.println(j2);
	}
}
