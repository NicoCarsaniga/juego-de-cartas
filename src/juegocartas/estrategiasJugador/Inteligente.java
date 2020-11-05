package juegocartas.estrategiasJugador;

import juegocartas.Carta;

public class Inteligente extends EstrategiaJugador {

	@Override
	public String elegirAtributo(Carta carta) {
		int valorMax = 0;
		int temp = 0;
		String atr = null;
		for(int i = 0; i < carta.cantAtributos(); i++ ) {
			temp = carta.getAtributo(i).getValor();
			if(valorMax < carta.getAtributo(i).getValor()){
				valorMax = temp;
				atr = carta.getAtributo(i).getNombre();
			}
		}
		return atr;
	}

}
