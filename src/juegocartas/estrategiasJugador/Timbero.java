package juegocartas.estrategiasJugador;

import juegocartas.Carta;

public class Timbero extends EstrategiaJugador {

	@Override
	public String elegirAtributo(Carta carta) {
		int atributo = (int) ((Math.random())*(carta.cantAtributos()));
		return carta.getAtributo(atributo).getNombre();
	}

}
