package juegocartas;

public class Main {

	public static void main(String[] args) {

		String mazoPath = "./superheroes.json";

		Jugador j1 = new Jugador("Niko");
		Jugador j2 = new Jugador("Li");

		Juego juego = new Juego(6, j1, j2);

		juego.getMazo().crearMazo(mazoPath);


		juego.getMazo().repartirCarta(j1, j2);		

		System.out.println(j1);
		System.out.println(j2);

		juego.jugar();
		
		System.out.println(j1);
		System.out.println(j2);
	}
}
