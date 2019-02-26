package modelo;

public class Tablero {

	//clase que generará el tablero para interactuar con el
	private final int FILAS;
	private final int COLUMNAS;
	private final int numParejas;
	public Casilla[][] tablero;
	
	//constructores
	public Tablero() {
		FILAS = 0;
		COLUMNAS = 0;
		numParejas = (FILAS*COLUMNAS)/2;
		tablero = new Casilla[FILAS][COLUMNAS];
	}
	
	public Tablero(int f, int c) {
		FILAS = f;
		COLUMNAS = c;
		numParejas = (FILAS*COLUMNAS)/2;
		tablero = new Casilla[FILAS][COLUMNAS];
	}

	//guetters y setters
	public int getNumParejas() {
		return numParejas;
	}

	public int getFILAS() {
		return FILAS;
	}

	public int getCOLUMNAS() {
		return COLUMNAS;
	}
	
	public Casilla[][] getTablero(){
		return tablero;
	}
	
	//metodos
	public void init() {
		Coordenada[] coords = new Coordenada[2];
		Aleatorios al = new Aleatorios();
		Animal tipo;
		
		for(int a = 0; a < numParejas; a++) {
			tipo = Animal.animalAleatorio();
			coords[0] = al.quitaElemento(); //tengo c1 de la pareja
			coords[1] = al.quitaElemento(); //tengo c2 de la pareja
			tablero[coords[0].x][coords[0].y] = new Casilla(coords[0],tipo); //tablero en x,y de c1 tiene a c1
			tablero[coords[1].x][coords[1].y] = new Casilla(coords[1],tipo); //tablero en x,y de c2 tiene a c2
		}
	}
}
