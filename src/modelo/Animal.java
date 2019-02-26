package modelo;

import java.util.Random;

public enum Animal {
	PERRO, GATO, VACA, LORO, PEZ, OSO, ARDILLA, CIERVO, GALLINA, BUHO;
	
	private static final int SIZE = Animal.values().length;
	private boolean asignado = false; //para saber si ya ha sido asignado para descartarlo
	
	/**Genera un animal aleatorio de la enumeracion y lo retorna*/
	public static Animal animalAleatorio() {
		Animal tipo = Animal.values()[(int) (Math.random() * SIZE)];;
		while(tipo.asignado) { //mientras este asignado genera otro
			tipo = Animal.values()[(int) (Math.random() * SIZE)];
		}
		tipo.asignado = true;
		
		return tipo;
	}
}
