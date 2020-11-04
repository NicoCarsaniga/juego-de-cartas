package juegocartas;

public class Juego {

	private Jugador j1, j2;
	private Mazo mazo;
	private int turnos;
	private int contadorRonda;

	//Crear constructor sin turnos
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
		String atributoNombre = primero.elegirAtributo();
		Carta c1 = j1.getPrimerCarta();
		Carta c2 = j2.getPrimerCarta();
		Jugador ganador = null;
		Jugador perdedor = null;
		int resultado = c1.combatir(c2, atributoNombre);
		this.contadorRonda++;
		if(resultado < 0) {
			j2.addCarta(j1.removePrimerCarta());
			ganador = j2;
			perdedor = j1;
		}else if(resultado > 0) {
			j1.addCarta(j2.removePrimerCarta());
			ganador = j1;
			perdedor = j2;
		}else {
			j1.addCarta(c1);
			j2.addCarta(c2);
			if(ganador == j1)
				perdedor = j2;
			perdedor = j1;
		}
		System.out.println("------- Ronda " + this.contadorRonda + " -------\r\n" + 
				"El jugador " + primero.getNombre() + " selecciona competir por el atributo " + atributoNombre + "\r\n" + 
				"La carta de " + j1.getNombre() + " es " + j1.getPrimerCarta().getNombre() + " con " + atributoNombre + " " + j1.getPrimerCarta().getValor(atributoNombre) + " , se aplicó pócima\r\n" + 
				"Fortalecedora valor resultante 924\r\n" + 
				"La carta de " + j2.getNombre() + " es " + j2.getPrimerCarta().getNombre() + " con " + atributoNombre + " " + j2.getPrimerCarta().getValor(atributoNombre) + "\r\n" + 
				"Gana la ronda " + ganador.getNombre() + " y queda con " + ganador.cantCartas() + " cartas ( " + perdedor.getNombre() + " posee ahora " + perdedor.cantCartas() + "\r\n" + 
				"cartas)\r\n");
		return ganador;
	}

	public void jugar() {
		Jugador ganadorRonda = j1;
		while(this.contadorRonda != this.turnos && (j1.cantCartas() > 0 && j2.cantCartas() > 0)) {
			ganadorRonda = this.ronda(ganadorRonda);
		}
	}


}
