package mejorasdecartas;

import juegocartas.Atributo;

public class PocimaMezcla extends PocimaAbs {
	
	private PocimaAbs p1;
	private PocimaAbs p2;

	public PocimaMezcla(String nombre, PocimaAbs p1, PocimaAbs p2) {
		super(nombre);
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public int aplicar(Atributo atr) {	
		int temp = this.p1.aplicar(atr);
		Atributo atri = new Atributo(atr.getNombre(), temp);
		int salida	= this.p2.aplicar(atri);
		
		return salida;
	}

}
