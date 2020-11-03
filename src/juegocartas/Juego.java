package juegocartas;

public class Juego {

	private Jugador j1, j2;
	private Mazo mazo;
	private int turnos;

	public Juego(int turnos, Jugador j1, Jugador j2) {
		this.mazo = new Mazo();		
		this.j1 = j1;
		this.j2 = j2;
		this.turnos = turnos;
	}

	public Mazo getMazo() {
		return mazo;
	}

	public Jugador ronda(Jugador ganador) {
		String atributoNombre = ganador.elegirAtributo();
		Carta c1 = j1.getPrimerCarta();
		Carta c2 = j2.getPrimerCarta();
		int resultado = c1.combatir(c2, atributoNombre);
		this.turnos--;
		if(resultado < 0) {
			j2.addCarta(j1.removePrimerCarta());
			return j2;
		}else if(resultado > 0) {
			j1.addCarta(j2.removePrimerCarta());
			return j1;
		}else {
			j1.addCarta(c1);
			j2.addCarta(c2);
			return ganador;
		}
	}

	public void jugar() {
		while(turnos > 0) {
			this.ronda(j1);
		}
	}






}
