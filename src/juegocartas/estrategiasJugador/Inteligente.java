package juegocartas.estrategiasJugador;

import juegocartas.Carta;

public class Inteligente extends EstrategiaJugador {

	@Override
	public String elegirAtributo(Carta carta) {
		int valorMax = 0;
		for(int i = 0; i < carta.cantAtributos(); i++ ) {
			valorMax = carta.getAtributo(i).getValor();
		}
	}

}
