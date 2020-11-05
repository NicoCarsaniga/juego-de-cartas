package mejorasdecartas;

import juegocartas.Atributo;

public abstract class PocimaAbs {
	
	private String nombre;
	
	public PocimaAbs(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract int aplicar(Atributo atr);	

}
