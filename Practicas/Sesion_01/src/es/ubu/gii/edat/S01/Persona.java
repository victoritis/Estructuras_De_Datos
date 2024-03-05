package es.ubu.gii.edat.S01;

public class Persona {
	  private String nombre, apellido;
	    private Integer edad;
	 
	    
	    public Persona(String nombre, String apellido,int edad) {
	        this.setNombre(nombre);
	        this.setApellido(apellido);
	        this.edad = edad;
	    }
	 
	 
	    public String toString() {
	        return getNombre() + " " + getApellido() +"(" + edad +")";
	    }


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Integer getEdad() {
			return edad;
		}


		public void setEdad(int edad) {
			this.edad = edad;
		}

		public String getApellido() {
			return apellido;
		}


		public void setApellido(String apellido) {
			this.apellido = apellido;
		}



}
