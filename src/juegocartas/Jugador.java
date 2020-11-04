package juegocartas;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private ArrayList<Carta> cartas;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.cartas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addCarta(Carta c) {
		this.cartas.add(c);
	}
	
	/*
	 * Devuelve un atributo de manera random verificando la cantidad de los mismos por carta
	 */
	public String elegirAtributo() {
		
		int atributo = (int) ((Math.random())*(this.getPrimerCarta().cantAtributos()));
		return this.getPrimerCarta().getAtributo(atributo).getNombre();
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
