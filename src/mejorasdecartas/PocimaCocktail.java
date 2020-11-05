package mejorasdecartas;

import java.util.ArrayList;

import juegocartas.Atributo;

public class PocimaCocktail extends PocimaAbs {

	private ArrayList<PocimaAbs> cocktail;
	
	public PocimaCocktail(String nombre) {
		super(nombre);
		this.cocktail = new ArrayList<>();
	}

	@Override
	public int aplicar(Atributo atr) {
		int salida = 0;
		for(PocimaAbs pocima: this.cocktail)
			salida += pocima.aplicar(atr);
		return salida;
	}

}
