package es.ubu.gii.edat.S01;

import java.util.Comparator;


public class ComparaPersonasEdad <E> implements Comparator <E> {

	@Override
	public int compare(E persona1, E persona2) {
		return  ((PersonaComparable) persona1).getEdad() - ((PersonaComparable) persona2).getEdad();		
	}

}
