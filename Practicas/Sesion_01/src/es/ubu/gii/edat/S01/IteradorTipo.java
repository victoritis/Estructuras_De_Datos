package es.ubu.gii.edat.S01;

import java.util.Comparator;
import java.util.Iterator;

public class IteradorTipo <E> implements Iterator<E>{
	Iterator<E> itaux;
	private Object objaux;
	Comparator<Object> compaux;
	private boolean boolcomparable;
	private Object objaux2;


	public IteradorTipo (Iterator<E> it,Object obj, Comparator<Object> comp){
		itaux=it;
		objaux=obj;
		compaux=comp;
		if (objaux instanceof Comparable)
			boolcomparable = true;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public boolean hasNext() {
		boolean boolencontrado=false;

		if (boolcomparable){
			if (compaux==null){
				while (itaux.hasNext() && boolencontrado==false){
					objaux2 = itaux.next();

					if (objaux2 != null && objaux.getClass().equals(objaux2.getClass())) {
						if (((Comparable<Object>) objaux).compareTo(objaux2)>=0){						
							boolencontrado=true;
						}
					}
				}  
			}else{
				while (itaux.hasNext() && boolencontrado==false){
					objaux2 = itaux.next();
					if (objaux2 != null && objaux.getClass().equals(objaux2.getClass())) {
						if (compaux.compare(objaux,objaux2)>=0){
							boolencontrado=true;
						}
					}
				}
			}

		}else{
			while (itaux.hasNext() && boolencontrado==false){
				objaux2 = itaux.next();
				if (objaux2 != null && objaux.getClass().equals(objaux2.getClass())) {
					boolencontrado=true;
				}
			}
		}
		return boolencontrado;
	}


	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		// TODO Auto-generated method stub
		return (E) objaux2;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("No soportado.");

	}


}
