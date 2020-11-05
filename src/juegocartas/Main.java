package juegocartas;

import juegocartas.estrategiasJugador.EstrategiaJugador;
import juegocartas.estrategiasJugador.Inteligente;
import juegocartas.estrategiasJugador.Obstinado;
import mejorasdecartas.PocimaAbs;
import mejorasdecartas.PocimaModificadora;
import mejorasdecartas.PocimaModificadoraPorAtributo;

public class Main {

	public static void main(String[] args) {

		String mazoPath = "./superheroes.json";
		
		EstrategiaJugador inteligente = new Inteligente();
		EstrategiaJugador porfiado = new Obstinado("velocidad");

		Jugador j1 = new Jugador("Niko", porfiado);
		Jugador j2 = new Jugador("Li", inteligente);

		Juego juego = new Juego(1000, j1, j2);

		juego.getMazo().crearMazo(mazoPath);
		
		PocimaAbs fortalecedora = new PocimaModificadora("fortalecedora", 1.50);
		PocimaAbs fuerza35 = new PocimaModificadora("fuerza", 1.35);
		PocimaAbs SelectivaFuerza = new PocimaModificadoraPorAtributo("Fuerza", "fuerza", fuerza35);
		

		juego.getMazo().repartirCarta(j1, j2);		

		System.out.println(j1);
		System.out.println(j2);

		juego.jugar();
		
		System.out.println(j1);
		System.out.println(j2);
	}
}
