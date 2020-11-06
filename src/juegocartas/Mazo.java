package juegocartas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import mejorasdecartas.PocimaAbs;

public class Mazo {

	private ArrayList<Carta> cartas;
	private ArrayList<PocimaAbs> pocimas;

	public Mazo() {
		this.cartas = new ArrayList<>();
		this.pocimas = new ArrayList<>();
	}

	public void addCarta(Carta c) {
		this.cartas.add(c);
	}
	
	public void addPocima(PocimaAbs pocima){
		this.pocimas.add(pocima);
	}

	/**
	 * Desecha las cartas diferentes, las mezcla y las reparte a los jugadores ingresados por parametro
	 * @param Jugador j1
	 * @param Jugador j2
	 */
	public void repartirCarta(Jugador j1, Jugador j2) {
		
		this.desecharCartasDiferente();
		this.barajar();
		this.asignarPocima();
		this.barajar();
		for(int i = 0; i < this.cartas.size(); i++)
			if(i % 2 == 0)
				j1.addCarta(this.cartas.get(i));
			else
				j2.addCarta(this.cartas.get(i));
	}

	private void asignarPocima() {
		Collections.shuffle(pocimas);	
		int limite = 0;
		if(pocimas.size() <= cartas.size())
			limite = pocimas.size();
		else
			limite = cartas.size();
		
		for(int i = 0; i < limite; i++)
			cartas.get(i).setPocima(pocimas.get(i));		
				
	}

	private void barajar() {
		ArrayList<Carta> aux = new ArrayList<>();
		for(int i = 0; i < (int) (Math.random()*cartas.size()); i++) {
			for(int j = 0; j < this.cartas.size(); j++) {
				int indice = (int) (Math.random()*cartas.size());
				aux.add(this.cartas.remove(indice));
			}
		}
		this.cartas.addAll(aux);
	}
	
	/**
	 * devuelve el indice con la primer carta igual a la mayoria
	 * @return
	 */	
	public int getIndiceModelo() {
		int temp = 0;
		for(int i = 0; i<cartas.size(); i++){
			for(int j = 0; j<cartas.size(); j++){
				if(cartas.get(i).equals(cartas.get(j)))
					temp++;
				else
					temp--;					
			}
			if(temp>0)
				return i;
		}
		return -1;
	}
	/**
	 * Desecha las cartas que no son del mismo tipo
	 */
	private void desecharCartasDiferente() {
		int num = this.getIndiceModelo();
		for(int i = 0; i < cartas.size(); i++){
			if(!this.cartas.get(i).equals(this.cartas.get(num))){
				this.cartas.remove(this.cartas.get(i));
			}
		}
	}

	/**
	 * Instancia un mazo a partir de un archivo .json
	 * @param jsonFile
	 */
	public void crearMazo(String jsonFile) {
		File jsonInputFile = new File(jsonFile);
		InputStream is;
		try {
			is = new FileInputStream(jsonInputFile);
			// Creo el objeto JsonReader de Json.
			JsonReader reader = Json.createReader(is);
			// Obtenemos el JsonObject a partir del JsonReader.
			JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
			for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
				String nombreCarta = carta.getString("nombre");
				Carta c = new Carta(nombreCarta);
				JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
				//String atributosStr = "";
				for (String nombreAtributo:atributos.keySet()){
					//atributosStr = atributosStr + nombreAtributo + ": " + atributos.getInt(nombreAtributo) + "; ";
					Atributo a = new Atributo(nombreAtributo, atributos.getInt(nombreAtributo));
					c.addAtributos(a);
				}
				//System.out.println(nombreCarta+"\t\t\t"+atributosStr);
				this.addCarta(c);
			}

			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
