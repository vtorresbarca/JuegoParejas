package modelo;

public class Casilla {
	//clase de la que está formada el tablero del juego y lleva las coordenadas
	private boolean pickeada = false; //para saber si se ha pulsado
	private boolean fija = false; //para fijar la casilla
	private Coordenada coordPareja; //el objeto coordenada que guarde la posicion de su pareja
	private String tipoAnimal;
	
	public Casilla(Coordenada c, String tipo) {
		coordPareja = c;
		tipoAnimal = tipo;
	}

	//guetters y setters
	public boolean getPickeada() {
		return pickeada;
	}

	public void setPickeada(boolean estado) {
		this.pickeada = estado;
	}
	
	public Coordenada getCoordPareja() {
		return coordPareja;
	}

	public void setCoordPareja(Coordenada coordPareja) {
		this.coordPareja = coordPareja;
	}
	
	public String getAnimal() {
		return this.tipoAnimal;
	}

	public boolean getFija() {
		return fija;
	}
	
	public void setFija(boolean estado) {
		fija = estado;
	}
}
