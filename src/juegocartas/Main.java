package juegocartas;

import juegocartas.estrategiasJugador.EstrategiaJugador;
import juegocartas.estrategiasJugador.Inteligente;
import juegocartas.estrategiasJugador.Obstinado;
import juegocartas.estrategiasJugador.Timbero;
import mejorasdecartas.PocimaAbs;
import mejorasdecartas.PocimaCocktail;
import mejorasdecartas.PocimaModificadora;
import mejorasdecartas.PocimaModificadoraPorAtributo;
import mejorasdecartas.PocimaValorFijo;

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
		
		
		PocimaModificadora fortalecedora = new PocimaModificadora("fortalecedora", 20);
		PocimaModificadora foratlecedoraPlus = new PocimaModificadora("fortalecedora plus", 50);
		PocimaModificadora kriptonita = new PocimaModificadora("kriptonita", -25);
		PocimaModificadora reductorPb = new PocimaModificadora("reductor de plomo", -55);
		PocimaValorFijo quieroVale4 = new PocimaValorFijo("quiero vale cuatro", 4);
		PocimaValorFijo numeMagico = new PocimaValorFijo("numero magico", 23);
		PocimaValorFijo riverito = new PocimaValorFijo("riverito", 8);

		PocimaModificadora fuerza35 = new PocimaModificadora("fuerza", 35);
		PocimaModificadoraPorAtributo SelectivaFuerza = new PocimaModificadoraPorAtributo("selectiva fuerza", "fuerza", fuerza35);
		PocimaAbs peso = new PocimaModificadora("peso", 43);
		PocimaModificadoraPorAtributo SelectivaPeso = new PocimaModificadoraPorAtributo("selectiva peso", "peso", peso);

		PocimaCocktail cocktail1 = new PocimaCocktail("cocktail");
		cocktail1.addPocima(fortalecedora);
		cocktail1.addPocima(SelectivaPeso);
		cocktail1.addPocima(riverito);
		PocimaCocktail cocktail2 = new PocimaCocktail("cocktail");
		cocktail2.addPocima(foratlecedoraPlus);
		cocktail2.addPocima(SelectivaPeso);
		cocktail2.addPocima(kriptonita);
		
		
		juego.getMazo().addPocima(fortalecedora);
		juego.getMazo().addPocima(foratlecedoraPlus);
		juego.getMazo().addPocima(kriptonita);
		juego.getMazo().addPocima(reductorPb);
		juego.getMazo().addPocima(quieroVale4);
		juego.getMazo().addPocima(numeMagico);
		juego.getMazo().addPocima(riverito);
		juego.getMazo().addPocima(SelectivaFuerza);
		juego.getMazo().addPocima(SelectivaPeso);
		juego.getMazo().addPocima(cocktail1);
		juego.getMazo().addPocima(cocktail2);

		
		juego.getMazo().repartirCarta(j1, j2);		

		System.out.println(j1);
		System.out.println(j2);

		juego.jugar();
		
		System.out.println(j1);
		System.out.println(j2);
	}
}
