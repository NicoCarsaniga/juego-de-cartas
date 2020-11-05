package mejorasdecartas;

import juegocartas.Atributo;

public class PocimaModificadoraPorAtributo extends PocimaAbs {

	private String nombreAtributo;
	private PocimaAbs pocima;
	
	public PocimaModificadoraPorAtributo(String nombre, String nombreAtributo, PocimaAbs pocima) {
		super(nombre);
		this.nombreAtributo = nombreAtributo;
		this.pocima = pocima;
	}

	@Override
	public int aplicar(Atributo atr) {
		if(atr.getNombre().equals(this.nombreAtributo))
			return pocima.aplicar(atr);
		return atr.getValor();
	}

}
