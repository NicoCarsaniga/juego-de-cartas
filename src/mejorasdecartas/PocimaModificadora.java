package mejorasdecartas;

import juegocartas.Atributo;

public class PocimaModificadora extends PocimaAbs {

	private double porcentaje;

	public PocimaModificadora(String nombre, double porcentaje) {
		super(nombre);
		this.porcentaje= porcentaje;
	}

	@Override
	public int aplicar(Atributo atr) {
		return (int) (atr.getValor() * this.porcentaje);
	}

}
