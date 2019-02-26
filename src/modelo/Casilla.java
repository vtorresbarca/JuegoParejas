package modelo;

public class Casilla {
	//clase de la que está formada el tablero del juego y lleva las coordenadas
	private String rutaImagen;
	private Coordenada coordPareja; //el objeto coordenada que guarde la posicion de su pareja
	private Animal tipoAnimal;
	
	public Casilla(Coordenada c, Animal tipo) {
		coordPareja = c;
		tipoAnimal = tipo;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public Coordenada getCoordPareja() {
		return coordPareja;
	}

	public void setCoordPareja(Coordenada coordPareja) {
		this.coordPareja = coordPareja;
	}
	
	public Animal getAnimal() {
		return this.tipoAnimal;
	}
}
