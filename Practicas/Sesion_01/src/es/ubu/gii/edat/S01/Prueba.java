/**
 * Programa que prueba los métodos de la clase {@code Colecciones}.
 * 
 * Al ejecutarse con las aserciones habilitadas (opci�n -ea o -enableassertions
 * de la m�quina virtual), no deber�a saltar ninguna.
 */
package es.ubu.gii.edat.S01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Clase que prueba los m�todos de la clase {@code Colecciones}.
 * 
 * @author Prof. EDAT
 * 
 */
public class Prueba {

	    
	public static void main( String ... args ) {
        //List<Persona> personas 
		//Collection<PersonaComparable>
		//List<PersonaComparable> col1 
		/*
		Collection<PersonaComparable> col1 = new ArrayList<PersonaComparable>(Arrays.asList(
                        new PersonaComparable("Oscar", "Pereiro", 34),
                        new PersonaComparable("Oscar", "Andres", 32),
                        new PersonaComparable("Aaron", "Martin",21),
                        new PersonaComparable("Pepe", "Reina" , 22),
                        new PersonaComparable("Rodri", "Alta", 20),
                        new PersonaComparable("Juan", "Baja", 19),
                        new PersonaComparable("Rodrigo", "Rodriguez",23)
                    ));
        */
		Collection<Persona> col1 = new ArrayList<Persona>(Arrays.asList(
                new Persona("Oscar", "Pereiro", 34),
                new Persona("Oscar", "Andres", 32),
                new Persona("Aaron", "Martin",21),
                new Persona("Pepe", "Reina" , 22),
                new Persona("Rodri", "Alta", 20),
                new Persona("Juan", "Baja", 19),
                new Persona("Rodrigo", "Rodriguez",23)
            ));
       // Comparator<PersonaComparable> comparador =  new ComparaPersonasEdad();
 
        System.out.printf( "%s%n", col1 );
     // Creamos un iterador en el rango 0,10 sobre un array
     		
        IteradorTipo<Persona> iterador = new IteradorTipo<Persona>(col1.iterator(), new Persona("Oscar", "Pereiro", 34),null);
     // Recorremos con el iterador acumulando en la cadena, comprobamos el valor de ésta
     		String cadena; 
     		for( cadena = ""; iterador.hasNext(); cadena += iterador.next() + " " );
     		System.out.println(cadena );
     	
    		Collection<PersonaComparable> col2 = new ArrayList<PersonaComparable>(Arrays.asList(
                    new PersonaComparable("Oscar", "Pereiro", 34),
                    new PersonaComparable("Oscar", "Andres", 32),
                    new PersonaComparable("Aaron", "Martin",21),
                    new PersonaComparable("Pepe", "Reina" , 22),
                    new PersonaComparable("Rodri", "Alta", 20),
                    new PersonaComparable("Juan", "Baja", 19),
                    new PersonaComparable("Rodrigo", "Rodriguez",23)
                ));
    		
    		 IteradorTipo<PersonaComparable> iterador2 = new IteradorTipo<PersonaComparable>(col2.iterator(), new PersonaComparable("Oscar", "Pereiro", 34),null);
    		cadena="";
     		for( cadena = ""; iterador2.hasNext(); cadena += iterador2.next() + " " );
     		System.out.println(cadena );
     		

   		 IteradorTipo<PersonaComparable> iterador3 = new IteradorTipo<PersonaComparable>(col2.iterator(), new PersonaComparable("Oscar", "Pereiro", 34),new ComparaPersonasEdad<Object>());
   		cadena="";
    		for( cadena = ""; iterador3.hasNext(); cadena += iterador2.next() + " " );
    		System.out.println(cadena );
        
        //Collections.sort(col1 );
        //System.out.printf( "Despues: %s%n",  col1 );
        //Collections.sort(col1,  comparador );
        //System.out.printf( "Despues: %s%n",  col1 );
        
    }
}
