package modelo;

public class Casilla {
	//clase de la que está formada el tablero del juego y lleva las coordenadas
	private String rutaImagen;
	private Coordenada coordPareja; //el objeto coordenada que guarde la posicion de su pareja
	private String tipoAnimal;
	
	public Casilla(Coordenada c, String tipo) {
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
	
	public String getAnimal() {
		return this.tipoAnimal;
	}
}
