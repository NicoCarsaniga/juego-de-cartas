package juegocartas;


public class Juego {

	private Jugador j1, j2;
	private Mazo mazo;
	private int turnos;
	private int contadorRonda;
	

	public Juego(int turnos, Jugador j1, Jugador j2) {
		this.mazo = new Mazo();		
		this.j1 = j1;
		this.j2 = j2;
		this.turnos = turnos;
		this.contadorRonda = 0;
	}

	public Mazo getMazo() {
		return mazo;
	}

	public Jugador ronda(Jugador primero) {
		String atributoNombre = primero.getEstrategia().elegirAtributo(primero.getPrimerCarta());
		Carta c1 = j1.getPrimerCarta();
		Carta c2 = j2.getPrimerCarta();
		Jugador ganador = null;
		Jugador perdedor = null;
		int resultado = c1.combatir(c2, atributoNombre);
		this.contadorRonda++;
		
		Mensaje msjRonda = new Mensaje(atributoNombre, this.contadorRonda);
		msjRonda.eleccionAtributo(primero.getNombre());
		msjRonda.datosCombate(j1);
		msjRonda.datosCombate(j2);
		
		if(resultado < 0) {
			j2.addCarta(j1.removePrimerCarta());
			j2.addCarta(j2.removePrimerCarta());
			ganador = j2;
			perdedor = j1;
		}else if(resultado > 0) {
			j1.addCarta(j2.removePrimerCarta());
			j1.addCarta(j1.removePrimerCarta());
			ganador = j1;
			perdedor = j2;
		}else {
			j1.addCarta(j1.removePrimerCarta());
			j2.addCarta(j2.removePrimerCarta());
			msjRonda.setEmpate(true);
			//aux = ;
			ganador = primero;
			if(ganador == j1)
				perdedor = j2;
			else
				perdedor = j1;
		}
		
		msjRonda.resultadoCombate(ganador, perdedor);
		System.out.println(msjRonda.getMensajeRonda());
		return ganador;
	}

	public void jugar() {
		Jugador ganadorRonda = j1;
		while(this.contadorRonda != this.turnos && (j1.cantCartas() > 0 && j2.cantCartas() > 0)) {
			ganadorRonda = this.ronda(ganadorRonda);
		}
		System.out.println("El Juego ha Terminado Felicidades al Ganador");
	}
}
