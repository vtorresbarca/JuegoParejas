package modelo;

import java.util.ArrayList;

public class Aleatorios {

	// clase que va a tener todas las coordenadas posibles y me da una aleatoria de
	// la lista
	private Tablero t = Tablero.creaDuplicado();
	private static ArrayList<Coordenada> lista = new ArrayList<Coordenada>();
	private int filas = t.getFILAS();
	private int columnas = t.getCOLUMNAS();
	
	public Aleatorios() {
		llenarLista();
	}

	/**
	 * Este metodo llena el arraylist de objetos coordenada con las coordenadas
	 * posibles del tablero
	 */
	public void llenarLista() {
		for (int a = 0; a < filas; a++) {
			for (int b = 0; b < columnas; b++) {
				lista.add(new Coordenada(a, b));
			}
		}
	}

	/**
	 * Método que retorna un objeto Coordenada de nuestra lista y lo borra
	 * 
	 * @return un objeto Coordenada de la lista
	 */
	public Coordenada quitaElemento() {
		int index = 0;
		Coordenada coord;
		
		index = numAleatorio(lista.size()); // genero numero
		coord = lista.get(index); // pillo el indice de la lista y lo guardo
		lista.remove(index); // lo descarto de la lista

		return coord;
	}

	/**
	 * Retorna un numero aleatorio entre 0 y el limite establecido
	 * 
	 * @return int numero entero aleatorio
	 */
	public static int numAleatorio(int limite) {
		return (int) (Math.random() * limite);
	}
}
