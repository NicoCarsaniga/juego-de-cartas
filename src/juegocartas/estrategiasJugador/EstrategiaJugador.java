package juegocartas.estrategiasJugador;

import juegocartas.Carta;

public abstract class EstrategiaJugador {
	/*
	 * Devuelve un string con el nombre del atributo seleccionado
	 */
	public abstract String elegirAtributo(Carta carta); 

}
