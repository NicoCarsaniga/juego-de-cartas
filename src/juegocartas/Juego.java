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
		this.contadorRonda = 1;
	}

	public Mazo getMazo() {
		return mazo;
	}

	public Jugador ronda(Jugador ganador) {
		String atributoNombre = ganador.elegirAtributo();
		Carta c1 = j1.getPrimerCarta();
		Carta c2 = j2.getPrimerCarta();
		int resultado = c1.combatir(c2, atributoNombre);
		this.contadorRonda++;
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
		Jugador ganadorRonda = j1;
		while(this.contadorRonda != this.turnos) {
			ganadorRonda = this.ronda(ganadorRonda);
		}
	}

	//Modificar el msj con variables
	public String crearMensaje() {
		String mensaje = "------- Ronda 1 -------\r\n" + 
				"El jugador Juan selecciona competir por el atributo fuerza\r\n" + 
				"La carta de Juan es Flash con fuerza 840 , se aplicó pócima\r\n" + 
				"Fortalecedora valor resultante 924\r\n" + 
				"La carta de María es Súperman con fuerza 2000\r\n" + 
				"Gana la ronda María y queda con 11 cartas ( Juan posee ahora 9\r\n" + 
				"cartas)\r\n" + 
				"------- Ronda 2 -------\r\n" + 
				"El jugador María selecciona competir por el atributo velocidad\r\n" + 
				"La carta de Juan es Manhunter con velocidad 85\r\n" + 
				"La carta de María es Firestorm con velocidad 220 , se aplicó pócima\r\n" + 
				"cocktail valor resultante 1255\r\n" + 
				"Gana la ronda María y queda con 12 cartas ( Juan posee ahora 8\r\n" + 
				"cartas)";
		
		return mensaje;
	}




}
