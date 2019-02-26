package modelo;

public class Pruebas {

	public static void main(String[] args) {
		Tablero t = new Tablero(4,4);
		t.init();
		for (int i = 0; i < t.getFILAS(); i++) {
			for (int j = 0; j < t.getCOLUMNAS(); j++) {
				System.out.print(t.tablero[i][j].getAnimal());
			}
			System.out.println();
		}
	}

}
