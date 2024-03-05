package es.ubu.gii.edat.S01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;

public class TestIteratorTipo {
	static String cadena;
	static String cadenaiterador;

	//Voy a crear un mÉtodo para probar

	@Test
	public void testCollection(){

		Collection<Persona> col = new ArrayList<Persona>(Arrays.asList(
				new Persona("Oscar", "Pereiro", 34),
				new Persona("Oscar", "Andres", 32),
				new Persona("Aaron", "Martin",21),
				new Persona("Pepe", "Reina" , 22),
				new Persona("Rodri", "Alta", 20),
				new Persona("Juan", "Baja", 19),
				new Persona("Rodrigo", "Rodriguez",23)
				));

		cadena = "[Oscar Pereiro(34), Oscar Andres(32), Aaron Martin(21), Pepe Reina(22), Rodri Alta(20), Juan Baja(19), Rodrigo Rodriguez(23)]"; 
		assertTrue (cadena.equals(col.toString()));
	}

	//Compruebo la iteración a partir de un objeto no comparable
	@Test
	public void testIteradorObjetoNoComparable(){

		Collection<Persona> col = new ArrayList<Persona>(Arrays.asList(
				new Persona("Oscar", "Pereiro", 34),
				new Persona("Oscar", "Andres", 32),
				new Persona("Aaron", "Martin",21),
				new Persona("Pepe", "Reina" , 22),
				new Persona("Rodri", "Alta", 20),
				new Persona("Juan", "Baja", 19),
				new Persona("Rodrigo", "Rodriguez",23)
				));

		IteradorTipo<Persona> iterador = new IteradorTipo<Persona>(col.iterator(), new Persona("Oscar", "Pereiro", 34),null);

		for( cadenaiterador = "["; iterador.hasNext(); cadenaiterador += iterador.next() + " " );

		cadenaiterador += "]";

		cadena = "[Oscar Pereiro(34) Oscar Andres(32) Aaron Martin(21) Pepe Reina(22) Rodri Alta(20) Juan Baja(19) Rodrigo Rodriguez(23) ]";
		assertTrue (cadena.equals(cadenaiterador));
	}
	
	//Compruebo la iteración a partir de un objeto comparable, caso por defecto, sin comparador
	@Test
	public void testIteradorObjetoComparablePorDefecto(){


		Collection<PersonaComparable> col = new ArrayList<PersonaComparable>(Arrays.asList(
				new PersonaComparable("Oscar", "Pereiro", 34),
				new PersonaComparable("Oscar", "Andres", 32),
				new PersonaComparable("Aaron", "Martin",21),
				new PersonaComparable("Pepe", "Reina" , 22),
				new PersonaComparable("Rodri", "Alta", 20),
				new PersonaComparable("Juan", "Baja", 19),
				new PersonaComparable("Rodrigo", "Rodriguez",23)
				));

		IteradorTipo<PersonaComparable> iterador = new IteradorTipo<PersonaComparable>(col.iterator(), new PersonaComparable("Oscar", "Pereiro", 34),null);

		for( cadenaiterador = "["; iterador.hasNext(); cadenaiterador += iterador.next() + " " );

		cadenaiterador+="]";
		cadena= "[Oscar Pereiro(34) Oscar Andres(32) Aaron Martin(21) Rodri Alta(20) Juan Baja(19) ]";
		assertTrue (cadena.equals(cadenaiterador));
	}

