package juegocartas;

import java.util.ArrayList;

import juegocartas.estrategiasJugador.EstrategiaJugador;

public class Jugador {
	
	private String nombre;
	private ArrayList<Carta> cartas;
	private EstrategiaJugador estrategia;
	
	public Jugador(String nombre, EstrategiaJugador estrategia) {
		this.nombre = nombre;
		this.cartas = new ArrayList<>();
		this.estrategia = estrategia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstrategiaJugador getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(EstrategiaJugador estrategia) {
		this.estrategia = estrategia;
	}

	public void addCarta(Carta c) {
		this.cartas.add(c);
	}

	/*
	 * Devuelve la primer carta del mazo propio
	 */
	public Carta getPrimerCarta() {
		return this.cartas.get(0);
	}
	
	/**
	 * Devuelve y remueve la primer carta
	 * @return
	 */
	public Carta removePrimerCarta() {
		return this.cartas.remove(0);
	}
	
	/**
	 * Devuelve la cantidad de cartas del jugador
	 */
	public int cantCartas() {
		return this.cartas.size();
	}
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", cartas=" + cartas + "]";
	}

	
}
