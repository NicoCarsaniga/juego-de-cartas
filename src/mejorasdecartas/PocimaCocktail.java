package mejorasdecartas;

import java.util.ArrayList;

import juegocartas.Atributo;

public class PocimaCocktail extends PocimaAbs {

	private ArrayList<PocimaAbs> cocktail;
	
	public PocimaCocktail(String nombre) {
		super(nombre);
		this.cocktail = new ArrayList<>();
	}

	public void addPocima(PocimaAbs p) {
		this.cocktail.add(p);
	}
	
	@Override
	public int aplicar(Atributo atr) {
		Atributo salida = atr;
		for(PocimaAbs pocima: this.cocktail)
			salida = new Atributo(salida.getNombre(), pocima.aplicar(salida));		
		return salida.getValor();
	}

}
