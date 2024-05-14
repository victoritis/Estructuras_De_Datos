package es.ubu.inf.edat.p02_2324;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ColaMixta<E> extends AbstractQueue<E> {

	protected class NodoMixto extends AbstractQueue<E>{

		private List<E> contenido;
		private NodoMixto siguiente;

		public NodoMixto() {
			contenido = new ArrayList<E>(tamañoNodo);
			siguiente = null;
		}

		@Override
		public Iterator<E> iterator() {
			return contenido.iterator();
		}

		@Override
		public int size() {
			return contenido.size();
		}

		public boolean estaLleno() {
			return contenido.size() >= tamañoNodo;
		}

		public boolean add(E e) {
			if (this.estaLleno()) {
				return false;
			}
			contenido.add(e);
			return true;
		}

		@Override
		public boolean offer(E e) {
			return false;
		}

		public E remove() {
			return contenido.remove(0);
		}

		@Override
		public E poll() {
			return null;
		}

		@Override
		public E peek() {
			return null;
		}
	}

	private NodoMixto inicio;
	private NodoMixto fin;
	private int tamañoNodo;
	private int tamañoLista;

	public ColaMixta(int tamañoNodo) {
		this.tamañoNodo = tamañoNodo;
		inicio = fin = new NodoMixto();
	}

	@Override
	public boolean offer(E e) {
		if (fin.estaLleno()) {
			NodoMixto nuevoNodo = new NodoMixto();
			fin.siguiente = nuevoNodo;
			fin = nuevoNodo;
		}
		fin.add(e);
		return true;
	}

	@Override
	public E poll() {
		if (isEmpty()) {
			return null;
		}
		E elemento = inicio.remove();
		if (inicio.contenido.isEmpty()) {
			inicio = inicio.siguiente;
		}
		return elemento;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		return inicio.contenido.get(0);
	}

	@Override
	public Iterator<E> iterator() {
		return new IteradorMixto();
	}

	@Override
	public int size() {
		int count = 0;
		NodoMixto actual = inicio;
		while (actual != null) {
			count += actual.contenido.size();
			Parte 1:
			Parámetros de entrada: Coeficientes de un polinomio en base canónica que no tenga raíces de
			tangente horizontal. Un intervalo
			Parámetros de salida: subintervalos de longitud menor que 0.1 que contengan a cada una de las
			raíces del polinomio que haya en el intervalo de partida.
			Parte 2:
			Parámetros de salida: aproximaciones menores que 10^-6 a cada una de las raíces del polinomio en
			el intervalo de partida			actual = actual.siguiente;
		}
		return count;
	}

	public E peek(int index) {
		if (index < 0 || index >= size()) {
			return null;
		}
		NodoMixto nodoActual = inicio;
		int contador = index / tamañoNodo;
		while (contador > 0 && nodoActual.siguiente != null) {
			nodoActual = nodoActual.siguiente;
			contador--;
		}
		if (contador == 0) {
			return nodoActual.contenido.get(index % tamañoNodo);
		}
		return null;
	}

	private class IteradorMixto implements Iterator<E> {

		private NodoMixto actual;
		private Iterator<E> iterador;

		public IteradorMixto() {
			actual = inicio;
			if (actual != null) {
				iterador = actual.contenido.iterator();
			}
		}

		@Override
		public boolean hasNext() {
			if (iterador == null) {
				return false;
			}
			return iterador.hasNext() || actual.siguiente != null;
		}

		@Override
		public E next() {
			if (!iterador.hasNext() && actual.siguiente != null) {
				actual = actual.siguiente;
				iterador = actual.contenido.iterator();
			}
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return iterador.next();
		}
	}
}
