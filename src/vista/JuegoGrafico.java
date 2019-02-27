package vista;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import modelo.Casilla;
import modelo.NoEsPar;
import modelo.Tablero;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JuegoGrafico {

	private JFrame ventanaJuego;
	private Tablero juego;
	private JPanel panelCeldas;
	private JPanel panelSuperior;
	private Listener listener;
	private final String RUTA = "F:\\Primero\\Programacion\\Proyectos\\JuegoParejas\\src\\imagenes\\";
	private Victoria ventanaVictoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoGrafico window = new JuegoGrafico();
					window.ventanaJuego.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JuegoGrafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			juego = new Tablero(4, 4);
			juego.init();
		} catch (NoEsPar e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ventanaVictoria = new Victoria();
		listener = new Listener();
		ventanaJuego = new JFrame();
		ventanaJuego.setTitle("Juega a las parejas");
		ventanaJuego.setBounds(600, 900, 900, 800);
		ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaJuego.getContentPane().setLayout(new BorderLayout(0, 0));
		// panel que llevara botones
		panelSuperior = new JPanel();
		ventanaJuego.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(null);

		// panel que constituye el tablero
		panelCeldas = new JPanel();
		panelCeldas.setLayout(new GridLayout(juego.getFILAS(), juego.getCOLUMNAS()));
		inicializarTablero();
		ventanaJuego.getContentPane().add(panelCeldas, BorderLayout.CENTER);
	}

	// creo una clase para implementar el mouse listener y añadirla dinamicamente a
	// los botones
	class Listener implements MouseListener {
		Casilla[][] t = juego.tablero;
		int click = 0; // un contador para saber cuantos clicks ha hecho
		int xActual;
		int yActual;
		int xAnterior;
		int yAnterior;

		@Override
		public void mouseClicked(MouseEvent pEvento) {
			if (pEvento.getSource() instanceof Boton) { // si la fuente del evento es de un boton
				Boton b = (Boton) pEvento.getSource(); // casteo la fuente del evento a boton
				click++;
				xAnterior = xActual;
				yAnterior = yActual;
				// sumo un click, la pongo fija y cojo las coordenadas de su pareja
				t[b.getX()][b.getY()].setPickeada(true);
				xActual = b.getX();
				yActual = b.getY();

			}
			if (click == 2 & (t[xActual][yActual].getAnimal().equals(t[xAnterior][yAnterior].getAnimal()))
					& t[xActual][yActual] != t[xAnterior][yAnterior]) {
				// ha acertado, las fijo y reseteo los clicks
				t[xActual][yActual].setFija(true);
				t[xAnterior][yAnterior].setFija(true);
				t[xActual][yActual].setPickeada(true);
				t[xAnterior][yAnterior].setPickeada(true);
				click = 0;
				juego.setParejasDescubiertas();
				if (juego.gano()) { // compruebo si ha ganado
					actualizaTablero();
					ventanaVictoria.setModal(true);
					ventanaVictoria.setVisible(true);
					/*if(ventanaVictoria.volverJugar) {
						//juego.init(); //tiene fallos
						//inicializarTablero();
					}*/
				}
			} else if (click == 2 & !(t[xActual][yActual].getAnimal().equals(t[xAnterior][yAnterior].getAnimal()))
					& t[xActual][yActual] != t[xAnterior][yAnterior]) { //siempre que no sea la misma casilla
				// ha fallado, reseteo click y oculto la casilla de nuevo
				t[xActual][yActual].setFija(false);
				t[xAnterior][yAnterior].setFija(false);
				t[xActual][yActual].setPickeada(false);
				t[xAnterior][yAnterior].setPickeada(false);
				click = 0;
			}
		
			actualizaTablero();
		}

		@Override
		public void mouseEntered(MouseEvent pEvento) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent pEvento) {

		}

		@Override
		public void mousePressed(MouseEvent pEvento) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent pEvento) {
			// evento producido cuando suelto el ratón
		}

	}

	/** Inicia el tablero */
	private void inicializarTablero() {
		
		Component[] tableroVista = panelCeldas.getComponents(); // recojo el tablero de botones para iterarlo
		for (Component comp : tableroVista) { // itero
			if (comp instanceof Boton) { // me aseguro que el componente sea un boton
				Boton boton = (Boton) comp;
				panelCeldas.remove(boton);
			}
		}
		
		for (int i = 0; i < juego.getFILAS(); i++) {
			for (int j = 0; j < juego.getCOLUMNAS(); j++) {
				Boton b = new Boton(i, j);
				b.addMouseListener(listener);
				panelCeldas.add(b);
			}
		}
	}

	/** Actualiza el tablero */
	private void actualizaTablero() {
		Component[] tableroVista = panelCeldas.getComponents(); // recojo el tablero de botones para iterarlo
		for (Component comp : tableroVista) { // itero
			if (comp instanceof Boton) { // me aseguro que el componente sea un boton
				Boton b = (Boton) comp; // lo casteo a boton
				if (juego.tablero[b.getX()][b.getY()].getFija() || juego.tablero[b.getX()][b.getY()].getPickeada()) {
					aplicaImagen(b);
					if(juego.tablero[b.getX()][b.getY()].getFija())
						b.removeMouseListener(listener);
				}else
					b.setIcon(null);
			}
		}
	}

	/**
	 * Ajusta la imagen a una medida estándar para todas
	 * 
	 * @return ImageIcon
	 */
	private ImageIcon ajustaImagen(String imagen) {
		ImageIcon icon = new ImageIcon(imagen); // creo un imageIcon
		Image img = icon.getImage(); // convertimos el icon en una imagen
		Image otraimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // creamos una imagen nueva
																						// dándole las dimensiones que
																						// queramos a la antigua
		ImageIcon iconRetorno = new ImageIcon(otraimg); // creo el icon de retorno ya con la imagen redimensionada

		return iconRetorno;
	}

	/** Le aplica una imagen del animal que tenga esa casilla */
	private void aplicaImagen(Boton b) {
		b.setIcon(ajustaImagen(RUTA + juego.tablero[b.getX()][b.getY()].getAnimal() + ".jpg"));
	}

	public String getRuta() {
		return RUTA;
	}

}
