package juegocartas.estrategiasJugador;

import juegocartas.Carta;

public class Obstinado extends EstrategiaJugador {

	private String atributo;
	
	public Obstinado(String atributo) {
		super();
		this.atributo = atributo;
	}

	@Override
	public String elegirAtributo(Carta carta) {
		if(carta.tieneAtributo(this.atributo))
			return this.atributo;
		return carta.getAtributo(0).getNombre();
	}

}
