package juegocartas;

public class Mensaje {

	private boolean empate;
	private String mensajeRonda, atributoNombre;

	
	public Mensaje(String atributoNombre, int numRonda) {
		this.mensajeRonda = "------- Ronda " + numRonda + " -------\r\n";
		this.atributoNombre = atributoNombre;
	}

	public void setEmpate(boolean b) {
		this.empate = b;
	}
	
	public void eleccionAtributo(String ganadorRondaAnterior) {
		this.mensajeRonda += "El jugador " + ganadorRondaAnterior + " selecciona competir por el atributo " + this.atributoNombre + "\r\n";
	}
	
	public void datosCombate(Jugador j) {
		this.mensajeRonda += "La carta de " + j.getNombre() + " es " + j.getPrimerCarta().getNombre() + " con " + this.atributoNombre + " " + 
				j.getPrimerCarta().getValorSimple(this.atributoNombre) + "\r\n";
		if(j.getPrimerCarta().getValorSimple(this.atributoNombre) != j.getPrimerCarta().getValor(this.atributoNombre))	
			this.mensajeRonda += "Se aplicó pócima " + j.getPrimerCarta().getPocima().getNombre() +", valor resultante " + 
					j.getPrimerCarta().getValor(this.atributoNombre) + "\r\n";
	}

	public void resultadoCombate(Jugador ganador, Jugador perdedor) {
		String resultado = "Gana la ronda ";
		if(this.empate)
			resultado = "Hubo Empate. ";
		
		this.mensajeRonda +=  resultado + ganador.getNombre() + " queda con " + ganador.cantCartas() + " cartas ( " + perdedor.getNombre() +
				" posee ahora " + perdedor.cantCartas() + " cartas)\r\n";
	}

	public String getMensajeRonda() {
		return this.mensajeRonda;
	}
	
	
}
