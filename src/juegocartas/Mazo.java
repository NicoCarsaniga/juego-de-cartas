package juegocartas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Mazo {

	private ArrayList<Carta> cartas;
	private ArrayList<Carta> excluidas;

	public Mazo() {
		this.cartas = new ArrayList<>();
		this.excluidas = new ArrayList<>();
	}

	public void addCarta(Carta c) {
		this.cartas.add(c);
	}

	/**
	 * Desecha las cartas diferentes, las mezcla y las reparte a los jugadores ingresados por parametro
	 * @param Jugador j1
	 * @param Jugador j2
	 */
	public void repartirCarta(Jugador j1, Jugador j2) {
		
		this.desecharCartasDiferente();
		this.barajar();
		for(int i = 0; i < this.cartas.size(); i++)
			if(i % 2 == 0)
				j1.addCarta(this.cartas.get(i));
			else
				j2.addCarta(this.cartas.get(i));
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
		System.out.println(this.cartas);
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
	public void desecharCartasDiferente() {
		int num = this.getIndiceModelo();
		for(int i = 0; i < cartas.size(); i++){
			if(!this.cartas.get(i).equals(this.cartas.get(num))){
				this.excluidas.add(this.cartas.get(i));
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
