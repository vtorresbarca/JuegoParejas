package modelo;

public class Tablero {

	// clase que generará el tablero para interactuar con el
	private static int FILAS;
	private static int COLUMNAS;
	private int numParejas;
	public Casilla[][] tablero;
	private int parejasDescubiertas; //va contando las parejas descubiertas
	
	// constructor

	public Tablero(int f, int c) throws NoEsPar {
		if ((f % 2 != 0) || (c % 2 != 0)) { // si son impares uno de los dos no puedo formar el tablero
			throw new NoEsPar("Las dimensiones del tablero deben ser pares");
		} else {
			FILAS = f;
			COLUMNAS = c;
			numParejas = (FILAS * COLUMNAS) / 2;
			tablero = new Casilla[FILAS][COLUMNAS];
		}
	}

	// guetters y setters
	public int getNumParejas() {
		return numParejas;
	}

	public int getFILAS() {
		return FILAS;
	}

	public int getCOLUMNAS() {
		return COLUMNAS;
	}

	public void setParejasDescubiertas() {
		this.parejasDescubiertas++;
	}
	
	
	
	/**
	 * Crea un duplicado del objeto Tablero creado por el usuario
	 * 
	 * @return objeto de tipo Tablero
	 */
	public static Tablero creaDuplicado() {
		try {
			return new Tablero(FILAS, COLUMNAS);
		} catch (NoEsPar e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// metodos

	/** Método que genera las parejas y las coloca en el tablero */
	public void init() {
		Coordenada[] coords = new Coordenada[2];
		Aleatorios al = new Aleatorios();
		String tipo;
		Animal animales = new Animal();

		for (int a = 0; a < numParejas; a++) {
			tipo = animales.animalAleatorio();
			coords[0] = al.quitaElemento(); // tengo c1 de la pareja
			coords[1] = al.quitaElemento(); // tengo c2 de la pareja
			Casilla c1 = new Casilla(coords[0], tipo);
			c1.setCoordPareja(coords[1]);
			Casilla c2 = new Casilla(coords[1], tipo);
			c2.setCoordPareja(coords[0]);
			tablero[coords[0].x][coords[0].y] = c1; // tablero en x,y de c1 tiene a c1
			tablero[coords[1].x][coords[1].y] = c2; // tablero en x,y de c2 tiene a c2
		}
	}
	
	/**Método que retorna true si el usuario ha ganado el juego o false si no*/
	public boolean gano() {
		return parejasDescubiertas == numParejas;
	}
}