	//Compruebo la iteración a partir de un objeto comparable con comparador
	@Test
	public void testIteradorObjetoComparableConComparador(){

		Collection<PersonaComparable> col = new ArrayList<PersonaComparable>(Arrays.asList(
				new PersonaComparable("Oscar", "Pereiro", 34),
				new PersonaComparable("Oscar", "Andres", 32),
				new PersonaComparable("Aaron", "Martin",21),
				new PersonaComparable("Pepe", "Reina" , 22),
				new PersonaComparable("Rodri", "Alta", 20),
				new PersonaComparable("Juan", "Baja", 19),
				new PersonaComparable("Rodrigo", "Rodriguez",23)
				));
		@SuppressWarnings("unchecked")
		IteradorTipo<PersonaComparable> iterador = new IteradorTipo(col.iterator(), new PersonaComparable("Rodri", "Alta", 20), new ComparaPersonasEdad<PersonaComparable>());

		for( cadenaiterador = "["; iterador.hasNext(); cadenaiterador += iterador.next() + " " );
		cadenaiterador+="]";
		cadena="[Rodri Alta(20) Juan Baja(19) ]";
		assertTrue (cadena.equals(cadenaiterador));
	}

	//Compruebo la iteración a partir de un objeto no comparable con una coleccion de objetos heterogoneos
	@Test
	public void testIteradorObjetoNoComparable2(){

		Collection<Object> col = new ArrayList<Object>(Arrays.asList(
				new PersonaComparable("Oscar", "Pereiro", 34),
				new Persona("Oscar", "Andres", 32),
				null,
				new PersonaComparable("Pepe", "Reina" , 22),
				new Persona("Rodri", "Alta", 20),
				new PersonaComparable("Juan", "Baja", 19),
				new PersonaComparable("Rodrigo", "Rodriguez",23)
				));

		IteradorTipo<Object> iterador = new IteradorTipo<Object>(col.iterator(), new Persona("Oscar", "Pereiro", 34),null);

		for( cadenaiterador = "["; iterador.hasNext(); cadenaiterador += iterador.next() + " " );

		cadenaiterador += "]";

		cadena="[Oscar Andres(32) Rodri Alta(20) ]";
		assertTrue (cadena.equals(cadenaiterador));
	}

	//Compruebo la iteración a partir de un objeto comparable, caso por defecto, sin comparador 
	@Test
	public void testIteradorObjetoComparablePorDefecto2(){
		Collection<Object> col = new ArrayList<Object>(Arrays.asList(
				new PersonaComparable("Oscar", "Pereiro", 34),
				new Persona("Oscar", "Andres", 32),
				null,
				new PersonaComparable("Pepe", "Reina" , 22),
				new Persona("Rodri", "Alta", 20),
				new PersonaComparable("Juan", "Baja", 19),
				new PersonaComparable("Rodrigo", "Rodriguez",23)
				));
		Persona p = new PersonaComparable("Rodri", "Alta", 20);
		IteradorTipo<Object> iterador = new IteradorTipo<Object>(col.iterator(), p,null);

		for( cadenaiterador = "["; iterador.hasNext(); cadenaiterador += iterador.next() + " " );
		cadenaiterador += "]";

		cadena="[]";
		assertTrue (cadena.equals(cadenaiterador));
	}
	
	//Compruebo la iteración a partir de un objeto comparable con comparador
	@Test
	public void testIteradorObjetoComparableConComparador2(){

		Collection<Object> col = new ArrayList<Object>(Arrays.asList(
				new PersonaComparable("Oscar", "Pereiro", 34),
				new Persona("Oscar", "Andres", 32),
				null,
				new PersonaComparable("Pepe", "Reina" , 22),
				new Persona("Rodri", "Alta", 20),
				new PersonaComparable("Juan", "Baja", 19),
				new PersonaComparable("Rodrigo", "Rodriguez",23)
				));
		Persona p = new PersonaComparable("Rodri", "Caderon", 25);
		IteradorTipo<Object> iterador = new IteradorTipo<Object>(col.iterator(), p, new ComparaPersonasEdad<Object>());

		for( cadenaiterador = "["; iterador.hasNext(); cadenaiterador += iterador.next() + " " );
		cadenaiterador += "]";

		cadena="[Pepe Reina(22) Juan Baja(19) Rodrigo Rodriguez(23) ]";
		assertTrue (cadena.equals(cadenaiterador));
	}

}
