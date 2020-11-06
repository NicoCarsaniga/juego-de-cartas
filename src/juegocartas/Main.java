package juegocartas;

import juegocartas.estrategiasJugador.EstrategiaJugador;
import juegocartas.estrategiasJugador.Inteligente;
import juegocartas.estrategiasJugador.Obstinado;
import juegocartas.estrategiasJugador.Timbero;
import mejorasdecartas.PocimaAbs;
import mejorasdecartas.PocimaModificadora;
import mejorasdecartas.PocimaModificadoraPorAtributo;

public class Main {

	public static void main(String[] args) {

		String mazoPath = "./superheroes.json";
		
		EstrategiaJugador inteligente = new Inteligente();
		EstrategiaJugador porfiado = new Obstinado("velocidad");
		EstrategiaJugador timbero = new Timbero();

		Jugador j1 = new Jugador("Niko", inteligente);
		Jugador j2 = new Jugador("Li", inteligente);

		Juego juego = new Juego(1000, j1, j2);

		juego.getMazo().crearMazo(mazoPath);
		
		
		PocimaAbs fortalecedora = new PocimaModificadora("fortalecedora", 50);
		PocimaAbs fuerza35 = new PocimaModificadora("fuerza", 35);
		PocimaAbs SelectivaFuerza = new PocimaModificadoraPorAtributo("Fuerza", "fuerza", fuerza35);
		
		juego.getMazo().addPocima(fortalecedora);
		juego.getMazo().addPocima(fuerza35);
		juego.getMazo().addPocima(SelectivaFuerza);
		
		juego.getMazo().repartirCarta(j1, j2);		

		System.out.println(j1);
		System.out.println(j2);

		juego.jugar();
		
		System.out.println(j1);
		System.out.println(j2);
	}
}
