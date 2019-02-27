package vista;

import javax.swing.JButton;

public class Boton extends JButton{

	private int x;
	private int y;
	
	public Boton(int i, int j) {
		this.x = i;
		this.y = j;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
