package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import modelo.Casilla;
import modelo.NoEsPar;
import modelo.Tablero;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JuegoGrafico {

	private JFrame ventanaJuego;
	private Tablero juego;
	private JPanel panelCeldas;
	private JPanel panelSuperior;
	private Listener listener;

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
		
		listener = new Listener();
		ventanaJuego = new JFrame();
		ventanaJuego.setTitle("Juega a las parejas");
		ventanaJuego.setBounds(100, 100, 450, 300);
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
		
		@Override
		public void mouseClicked(MouseEvent pEvento) {
			if (pEvento.getSource() instanceof Boton) { // si la fuente del evento es de un boton
				Boton b = (Boton) pEvento.getSource(); // casteo la fuente del evento a boton
				System.out.println("animal: " + juego.tablero[b.getX()][b.getY()].getAnimal()
						+ "pareja: " + juego.tablero[b.getX()][b.getY()].getCoordPareja().getX() + 
						", " + juego.tablero[b.getX()][b.getY()].getCoordPareja().getY());
			}

		}

		@Override
		public void mouseEntered(MouseEvent pEvento) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent pEvento) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent pEvento) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent pEvento) {
			// TODO Auto-generated method stub

		}

	}

	private void inicializarTablero() {
		for (int i = 0; i < juego.getFILAS(); i++) {
			for (int j = 0; j < juego.getCOLUMNAS(); j++) {
				Boton b = new Boton(i, j);
				b.addMouseListener(listener);
				panelCeldas.add(b);
			}
		}
	}

}
