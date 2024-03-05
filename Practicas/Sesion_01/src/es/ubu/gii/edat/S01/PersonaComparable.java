package es.ubu.gii.edat.S01;

public class  PersonaComparable  extends Persona implements Comparable <PersonaComparable> {
   
	public PersonaComparable(String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
		
	}
    
 
    public boolean equals(Persona n) {             
            return n.getNombre().equals(super.getNombre()) &&
            n.getApellido().equals(super.getApellido());
        }
 

  	@Override
	public int compareTo(PersonaComparable o) {
		// TODO Auto-generated method stub
		 PersonaComparable n = (PersonaComparable)o;
	        int lastCmp = getApellido().compareTo(n.getApellido());
	        return (lastCmp!=0 ? lastCmp : getNombre().compareTo(n.getNombre()));
	      
	}
}
