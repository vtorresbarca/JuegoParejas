package modelo;

import java.util.ArrayList;
import java.util.Random;

public class Animal {
	
	private ArrayList<String> animales = new ArrayList<String>();
	
	//constructor
	public Animal() {
		addAnimales();
	}
	
	/**Genera un animal aleatorio de la lista y lo retorna. Una vez retornado, ese valor es descartado
	 * @return String animal*/
	public String animalAleatorio() {
		int index;
		String valorARetornar;
		
		index = (int) (Math.random() * animales.size());
		valorARetornar = animales.get(index);
		animales.remove(index);
		
		return valorARetornar;	
	}
	
	/**Llena la lista de animales con diferentes valores*/
	private void addAnimales() {
		String[] lista = {"gato", "perro", "buho", "caballo", "ardilla", "pez", "vaca",
				"leon", "mono", "pato", "gallina", "tortuga", "tigre", "cangrejo", "ciervo",
				"oso", "cocodrilo", "rana", "jirafa", "canguro"};
		
		for (int i = 0; i < lista.length; i++) {
			animales.add(lista[i]);
		}
	}
}
