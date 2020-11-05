package mejorasdecartas;

import juegocartas.Atributo;

public class PocimaValorFijo extends PocimaAbs {

	private int valor;
	public PocimaValorFijo(String nombre, int valor) {
		super(nombre);
		this.valor = valor;
	}

	@Override
	public int aplicar(Atributo atr) {
		return this.valor;
	}

}
